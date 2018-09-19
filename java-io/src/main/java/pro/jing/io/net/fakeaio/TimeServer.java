package pro.jing.io.net.fakeaio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;

/**
 * @author JING
 * @date 2018年8月18日
 * @describe 消息队列+N个活跃线程实现伪异步IO编程
 */
public class TimeServer {

	public static void main(String[] args) {
		int port = 7474;
		ServerSocket server = null;

		try {
			server = new ServerSocket(port);
			TimeServerHandlerExecutePool pool = new TimeServerHandlerExecutePool(50, 10000);
			Socket client = null;
			while (true) {
				client = server.accept();
				//将接收到的请求放到任务队列待处理
				pool.execute(new TimeServerHandler(client));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
