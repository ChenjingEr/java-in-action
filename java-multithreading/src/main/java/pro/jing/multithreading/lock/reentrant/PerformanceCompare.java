package pro.jing.multithreading.lock.reentrant;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import pro.jing.util.ConcurrentPerformanceTestTool;

/**
 * @author JING
 * @Date 2018年6月25日
 * @description 公平锁需要更多的线程切换
 */
public class PerformanceCompare implements Runnable {

	private Lock lock;
	
	public PerformanceCompare(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName());
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		Lock lock = new ReentrantLock(true);
		ConcurrentPerformanceTestTool tool = new ConcurrentPerformanceTestTool(2, 5, 0, TimeUnit.SECONDS,
				new LinkedBlockingQueue<>());
		tool.setPerformanceIndicators(System.currentTimeMillis(), "lock", 300);
		for ( int i = 0; i < 300; i++) {
			tool.execute(new PerformanceCompare(lock));
		}
	}

}
