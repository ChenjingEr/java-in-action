package pro.jing.multithreading.base;

public class VolatileTest {

	private volatile int counter = 0;

	public synchronized void increment() {
		counter++;
	}

	public int getCounter() {
		return counter;
	}

	public static void main(String[] args) {

		VolatileTest t = new VolatileTest();

		new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {

					new Thread() {
						public void run() {
							t.increment();
						};
					}.start();

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					new Thread() {
						public void run() {
							System.out.println(t.getCounter());
						};
					}.start();

					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();

	}
}
