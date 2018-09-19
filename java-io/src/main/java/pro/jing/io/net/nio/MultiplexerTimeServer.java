package pro.jing.io.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimeServer implements Runnable {

	private Selector selector;
	private ServerSocketChannel serverChannel;
	private volatile boolean stop = false;

	public MultiplexerTimeServer(int port) {
		try {
			// 开启多路复用
			selector = Selector.open();
			// 开启服务器监听
			serverChannel = ServerSocketChannel.open();
			serverChannel.configureBlocking(false);
			// 绑定监听端口
			serverChannel.socket().bind(new InetSocketAddress(port));
			// 绑定server到多路复用器上,监听ACCEPT事件
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("服务器启动...");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void run() {
		/*
		 * 循环遍历 selector ，休眠 1s。
		 */
		while (!stop) {
			try {
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectedKeys.iterator();
				SelectionKey key = null;

				while (it.hasNext()) {
					key = it.next();
					it.remove();

					try {
						handleInput(key);
					} catch (Exception e) {
						if (key != null) {
							key.cancel();
							if (key.channel() != null) {
								key.channel().close();
							}
						}
					}
				}

			} catch (Throwable t) {
				t.printStackTrace();
			}
		}

		// 多路复用器关闭后，所有注册在上面的Channel和Pipe等资源都会被自动去注册并关闭，所以不需要重复释放资源
		if (selector != null) {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void stop() {
		stop = true;
	}

	private void handleInput(SelectionKey key) throws IOException {

		if (key.isValid()) {
			// 处理新接入的请求消息
			if (key.isAcceptable()) {
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				SocketChannel sc = ssc.accept(); // 类型为 ACCEPT 建立 连接（相当于TCP 3 次握手），
				sc.configureBlocking(false);

				sc.register(selector, SelectionKey.OP_READ); // add the new connection to the selector

			}

			if (key.isReadable()) {
				// read the data
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024); // 1MB 的缓冲区
				int readBytes = sc.read(readBuffer); // 读取请求流
				if (readBytes > 0) {
					readBuffer.flip();// 将缓冲区当前的 limit 设置为 position , position 设置为 0 ， 用于后续对缓冲区的读取操作。

					byte[] bytes = new byte[readBuffer.remaining()]; // 根据缓冲区可读的数组复制到新创建的字节数组中
					readBuffer.get(bytes);

					String body = new String(bytes, "UTF-8");
					System.out.println("The time server receive order : " + body);
					String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)
							? new Date(System.currentTimeMillis()).toString()
							: "BAD ORDER";
					doWrite(sc, currentTime);
				} else if (readBytes < 0) {
					// 对端链路关闭
					key.cancel();
					sc.close();
				} else {
					// 读到 0 字节， 忽略
				}

			}
		}
	}

	private void doWrite(SocketChannel channel, String response) throws IOException {
		if (response != null && response.trim().length() > 0) {
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();

			channel.write(writeBuffer);
		}
	}

}
