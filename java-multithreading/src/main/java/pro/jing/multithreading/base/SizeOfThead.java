package pro.jing.multithreading.base;

import net.sf.ehcache.pool.sizeof.ReflectionSizeOf;
import net.sf.ehcache.pool.sizeof.SizeOf;

public class SizeOfThead {

	public static void main(String[] args) {
		Thread t = new Thread() {
			@Override
			public void run() {
				super.run();
			}
		};
		
		SizeOf sizeOf = new ReflectionSizeOf();
		//byte
		System.out.println(sizeOf.sizeOf(t));
	}
}
