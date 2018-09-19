package pro.jing.multithreading.synctool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

/**
 * @author JING
 * @Date 2018年6月25日
 * @description Semaphore表示对一个资源访问的线程数量
 */
public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(2);
		List<Runnable> tasks = Arrays.asList(new SemaphoreTask(semaphore), new SemaphoreTask(semaphore),
				new SemaphoreTask(semaphore), new SemaphoreTask(semaphore), new SemaphoreTask(semaphore),
				new SemaphoreTask(semaphore));
		tasks.stream().map(task -> new Thread(task)).peek(Thread::start).collect(Collectors.toList());
	}
}

class SemaphoreTask implements Runnable {

	private Semaphore semaphore;

	public SemaphoreTask(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		
		try {
			semaphore.acquire();
			System.out.println("....."); // 最多只有2个线程可以同时进入该代码
			semaphore.release();
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
