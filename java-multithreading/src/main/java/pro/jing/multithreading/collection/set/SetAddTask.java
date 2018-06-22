package pro.jing.multithreading.collection.set;

import java.util.Set;

public class SetAddTask implements Runnable {

	private Set<String> set;
	private String name;

	public SetAddTask(String name, Set<String> set) {
		this.name = name;
		this.set = set;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if (i % 4 == 0)
				Thread.yield();
			set.add(name + " put " + i);
		}
	}
}
