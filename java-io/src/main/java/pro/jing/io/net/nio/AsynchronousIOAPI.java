package pro.jing.io.net.nio;

import java.io.IOException;
import java.nio.channels.AsynchronousServerSocketChannel;

/**
 * @author JING
 * @date 2018年9月8日
 * @describe JDK1.7 AIO API
 */
public class AsynchronousIOAPI {

	public static void main(String[] args) {
		
		try {
			AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
