package pro.jing.multithreading.collection.list;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import pro.jing.util.ConcurrentPerformanceTestTool;

public class ListAccess {

	public static void access(List<String> list) {
		System.out.println("================get================");
		ConcurrentPerformanceTestTool ex = new ConcurrentPerformanceTestTool(10, 15, 0, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		ex.setPerformanceIndicators(System.currentTimeMillis(), "list.add", 10);
		int loop = 20;
		CountDownLatch cdl = new CountDownLatch(loop);
		for (int i = 0; i < 10; i++) {
			ex.execute(new ListAddTask("a-" + i, list, loop, cdl));
		}
		ex.shutdown();
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());

		System.out.println("================get================");
		ConcurrentPerformanceTestTool ex2 = new ConcurrentPerformanceTestTool(10, 15, 0, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		ex2.setPerformanceIndicators(System.currentTimeMillis(), "list.get", 10);
		for (int i = 0; i < 10; i++) {
			ex2.execute(new ListGetTask(list, 20));
		}
		ex2.shutdown();
	}

	public static void access(List<String> list, Integer threadSize, Integer loop) {
		ConcurrentPerformanceTestTool ex = new ConcurrentPerformanceTestTool(10, 15, 0, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		ex.setPerformanceIndicators(System.currentTimeMillis(), "list.add", threadSize);
		CountDownLatch cdl = new CountDownLatch(threadSize);
		for (int i = 0; i < threadSize; i++) {
			ex.execute(new ListAddTask("a-" + i, list, loop, cdl));
		}
		ex.shutdown();
		try {
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConcurrentPerformanceTestTool ex2 = new ConcurrentPerformanceTestTool(10, 15, 0, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		ex2.setPerformanceIndicators(System.currentTimeMillis(), "list.get", threadSize);
		for (int i = 0; i < threadSize; i++) {
			ex2.execute(new ListGetTask(list, loop));
		}
		ex2.shutdown();
	}

}
