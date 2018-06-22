package pro.jing.multithreading.pool.task;

import java.util.concurrent.CountDownLatch;

public class TaskByRunnable implements Runnable {
	
	private CountDownLatch cdl;
	
	public TaskByRunnable(CountDownLatch cdl) {
		this.cdl = cdl;
	}

	@Override
	public void run() {
//		System.out.println(Thread.currentThread().getName() + " running...");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cdl.countDown();
	}

}
