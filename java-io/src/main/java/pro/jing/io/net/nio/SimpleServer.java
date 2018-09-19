package pro.jing.io.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


public class SimpleServer {

	public static void main(String[] args) {
		
		ServerSocketChannel serverSocketChannel = null;
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress(7474));
			
			SocketChannel clientChannel = serverSocketChannel.accept();
			System.out.println("Client Request....");
			
			ByteBuffer buf = ByteBuffer.allocate(48);
			int read = clientChannel.read(buf);
			
			buf.flip();
			byte[] b = new byte[buf.remaining()];
			buf.get(b);
			System.out.println("Client Say -> " + new String(b));
			
			buf.clear();
			buf.put("hello".getBytes());
			buf.flip();
			
			clientChannel.write(buf);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				serverSocketChannel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
