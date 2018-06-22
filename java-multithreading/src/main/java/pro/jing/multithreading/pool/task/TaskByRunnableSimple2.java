package pro.jing.multithreading.pool.task;

import java.util.Date;

public class TaskByRunnableSimple2 implements Runnable {

	private String name;

	public TaskByRunnableSimple2(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(new Date() + " " + Thread.currentThread().getName() + " " + name + " running...");
	}

}
