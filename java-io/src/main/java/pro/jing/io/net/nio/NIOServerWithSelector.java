package pro.jing.io.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author JING
 * @date 2018年9月8日
 * @describe Selector 使用
 */
public class NIOServerWithSelector {

	private ServerSocketChannel serverChannel;

	private Selector selector;

	public void init() {
		try {
			//1.开启服务端通道 
			serverChannel = ServerSocketChannel.open();
			//2.绑定端口
			serverChannel.socket().bind(new InetSocketAddress(7474));
			//3.设置非阻塞
			serverChannel.configureBlocking(false);
			//4.打开选择器
			selector = Selector.open();
			//5.注册一个选择器
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);

			System.out.println("NIO 初始化完毕。。。");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listener() throws IOException {
		while (true) {
			//1.开始轮询直到有1个事件发生
			selector.select();
			//2.选择已经准备好的事件
			Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
			while (iterator.hasNext()) {
				SelectionKey key = iterator.next();
				iterator.remove();
				//3.不同事件不同处理方式
				if (key.isAcceptable()) {
					accept(key);
				} else if (key.isReadable()) {
					read(key);
				} else if (key.isWritable()) {
					write(key);
				}
			}
		}
	}

	private void accept(SelectionKey key) {
		try {
			ServerSocketChannel server = (ServerSocketChannel) key.channel();
			SocketChannel channel = server.accept();
			channel.configureBlocking(false);
			channel.write(ByteBuffer.wrap(new String("I am server, I send a msg").getBytes()));
			channel.register(this.selector, SelectionKey.OP_READ);
		} catch (ClosedChannelException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void write(SelectionKey key) {
		try {
			SocketChannel channel = (SocketChannel) key.channel();
			String str = new String("server send msg to client...");
			channel.configureBlocking(false);
			channel.write(ByteBuffer.wrap(str.getBytes()));
			System.err.println("服务器write: " + str);
			channel.register(this.selector, SelectionKey.OP_READ);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void read(SelectionKey key) throws IOException {
		SocketChannel channel = (SocketChannel) key.channel();
		channel.configureBlocking(false);
		ByteBuffer buffer = ByteBuffer.allocate(100);
		channel.read(buffer);
		byte[] array = buffer.array();
		String msg = new String(array).trim();
		System.err.println("服务器read: " + msg);
		channel.register(this.selector, SelectionKey.OP_WRITE);

	}

	public static void main(String[] args) throws IOException {
		NIOServerWithSelector server = new NIOServerWithSelector();
		server.init();
		server.listener();
	}

}
