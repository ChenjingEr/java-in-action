package pro.jing.multithreading.base.sync;

public class SynchronizedMethod {

	private int count = 0;

	
	public synchronized void increment() {
		count++;
		System.out.println("count --> " + count);
	}

}
