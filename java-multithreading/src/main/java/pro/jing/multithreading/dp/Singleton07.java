package pro.jing.multithreading.dp;

/**
 * @author JING
 * @date 2018年8月21日
 * @describe 懒加载，线程安全，高性能。优雅实现二 枚举
 * 
 */
public class Singleton07 {

	private Singleton07() {
	}
	
	public static Singleton07 getInstance() {
		return Instance.INSTANCE.getInstance();
	}
	
	
	
	private enum Instance{
		
		INSTANCE;
		
		private final Singleton07 instance;
		
		Instance() {
			instance = new Singleton07();
		}
		
		public Singleton07 getInstance() {
			return instance;
		}
	}


}
