package pro.jing.multithreading.pool.customizepool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import pro.jing.multithreading.pool.task.TaskByRunnableSimple;
import pro.jing.multithreading.pool.threadfactory.TaskFactory;

public class ThreadFactoryCustomization {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2, new TaskFactory());
		es.execute(new TaskByRunnableSimple());
		es.execute(new TaskByRunnableSimple());
		es.shutdown();
	}
}
