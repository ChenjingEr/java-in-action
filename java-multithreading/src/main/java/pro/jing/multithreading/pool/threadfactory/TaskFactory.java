package pro.jing.multithreading.pool.threadfactory;

import java.util.concurrent.ThreadFactory;


public class TaskFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		System.out.println("Thread factory");
		return new Thread(r);
	}

}
