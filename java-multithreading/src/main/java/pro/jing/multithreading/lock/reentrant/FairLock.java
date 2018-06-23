package pro.jing.multithreading.lock.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable {

	private Lock lock;

	public FairLock(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " wait...");
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " get lock");
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		Lock lock = new ReentrantLock(true);
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new FairLock(lock));
			t.start();
		}
	}

}
