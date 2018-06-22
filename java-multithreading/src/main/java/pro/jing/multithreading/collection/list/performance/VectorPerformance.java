package pro.jing.multithreading.collection.list.performance;

import java.util.List;
import java.util.Vector;

import pro.jing.multithreading.collection.list.ListAccess;

public class VectorPerformance {

	public static void main(String[] args) {
		List<String> list = new Vector<>();
		//1000个线程，每个线程添加5000个元素
		ListAccess.access(list, 100, 1000);
	}
}
