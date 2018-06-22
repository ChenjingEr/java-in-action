package pro.jing.multithreading.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JING
 * @Date 2018年6月21日
 * @description 不实现同步，put可能会让链表循环
 */
public class NonSynchronizatioinList {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		MapAccess.access(map);
	}
}
