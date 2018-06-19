package pro.jing.multithreading.pool.task;

import java.util.concurrent.Callable;

public class TaskByCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		
		System.out.println(Thread.currentThread().getName() + " calculating...");
		Integer i = 1+1;
		return i;
	}

}
