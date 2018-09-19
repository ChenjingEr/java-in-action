package pro.jing.multithreading.dp;

/**
 * @author JING
 * @date 2018年8月21日
 * @describe 懒加载，线程安全，高性能。优雅实现一
 * 
 */
public class Singleton06 {

	private Singleton06() {
	}

	public static class InstanceHolder {

		private static Singleton06 instance = new Singleton06();
	}

	public static Singleton06 getInstance() {
		return InstanceHolder.instance;
	}

}
