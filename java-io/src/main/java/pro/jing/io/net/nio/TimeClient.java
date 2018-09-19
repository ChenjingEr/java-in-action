package pro.jing.io.net.nio;


public class TimeClient {

	public static void main(String[] args) {

		new Thread(new TimeClientHandle("127.0.0.1", 7474)).start();
	}

}
