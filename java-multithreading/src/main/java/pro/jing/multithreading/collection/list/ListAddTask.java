package pro.jing.multithreading.collection.list;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ListAddTask implements Runnable {

	private List<String> list;
	private String name;
	private Integer loop;
	private CountDownLatch cdl;

	public ListAddTask(String name, List<String> list, Integer loop,CountDownLatch cdl) {
		this.name = name;
		this.list = list;
		this.loop = loop;
		this.cdl = cdl;
	}

	@Override
	public void run() {
		for (int i = 0; i < loop; i++) {
			list.add(name + " put " + i);
		}
		cdl.countDown();
	}
}
