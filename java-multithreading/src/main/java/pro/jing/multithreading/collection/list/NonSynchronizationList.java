package pro.jing.multithreading.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JING
 * @Date 2018年6月21日
 * @description 不实现同步，同时访问同一个地方，会导致数据覆盖，size < 2 * 20
 */
public class NonSynchronizationList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		ListAccess.access(list);

	}
}
