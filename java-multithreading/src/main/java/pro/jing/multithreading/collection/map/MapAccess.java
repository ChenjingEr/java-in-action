package pro.jing.multithreading.collection.map;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import pro.jing.util.ConcurrentPerformanceTestTool;

public class MapAccess {

	public static void access(Map<String, String> map) {
		System.out.println("================put================");
		ConcurrentPerformanceTestTool ex = new ConcurrentPerformanceTestTool(3, 5, 0, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		int loop = 2;
		ex.setPerformanceIndicators(System.currentTimeMillis(), "list.add", loop);
		for (int i = 0; i < loop; i++) {
			ex.execute(new MapPutTask(map, "map-" + i, 10));
		}
		ex.shutdown();
		try {
			ex.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(map.size());

		System.out.println("================get================");
		ConcurrentPerformanceTestTool ex2 = new ConcurrentPerformanceTestTool(3, 5, 0, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		loop = 10;
		ex2.setPerformanceIndicators(System.currentTimeMillis(), "list.add", loop);
		for (int i = 0; i < loop; i++) {
			ex2.execute(new MapGetTask(map));
		}
		ex2.shutdown();
	}

}
