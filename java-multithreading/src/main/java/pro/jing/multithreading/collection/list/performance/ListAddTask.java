package pro.jing.multithreading.collection.list.performance;

import java.util.List;

public class ListAddTask implements Runnable {

	private List<String> list;
	private String name;
	private Integer loop;

	public ListAddTask(String name, List<String> list, Integer loop) {
		this.name = name;
		this.list = list;
		this.loop = loop;
	}

	@Override
	public void run() {
		for (int i = 0; i < loop; i++) {
			list.add(name + " put " + i);
		}
	}
}
