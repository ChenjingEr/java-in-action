package pro.jing.multithreading.base.sync.deadlock;

public class OtherService {

	private final Object LOCK = new Object();
	
	private Service service;
	
	public OtherService(Service service) {
		this.service = service;
	}
	
	public void fun() {
		synchronized (LOCK) {
			System.out.println("other fun....");
		}
	}
	
	public void fun2() {
		synchronized (LOCK) {
			service.fun();
		}
	}
}
