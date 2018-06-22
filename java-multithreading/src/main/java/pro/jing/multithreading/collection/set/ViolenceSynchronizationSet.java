package pro.jing.multithreading.collection.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ViolenceSynchronizationSet {

	public static void main(String[] args) {
		Set<String> set = Collections.synchronizedSet(new HashSet<>());
		SetAccess.setAccess(set);
	}
}
