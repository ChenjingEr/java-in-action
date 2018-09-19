package pro.jing.multithreading.dp;

/**
 * @author JING
 * @date 2018年8月21日
 * @describe 饿汉式单例模式
 * 
 * 优点：随着类加载初始化，一定是线程安全地
 * 缺点：如果这个instance从头到尾都没有被使用，内存浪费，不能实现懒加载
 * 
 */
public class Singleton01 {

	private static Singleton01 instance = new Singleton01();

	private Singleton01() {
	}

	public static Singleton01 getInstance() {
		return instance;
	}
}
