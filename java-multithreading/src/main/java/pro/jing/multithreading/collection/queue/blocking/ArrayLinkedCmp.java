package pro.jing.multithreading.collection.queue.blocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import net.sf.ehcache.pool.sizeof.ReflectionSizeOf;
import net.sf.ehcache.pool.sizeof.SizeOf;

/**
 * @author JING
 * @date 2018年8月23日
 * @describe ArrayBlockingQueue & LinkedBlockingQueue 内存占用比较
 */
public class ArrayLinkedCmp {

	public static void main(String[] args) {
		
		performance(new ArrayBlockingQueue<>(10));
		performance(new LinkedBlockingQueue<>(10));
		

	}

	public static void sizeCompare() {
		ArrayBlockingQueue<Runnable> array = new ArrayBlockingQueue<>(10);
		LinkedBlockingQueue<Runnable> linked = new LinkedBlockingQueue<>(10);

		SizeOf sizeOf = new ReflectionSizeOf();
		System.out.println(sizeOf.deepSizeOf(2, false, array).getCalculated());
		System.out.println(sizeOf.deepSizeOf(2, false, linked).getCalculated());

		for (int i = 0; i < 10; i++)
			array.add(new Task());
		for (int i = 0; i < 10; i++)
			linked.add(new Task());

		System.out.println(sizeOf.deepSizeOf(2, false, array).getCalculated());
		System.out.println(sizeOf.deepSizeOf(2, false, linked).getCalculated());

	}

	public static void performance(BlockingQueue<Runnable> queue) {

		ThreadPoolExecutor reades = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() /2);
		ThreadPoolExecutor writees = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() /2);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 20; i++) {
			writees.execute(new WriteTask(queue));
		}
		
		for (int i = 0; i < 20; i++) {
			reades.execute(new ReadTask(queue));
		}
		
		while(reades.getActiveCount() > 0) {
			
		}
		while(writees.getActiveCount()>0) {
			
		}
		
		System.out.println("操作完成 : " + (System.currentTimeMillis() - start));
		writees.shutdown();
		reades.shutdown();

	}
	
}

class Task implements Runnable {

	@Override
	public void run() {

	}
}

class ReadTask implements Runnable {

	private BlockingQueue<Runnable> queue;

	public ReadTask(BlockingQueue<Runnable> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
//				System.out.println("Read");
				queue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class WriteTask implements Runnable {

	private BlockingQueue<Runnable> queue;

	public WriteTask(BlockingQueue<Runnable> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
//				System.out.println("Write");
				queue.put(new Task());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
