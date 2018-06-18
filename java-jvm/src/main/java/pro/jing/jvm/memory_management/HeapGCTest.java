package pro.jing.jvm.memory_management;

/**
 * 
 * @author JING
 * @Date 2018年6月16日
 * @description 堆中对象分布
 * vm args : -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -Xms40M -Xmx40M -Xmn20M
 */
public class HeapGCTest {

	public static void main(String[] args) {

		byte[] b1 = new byte[1024 * 1024 / 2];
		byte[] b2 = new byte[1024 * 1024 * 8];
		b2 = null;
		b2 = new byte[1024 * 1028 * 8];
		System.gc();
	}
}
