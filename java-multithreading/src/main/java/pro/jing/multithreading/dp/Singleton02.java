package pro.jing.multithreading.dp;

/**
 * @author JING
 * @date 2018年8月21日
 * @describe 懒汉式单例模式
 * 
 * 优点：需要这个类时才加载
 * 缺点：线程安全问题，导致new出多个instance
 * 
 */
public class Singleton02 {

	private static Singleton02 instance;

	private Singleton02() {
	}

	public static Singleton02 getInstance() {
		if (instance == null)
			instance = new Singleton02();
		return Singleton02.instance;
	}
}
