package pro.jing.multithreading.collection.list.performance;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import pro.jing.multithreading.collection.list.ListAccess;

public class CopyOnWriteArrayListPerformance {

	public static void main(String[] args) {
		List<String> list = new CopyOnWriteArrayList<>();
		ListAccess.access(list, 100, 1000);
	}
}
