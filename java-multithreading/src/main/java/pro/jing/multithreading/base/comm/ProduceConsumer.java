package pro.jing.multithreading.base.comm;

import java.util.concurrent.locks.Lock;

/**
 * @author JING
 * @date 2018年8月21日
 * @describe simple Produce Consumer
 */
public class ProduceConsumer {

	private int produce = 0;
	private final Object LOCK = new Object();
	private volatile boolean isProduced = false;

	public void produce() {

		synchronized (LOCK) {
			if (isProduced) {
				try {
					LOCK.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("p-> " + produce++);
				isProduced = true;
				LOCK.notifyAll();
			}
		}

	}

	public void consumer() {
		synchronized (LOCK) {
			if (isProduced) {
				System.out.println("c-> " + produce);
				isProduced = false;
				LOCK.notifyAll();
			} else {
				try {
					LOCK.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		ProduceConsumer pc = new ProduceConsumer();

		new Thread() {
			@Override
			public void run() {
				while (true)
					pc.produce();
			};
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				while (true)
					pc.consumer();
			};
		}.start();
	}

}
