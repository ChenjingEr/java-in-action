package pro.jing.jvm.tool;

public class Demo {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
	}
}
