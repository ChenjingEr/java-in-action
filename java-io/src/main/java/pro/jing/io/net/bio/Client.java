package pro.jing.io.net.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("127.0.0.1", 7474);
			socket.setSoTimeout(60000);
			PrintWriter printWrite = new PrintWriter(socket.getOutputStream(), true);
			printWrite.println("i am client...");
			printWrite.flush();

			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String result = bufferReader.readLine();
			System.out.println("server -> " + result);
			
			printWrite.close();
			bufferReader.close();
			socket.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
