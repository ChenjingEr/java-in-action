package pro.jing.multithreading.base.sync.deadlock;

public class Service {

	private final Object LOCK = new Object();
	private OtherService other;

	public void fun() {
		synchronized (LOCK) {
			System.out.println("service fun...");
		}
	}
	
	public void fun2() {
		synchronized (LOCK) {
			other.fun();
		}
	}

	public OtherService getOther() {
		return other;
	}

	public void setOther(OtherService other) {
		this.other = other;
	}
	
}
