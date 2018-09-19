package pro.jing.multithreading.collection.queue.blocking;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Integer> queue;

	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Random r = new Random();
		int ran = r.nextInt(500);
		try {
			queue.put(ran);
			System.out.println("Producer" + ran);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
