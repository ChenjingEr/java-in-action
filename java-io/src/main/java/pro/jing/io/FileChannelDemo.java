package pro.jing.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

	public static void main(String[] args) {
		try {
			RandomAccessFile aFile = new RandomAccessFile(
					"F:\\practice\\java-in-action\\java-io\\target\\classes\\pro\\jing\\io\\nio-data.txt", "rw");
			FileChannel inChannel = aFile.getChannel();
			// 分配一个buffer
			ByteBuffer buf = ByteBuffer.allocate(48);
			// 从channel中读取数据到buffer
			int bytesRead = inChannel.read(buf);
			while (bytesRead != -1) {
				// 写 -> 读模式转换
				buf.flip();
				// 读出所有的字节
				while (buf.hasRemaining()) {
					System.out.print((char) buf.get());
				}
				// 逻辑清空buffer
				buf.clear();
				// 再次读取
				bytesRead = inChannel.read(buf);
			}

			buf.clear();

			String data = "\nwrite to file ..." + System.currentTimeMillis();

			buf.put(data.getBytes());
			buf.flip();
			while (buf.hasRemaining()) {
				inChannel.write(buf);
			}

			aFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
