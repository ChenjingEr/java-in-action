package pro.jing.multithreading.collection.queue.blocking;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;

/**
 * @author JING
 * @Date 2018年6月24日
 * @description 有界阻塞队列,队列满，put()阻塞，队列空，take阻塞
 */
public class ArrayBlockingQueueShare {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
		List<Runnable> runnables = Arrays.asList(
//				new Producer(queue), 
//				new Producer(queue), 
//				new Producer(queue)
				new Consumer(queue)
//				new Consumer(queue), 
//				new Consumer(queue)
				);
		List<Thread> threads = runnables.stream().map(runnable -> new Thread(runnable)).peek(Thread::start)
				.collect(Collectors.toList());
	}
}
