package pro.jing.multithreading.base.sync.deadlock;

/**
 * @author JING
 * @date 2018年8月21日
 * @describe 死锁例子
 */
public class Main {

	public static void main(String[] args) {
		Service service = new Service();
		OtherService other = new OtherService(service);
		service.setOther(other);
		
		new Thread() {
			@Override
			public void run() {
				while(true)
					service.fun2();
			};
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				while(true)
					other.fun2();
			};
		}.start();
	}
}
