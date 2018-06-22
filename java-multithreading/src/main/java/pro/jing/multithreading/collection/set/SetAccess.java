package pro.jing.multithreading.collection.set;

import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import pro.jing.util.ConcurrentPerformanceTestTool;

public class SetAccess {

	public static void setAccess(Set<String> set) {

		System.out.println("================add================");
		ConcurrentPerformanceTestTool ex = new ConcurrentPerformanceTestTool(3, 5, 0, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		int loop = 2;
		ex.setPerformanceIndicators(System.currentTimeMillis(), "set.add", loop);
		for (int i = 0; i < loop; i++) {
			ex.execute(new SetAddTask("a-" + i, set));
		}
		ex.shutdown();
		try {
			ex.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(set.size());
		System.out.println(set);
	}
}
