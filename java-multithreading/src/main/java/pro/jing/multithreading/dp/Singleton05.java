package pro.jing.multithreading.dp;

/**
 * @author JING
 * @date 2018年8月21日
 * @describe 懒汉式单例模式，线程安全解决方案 2：double check的null point问题
 * 
 */
public class Singleton05 {

	private volatile static Singleton05 instance;

	private Singleton05() {
	}

	public synchronized static Singleton05 getInstance() {
		if (instance == null)
			synchronized (Singleton05.class) {
				if (instance == null)
					instance = new Singleton05();
			}

		return Singleton05.instance;
	}
}
