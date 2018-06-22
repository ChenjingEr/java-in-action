package pro.jing.multithreading.collection.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author JING
 * @Date 2018年6月21日
 * @description JUC 包实现的同步List
 */
public class JucSynchronizationList {

	public static void main(String[] args) {

		List<String> list = new CopyOnWriteArrayList<>();
		ListAccess.access(list);
	}
}
