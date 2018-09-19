package pro.jing.multithreading.collection.queue.blocking;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author JING
 * @Date 2018年6月24日
 * @description 优先级队列
 */
public class PriorityBlockingQueueShare {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
		try {
			queue.put(30);
			queue.put(20);
			queue.put(10);
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
