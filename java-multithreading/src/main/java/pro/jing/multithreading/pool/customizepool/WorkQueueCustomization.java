package pro.jing.multithreading.pool.customizepool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import pro.jing.multithreading.pool.task.TaskByRunnableSimple;

public class WorkQueueCustomization {

	public static void main(String[] args) throws InterruptedException {
		// BlockingQueue<Runnable> workqueue = new ArrayBlockingQueue<>(5); 有界队列
		// BlockingQueue<Runnable> workqueue = new LinkedBlockingQueue<>(); //无界队列
		 BlockingQueue<Runnable> workqueue = new SynchronousQueue<>(); //立即提交
		// BlockingQueue<Runnable> workqueue = new ArrayBlockingQueue<>(5); 有界队列

		// 使用default AbortPolicy
		int corePoolSize = 3;
		int maxPoolSize = 5;

		ThreadPoolExecutor ex = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 0, TimeUnit.SECONDS, workqueue);
		for (int i = 0; i < 30; i++) {
			try {
				ex.execute(new TaskByRunnableSimple());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		ex.shutdown();
		ex.awaitTermination(20, TimeUnit.SECONDS);
		System.out.println(ex.getCompletedTaskCount());
	}
}
