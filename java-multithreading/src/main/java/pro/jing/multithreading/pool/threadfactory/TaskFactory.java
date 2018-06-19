package pro.jing.multithreading.pool.threadfactory;

import java.util.concurrent.ThreadFactory;

import pro.jing.multithreading.pool.task.TaskByRunnableSimple;

public class TaskFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		return new Thread(new TaskByRunnableSimple());
	}

	
}
