package pro.jing.multithreading.collection.set;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class JucSynchronizationSet {

	public static void main(String[] args) {
		Set<String> set = new CopyOnWriteArraySet<>();
		SetAccess.setAccess(set);
	}
}
