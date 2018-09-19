package pro.jing.multithreading.collection.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JucSynchronizationMap {

	public static void main(String[] args) {
//		Map<String, String> map = new ConcurrentHashMap<>();
//		MapAccess.access(map);
		Map<String, String> map = new ConcurrentHashMap<>();
		map.put("1", "1");
		map.put("2", "1");
		map.put("3", "1");
		map.put("4", "1");
		map.put("5", "1");
		map.put("6", "1");
		map.put("7", "1");
		map.put("8", "1");
		map.put("9", "1");
		map.put("10", "1");
		map.put("11", "1");
		map.put("12", "1");
		map.put("13", "1");
		map.put("14", "1");
		map.put("15", "1");
		map.put("16", "1");
	}
}
