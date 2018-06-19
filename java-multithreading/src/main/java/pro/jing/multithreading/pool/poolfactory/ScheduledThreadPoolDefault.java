package pro.jing.multithreading.pool.poolfactory;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import pro.jing.multithreading.pool.task.TaskByRunnableSimple;

/**
 * @author JING
 * @Date 2018年6月19日
 * @description
 */
public class ScheduledThreadPoolDefault {

	public static void main(String[] args) {
		ScheduledExecutorService es = Executors.newScheduledThreadPool(2);
		System.out.println(new Date());

		// 延迟5秒执行
		// es.schedule(new TaskByRunnableSimple(), 5, TimeUnit.SECONDS);
		// 周期性执行
		es.scheduleAtFixedRate(new TaskByRunnableSimple(), 0, 5, TimeUnit.SECONDS);
		// es.shutdown();
	}
}
