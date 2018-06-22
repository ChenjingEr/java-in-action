package pro.jing.multithreading.collection.map;

import java.util.Map;

public class MapPutTask implements Runnable {

	private Map<String, String> map;
	private String name;
	private Integer loop;

	public MapPutTask(Map<String, String> map, String name, Integer loop) {
		this.map = map;
		this.name = name;
		this.loop = loop;
	}

	@Override
	public void run() {
		for (int i = 0; i < loop; i++) {
			map.put(name + i, name + i);
		}
	}

}
