package pro.jing.multithreading.pool.customizepool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import pro.jing.multithreading.pool.task.TaskByRunnableSimple2;

public class RejectExecuteHandlerCustomization {

	public static void main(String[] args) {
		// 饱和抛出异常
		// RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
		// 直接抛弃
		// RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
		// 抛弃最旧的
		// RejectedExecutionHandler handler = new
		// ThreadPoolExecutor.DiscardOldestPolicy();
		// 直接在当前线程中运行r.run()
		RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();

		ThreadPoolExecutor es = new ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5),
				handler);

		for (int i = 0; i < 30; i++) {
			try {
				es.execute(new TaskByRunnableSimple2(String.valueOf(i)));
			} catch (Exception e) {
				// AbortPolicy 抛出异常需要捕获，否则会影响运行
				e.printStackTrace();

			}

		}
		es.shutdown();
	}
}
