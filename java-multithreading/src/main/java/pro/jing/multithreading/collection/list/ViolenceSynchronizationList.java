package pro.jing.multithreading.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author JING
 * @Date 2018年6月21日
 * @description 用Collections实现list同步
 */
public class ViolenceSynchronizationList {

	public static void main(String[] args) {
		// 同步list
		List<String> list = Collections.synchronizedList(new ArrayList<>());
		ListAccess.access(list);

	}
}
