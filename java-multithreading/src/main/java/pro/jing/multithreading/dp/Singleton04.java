package pro.jing.multithreading.dp;

/**
 * @author JING
 * @date 2018年8月21日
 * @describe 懒汉式单例模式，线程安全解决方案 2：double check
 * 
 * 缺点：可能会有null point。编译器优化问题导致没有init完成就已经在使用
 */
public class Singleton04 {

	private static Singleton04 instance;

	private Singleton04() {
	}

	public synchronized static Singleton04 getInstance() {
		if (instance == null)
			synchronized (Singleton04.class) {
				if (instance == null)
					instance = new Singleton04();
			}

		return Singleton04.instance;
	}
}
