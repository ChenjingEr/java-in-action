package pro.jing.multithreading.pool.task;

import java.util.Date;

public class TaskByRunnableSimple implements Runnable {

	@Override
	public void run() {
		System.out.println(new Date() + " " + Thread.currentThread().getName() + " running...");
	}

}
