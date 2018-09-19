package pro.jing.multithreading.dp;

/**
 * @author JING
 * @date 2018年8月21日
 * @describe 懒汉式单例模式，线程安全解决方案 1：synchronized
 * 
 * 缺点：每一次都需要获取锁(实际只需要instance==null时获取就可以)，性能问题
 */
public class Singleton03 {

	private static Singleton03 instance;

	private Singleton03() {
	}

	public synchronized static Singleton03 getInstance() {
		if (instance == null)
			instance = new Singleton03();
		return Singleton03.instance;
	}
}
