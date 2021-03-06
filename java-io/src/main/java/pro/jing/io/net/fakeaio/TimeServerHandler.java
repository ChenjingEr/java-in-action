package pro.jing.io.net.fakeaio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable {

	private Socket socket;

	public TimeServerHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		BufferedReader in = null;
		PrintWriter out = null;

		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(), true);
			String currentTime = null;
			String body = null;
			while (true) {
				body = in.readLine();
				if (body == null) {
					break;
				}

				System.out.println("Time Server Received Order : " + body);
				currentTime = "Query Time Order".equalsIgnoreCase(body)
						? new Date(System.currentTimeMillis()).toString()
						: "Bad Order";
				out.println(currentTime);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (out != null)
				out.close();
			if (in != null)
				try {
					in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			if (this.socket != null)
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}

	}

}
