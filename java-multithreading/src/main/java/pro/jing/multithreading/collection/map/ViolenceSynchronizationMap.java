package pro.jing.multithreading.collection.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ViolenceSynchronizationMap {

	public static void main(String[] args) {
		Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
		MapAccess.access(map);
	}
}
