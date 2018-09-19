package pro.jing.multithreading.collection.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CouncrrentLinkedQueueDemo {

	public static void main(String[] args) {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		queue.add("a");
		queue.add("b");
		queue.offer("c");
		queue.offer("d");
		System.out.println(queue.peek());
		System.out.println(queue.peek());
//		System.out.println(queue.poll());
		System.out.println(queue);
	}
}
