package pro.jing.multithreading.collection.map;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class MapGetTask implements Runnable{

	private Map<String, String> map;

	public MapGetTask(Map<String, String> map) {
		this.map = map;
	}

	@Override
	public void run() {
		Collection<String> values = map.values();
		Iterator<String> it = values.iterator();
		while(it.hasNext()) {
			String value = it.next();
			System.out.println(value + " " + map.get(value));
		}
	}
	
	

}
