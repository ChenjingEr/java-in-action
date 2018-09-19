package pro.jing.io.net.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		ServerSocket server = null;
		try {
			 server = new ServerSocket(7474);

			while (true) {
				System.out.println("while...");
				Socket socket = server.accept();

				BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String result = buf.readLine();
				System.out.println("client -> " + result);
				
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				printWriter.print("hello qiqi~");
				printWriter.flush();
				printWriter.close();
				buf.close();
				socket.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			if (server != null)
				try {
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}
}
