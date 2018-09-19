package pro.jing.io.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NbSimpleClient {

	public static void main(String[] args) {
		SocketChannel channel = null;
		try {
			// 1.打开通道
			channel = SocketChannel.open();
			// 2.连接到服务器
			channel.connect(new InetSocketAddress("127.0.0.1",7474));
			// 3.设置非阻塞
			channel.configureBlocking(false);
			// 4.写入数据
			if(channel.isConnected()) {
				ByteBuffer buf = ByteBuffer.allocate(48);
				buf.put("hi".getBytes());
				buf.flip();
				channel.write(buf);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
