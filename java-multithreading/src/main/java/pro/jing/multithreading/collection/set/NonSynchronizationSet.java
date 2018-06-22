package pro.jing.multithreading.collection.set;

import java.util.HashSet;
import java.util.Set;

public class NonSynchronizationSet {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		SetAccess.setAccess(set);
	}
}
