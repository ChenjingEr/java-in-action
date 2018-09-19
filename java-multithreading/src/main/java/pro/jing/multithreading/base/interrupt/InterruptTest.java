package pro.jing.multithreading.base.interrupt;

public class InterruptTest {

	public static void main(String[] args) {
		Thread t = new Thread() {
			@Override
			public void run() {
				for(;;) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.err.println(Thread.currentThread().isInterrupted());
					}
				}
			}
		};
		t.start();
		System.out.println(t.isInterrupted());
		t.interrupt();
		System.out.println(t.isInterrupted());
		
	}
}
