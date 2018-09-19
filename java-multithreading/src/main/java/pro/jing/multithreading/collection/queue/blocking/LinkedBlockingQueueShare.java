package pro.jing.multithreading.collection.queue.blocking;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author JING
 * @Date 2018年6月24日
 * @description 无界阻塞队列，只有在队列为空时take阻塞才会阻塞。默认情况下,元素没有超过max_value,put不会造成阻塞
 */
public class LinkedBlockingQueueShare {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);
		// queue.put(1);
		// System.out.println("put 1");
		// queue.put(2);
		// System.out.println("put 2");
		// queue.put(3);
		// System.out.println("put 3");
		// new Thread(() -> {
		// try {
		// System.out.println(queue.take());
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }).start();
		// queue.put(4);
		// System.out.println("put 4");
		new Thread(()->{
			try {
				System.out.println(queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}) .start();
		Thread.sleep(1000);
		new Thread(() -> {
			try {
				queue.put(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		

	}
}
