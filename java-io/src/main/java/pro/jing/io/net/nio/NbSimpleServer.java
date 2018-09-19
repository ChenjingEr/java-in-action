package pro.jing.io.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author JING
 * @date 2018年9月8日
 * @describe Channel API, Non Blocking
 */
public class NbSimpleServer {

	public static void main(String[] args) {
		ServerSocketChannel server = null;
		
		
		try {
			//1. 打开server channel
			server= ServerSocketChannel.open();
			//2. 绑定端口
			server.bind(new InetSocketAddress(7474));
			//3. 设置非阻塞
			server.configureBlocking(false);
			//4. 读取写入
			SocketChannel socketChannel = server.accept();
			while(socketChannel == null) {
				socketChannel = server.accept();
			}
			ByteBuffer buf = ByteBuffer.allocate(48);
			socketChannel.read(buf);
			buf.flip();
			System.out.println("Client Say -> " + new String(buf.array()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
