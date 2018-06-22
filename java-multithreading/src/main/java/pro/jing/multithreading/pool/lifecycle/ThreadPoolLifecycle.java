package pro.jing.multithreading.pool.lifecycle;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import pro.jing.multithreading.pool.task.TaskByRunnable;

/**
 * @author JING
 * @Date 2018年6月19日
 * @description 线程池的生命周期
 */
public class ThreadPoolLifecycle {

	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor es = (ThreadPoolExecutor)Executors.newFixedThreadPool(3);
		int threadNum = 20;
		CountDownLatch cdl = new CountDownLatch(20);
		for (int i = 0; i < threadNum; i++) {
			es.execute(new TaskByRunnable(cdl));
		}
		System.out.println(es.isShutdown());
		System.out.println(es.isTerminated());
		System.out.println(es.getActiveCount());
		System.out.println(es.getCompletedTaskCount());
//		es.shutdown();
//		es.shutdownNow();
		cdl.await();
		System.out.println(es.getActiveCount());
		System.out.println(es.getCompletedTaskCount());
		System.out.println(es.isShutdown());
		System.out.println(es.isTerminated());
		
	}
}
