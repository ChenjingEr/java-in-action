package pro.jing.multithreading.pool.statistics;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import pro.jing.multithreading.pool.task.TaskByRunnableSimple;
/**
 * @author JING
 * @Date 2018年6月21日
 * @description 所有任务执行完之后，工作线程的数量
 * 1. 用无界任务队列且没有shutDown()/shutDownNow(), countOfWorks = corePoolSize
 * 2. 用无界任务队列且调用了shutDown()/shutDownNow(), countOfWorks = 0
 * 3. 用有界任务队列，没有调用shutDown()/shudDownNow()， countOfWorks = corePoolSize
 * 4. 用有界任务队列且调用了shutDown()/shutDownNow(), countOfWorks = 0
 */
public class AfterExecuteThreadCount {

	public static void main(String[] args) {
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(1, 3, 0, TimeUnit.SECONDS, new ArrayBlockingQueue(3));
//		tpe.allowCoreThreadTimeOut(true);

		for (int i = 0; i < 7; i++) {
			tpe.execute(new TaskByRunnableSimple());
		}
		
		try {
			tpe.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		
		System.out.println("完成的任务：" + tpe.getCompletedTaskCount());
		System.out.println();
//		tpe.shutdown();
	}
}
