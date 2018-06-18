package pro.jing.jvm.memory_management;

import java.util.Vector;

/**
 * @author JING
 * @Date 2018年6月16日
 * @description 堆最小空间太小会发生什么？Minor GC 与 Full GC的次数
 * vm arg -Xms 
 */
public class HeapSizeSetCmp {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Vector v = new Vector();
		for (int i = 0; i <=10; i++) {
			byte[] b = new byte[1024*1024];
			v.add(b);
			if (v.size() == 3)
				v.clear();
		}
		System.out.println(System.currentTimeMillis() - start);
	}
}
