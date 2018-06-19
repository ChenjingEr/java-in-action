package pro.jing.multithreading.pool.poolfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pro.jing.multithreading.pool.task.TaskByRunnableSimple;
import pro.jing.multithreading.pool.threadfactory.TaskFactory;

/**
 * @author JING
 * @Date 2018年6月19日
 * @description Executors fixedThreadPool
 */
public class FixedThreadPoolDefault {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			es.execute(new TaskByRunnableSimple());
		}
		es.shutdown();
	}
		
}
