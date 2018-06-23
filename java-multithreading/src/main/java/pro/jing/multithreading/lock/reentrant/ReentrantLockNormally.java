package pro.jing.multithreading.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JING
 * @Date 2018年6月23日
 * @description 获取锁
 */
public class ReentrantLockNormally implements Runnable {

	public ReentrantLock lock;

	public ReentrantLockNormally(ReentrantLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " try lock...");
		lock.lock();
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " end...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(new ReentrantLockNormally(lock));
		Thread t2 = new Thread(new ReentrantLockNormally(lock));
		t1.start();
		t2.start();
	}

}
