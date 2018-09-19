package pro.jing.multithreading.collection.queue.blocking;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collectors;

/**
 * @author JING
 * @Date 2018年6月24日
 * @description 不存储元素的队列，每一个put必须等待一个take操作，否则不能添加新元素
 */
public class SynchronousQueueShare {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new SynchronousQueue<>();
		List<Runnable> runnables = Arrays.asList(
				new Producer(queue), 
				new Producer(queue), 
				new Producer(queue),
				new Consumer(queue)
//				new Consumer(queue), 
//				new Consumer(queue)
				);
		List<Thread> threads = runnables.stream().map(runnable -> new Thread(runnable)).peek(Thread::start)
				.collect(Collectors.toList());
	}
}
