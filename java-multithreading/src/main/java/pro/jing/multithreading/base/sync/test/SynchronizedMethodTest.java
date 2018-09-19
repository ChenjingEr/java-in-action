package pro.jing.multithreading.base.sync.test;

import pro.jing.multithreading.base.sync.SynchronizedMethod;

public class SynchronizedMethodTest {

	public static void main(String[] args) {

		SynchronizedMethod sync = new SynchronizedMethod();

		for (int i = 0; i < 100; i++) {
			new Thread(new Counter(sync)).start();
		}
	}
}

class Counter implements Runnable {

	private SynchronizedMethod sync;

	public Counter(SynchronizedMethod sync) {
		this.sync = sync;
	}

	@Override
	public void run() {
		sync.increment();
	}

}
