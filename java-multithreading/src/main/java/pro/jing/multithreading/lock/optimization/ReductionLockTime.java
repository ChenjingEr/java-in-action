package pro.jing.multithreading.lock.optimization;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import pro.jing.util.ConcurrentPerformanceTestTool;

/**
 * @author JING
 * @Date 2018年6月24日
 * @description 减少锁持有的时间
 */
public class ReductionLockTime {

	public static void main(String[] args) {
		int taskCount = 300;
		Lock lock = new ReentrantLock();
//		ConcurrentPerformanceTestTool tool = new ConcurrentPerformanceTestTool(10, 20, 0, TimeUnit.SECONDS,
//				new LinkedBlockingQueue<>());
//		tool.setPerformanceIndicators(System.currentTimeMillis(), "LongTimeTask", taskCount);
//		
//		for (int i = 0; i < taskCount; i++) {
//			tool.execute(new LongTimeTask(lock));
//		}
//		tool.shutdown();
		ConcurrentPerformanceTestTool tool2 = new ConcurrentPerformanceTestTool(10, 20, 0, TimeUnit.SECONDS,
				new LinkedBlockingQueue<>());
		tool2.setPerformanceIndicators(System.currentTimeMillis(), "ShortTimeTask", taskCount);
		for (int i = 0; i < taskCount; i++) {
			tool2.execute(new LongTimeTask(lock));
		}
		tool2.shutdown();

	}
}

class LongTimeTask implements Runnable {
	private Integer count = new Integer(0);
	private Lock lock;

	public LongTimeTask(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.lock();
		try {
			Thread.sleep(100); // 使用sleep代替超时操作
			count++; // 只有这个操作需要同步
			Thread.sleep(100); // 使用sleep代替超时操作
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}
}

class ShortTimeTask implements Runnable {

	private Integer count;
	private Lock lock;

	public ShortTimeTask(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		try {

			Thread.sleep(100); // 使用sleep代替超时操作
			lock.lock();
			count++; // 只有这个操作需要同步
			lock.unlock();
			Thread.sleep(100); // 使用sleep代替超时操作

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}