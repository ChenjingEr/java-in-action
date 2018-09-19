package pro.jing.io.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SimpleClient {

	public static void main(String[] args) {
		SocketChannel channel = null;;
		try {
			channel = SocketChannel.open();
			channel.connect(new InetSocketAddress("127.0.0.1", 7474));
			
			ByteBuffer buf = ByteBuffer.allocate(48);
			buf.put("hi".getBytes());
			buf.flip();
			while(buf.hasRemaining())
				channel.write(buf);
			
			buf.clear();
			
			channel.read(buf);
			buf.flip();
			System.out.println("Server Say -> " + new String(buf.array()));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				channel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
