package pro.jing.jvm.memory_management;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jing
 * @date Jun 13, 2018
 * @description 堆上 OutOfMemoryError
 * vm args -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @see 深入理解Java虚拟机
 */
public class HeapOOM {

	static class OOMObject {
		
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		
		while(true) {
			list.add(new OOMObject());
		}
	}
}
