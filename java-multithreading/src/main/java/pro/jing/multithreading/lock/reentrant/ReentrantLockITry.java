package pro.jing.multithreading.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockITry implements Runnable {

	private ReentrantLock lock;

	public ReentrantLockITry(ReentrantLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			// if (lock.tryLock(5, TimeUnit.SECONDS)) {
			if (lock.tryLock()) {
				System.out.println(Thread.currentThread().getName() + " get lock...");
				Thread.sleep(6000);
			} else
				System.out.println(Thread.currentThread().getName() + " time out...");

		} catch (InterruptedException e) {
		} finally {
			if (lock.isHeldByCurrentThread())
				lock.unlock();
		}
	}

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();

		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new ReentrantLockITry(lock));
			t.start();
		}
	}

}
