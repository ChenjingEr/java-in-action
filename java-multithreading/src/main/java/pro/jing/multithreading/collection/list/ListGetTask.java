package pro.jing.multithreading.collection.list;

import java.util.List;
import java.util.Random;

public class ListGetTask implements Runnable {

	private List<String> list;
	private Integer loop;

	public ListGetTask(List<String> list, Integer loop) {
		this.list = list;
		this.loop = loop;
	}

	@Override
	public void run() {
		Random ran = new Random();
		int size = list.size() - 1;
		for (int i = 0; i < loop; i++) {
			int index = ran.nextInt(size);
			list.get(index);
			// System.out.println(Thread.currentThread().getName() + " ==" + index + "= " +
			// list.get(index));
		}
	}

}
