package pro.jing.multithreading.collection.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JucSynchronizationMap {

	public static void main(String[] args) {
		Map<String, String> map = new ConcurrentHashMap<>();
		MapAccess.access(map);
	}
}
