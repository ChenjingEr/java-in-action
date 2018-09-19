package pro.jing.io.net.nio;

import java.nio.ByteBuffer;

/**
 * @author JING
 * @date 2018年9月8日
 * @describe BufferAPI 测试
 */
public class BufferAPI {
	public static void main(String[] args) {
		ByteBuffer bf = ByteBuffer.allocate(10);
		System.out.println(bf);
		byte[] b1 = { '1', '2', '3', '4', '5' };
		bf.put(b1, 0, 3);
		System.out.println("put后的ByteBuffer -> " + bf);
		System.out.println("put后的空间 (limit-position) ->" + bf.remaining());
		// 如果没有flip操作
		System.out.println("没有flip的ByteBuffer get() -> " + bf.get());
		// flip操作后，才可以获取到数据
		bf.flip();
		System.out.println("filp后的ByteBufer -> " + bf);
		System.out.println("有flip的ByteBuffer get() -> " + bf.get());
		System.out.println("读取完1个元素的ByteBuffer -> " + bf);
		System.out.println("读完1个后可以剩余的空间 ->" + bf.remaining());
		bf.rewind();
		System.out.println("rewind之后 -> " + bf.rewind());
		//读之后需要clear或compack
		bf.compact();
		System.out.println("compact之后的Buffer -> " + bf);
		bf.clear();
		System.out.println("clear之后的Buffer -> " + bf);

	}

}
