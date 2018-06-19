package pro.jing.multithreading.pool.poolfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pro.jing.multithreading.pool.task.TaskByRunnableSimple;

public class SingleThreadPoolDefault {

	public static void main(String[] args) {
		ExecutorService es = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			es.execute(new TaskByRunnableSimple());
		}
		es.shutdown();
	}
}
