package pro.jing.multithreading.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JING
 * @Date 2018年6月23日
 * @description 响应中断
 */
public class ReentrantLockInterruptly implements Runnable {

	private ReentrantLock lock;

	public ReentrantLockInterruptly(ReentrantLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			lock.lockInterruptibly();
			System.out.println(Thread.currentThread().getName() + " getLock...");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrupt...");
		} finally {
			if (lock.isHeldByCurrentThread())
				lock.unlock();
		}
	}

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new ReentrantLockInterruptly(lock));
			t.start();
			if (i % 3 == 0)
				t.interrupt();
		}
	}

}
