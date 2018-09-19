package pro.jing.multithreading.lock.condition;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import pro.jing.util.ConcurrentPerformanceTestTool;

/**
 * @author JING
 * @Date 2018年6月25日
 * @description
 */
public class Client {

	public static void main(String[] args) {
		DepotWithCondition depot = new DepotWithCondition();
		int taskCount = 20;
		ConcurrentPerformanceTestTool tool = new ConcurrentPerformanceTestTool(10, 20, 0, TimeUnit.SECONDS,
				new LinkedBlockingQueue<>());
		tool.setPerformanceIndicators(System.currentTimeMillis(), "dept", taskCount);
		for (int i = 0; i < taskCount; i++) {
			tool.execute(new Consumer(depot));
		}
		tool.shutdown();
		ConcurrentPerformanceTestTool tool2 = new ConcurrentPerformanceTestTool(10, 20, 0, TimeUnit.SECONDS,
				new LinkedBlockingQueue<>());
		tool2.setPerformanceIndicators(System.currentTimeMillis(), "dept", taskCount);
		for (int i = 0; i < taskCount; i++) {
			tool2.execute(new Producer(depot));
		}
		tool2.shutdown();
	}
}
