package pro.jing.multithreading.pool.execute;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pro.jing.multithreading.pool.task.TaskByRunnable;

/**
 * @author JING
 * @Date 2018年6月19日
 * @description Runnable 线程执行 execute
 */
public class RunnableTaskExecute {

	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(2);
		int threadNum = 5;
		CountDownLatch cdl = new CountDownLatch(threadNum);
		
		//runnable task
		for (int i = 0; i < threadNum; i++) {
			ex.execute(new TaskByRunnable(cdl));
		}
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main end...");
	}
}
