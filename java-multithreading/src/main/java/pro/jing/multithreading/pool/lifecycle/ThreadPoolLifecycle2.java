package pro.jing.multithreading.pool.lifecycle;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import pro.jing.multithreading.pool.task.TaskByRunnable;
import pro.jing.multithreading.pool.task.TaskByRunnableSimple;

/**
 * @author JING
 * @Date 2018年6月19日
 * @description 线程池的生命周期
 */
public class ThreadPoolLifecycle2 {

	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor es = (ThreadPoolExecutor)Executors.newFixedThreadPool(3);
		for (int i = 0; i < 100; i++) {
			es.execute(new TaskByRunnableSimple());
		}
		
		System.out.println(es.getActiveCount());
		System.out.println(es.getCompletedTaskCount());
		System.out.println(es.isShutdown());
		System.out.println(es.isTerminated());
		System.out.println(es.isTerminating());
		es.awaitTermination(10, TimeUnit.SECONDS);
		es.shutdown();
		System.out.println(es.getActiveCount());
		System.out.println(es.getCompletedTaskCount());
		System.out.println(es.isShutdown());
		System.out.println(es.isTerminated());
		System.out.println(es.isTerminating());		
	}
}
