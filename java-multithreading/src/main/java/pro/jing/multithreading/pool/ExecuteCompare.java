package pro.jing.multithreading.pool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JING
 * @Date 2018年6月18日
 * @description 线程池避免线程一直创建和撤销的消耗,也无需创建n个线程，节省内存
 */
public class ExecuteCompare {

	public static void main(String[] args) throws InterruptedException {

		ExecuteCompare use = new ExecuteCompare();
		int n = 1000;
		CountDownLatch cdl = new CountDownLatch(n);

		long start = System.currentTimeMillis();
		use.executorExecute(cdl, n);
		cdl.await();
		System.out.println("用Thread执行：" + (System.currentTimeMillis() - start));

	}

	private void threadExecute(CountDownLatch cdl, int n) {
		for (int i = 0; i < n; i++) {
			Thread t = new Thread(() -> {
				System.out.println(Thread.currentThread().getName());
				cdl.countDown();
			});
			t.start();
		}
	}

	private void executorExecute(CountDownLatch cdl, int n) {
		ExecutorService ex = Executors.newCachedThreadPool();
		for (int i = 0; i < n; i++) {
			ex.execute(() -> {
				System.out.println(Thread.currentThread().getName());
				cdl.countDown();
			});
		}
	}
}
