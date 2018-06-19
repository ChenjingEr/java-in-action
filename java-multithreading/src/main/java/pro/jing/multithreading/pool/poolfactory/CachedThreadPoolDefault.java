package pro.jing.multithreading.pool.poolfactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import pro.jing.multithreading.pool.task.TaskByRunnableSimple;

public class CachedThreadPoolDefault {

	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor es = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		
		for (int i = 0; i < 10; i++) {
//			Thread.sleep(10);
			es.execute(new TaskByRunnableSimple());
		}
		System.out.println(es.getActiveCount());
		es.shutdown(); 
		System.out.println(es.getActiveCount());
	}
}
