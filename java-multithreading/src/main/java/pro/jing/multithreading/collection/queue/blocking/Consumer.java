package pro.jing.multithreading.collection.queue.blocking;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<Integer> queue;

	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			int con = queue.take();
			System.out.println("Consumer " + con);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
