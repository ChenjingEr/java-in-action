package pro.jing.multithreading.synctool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;

/**
 * @author JING
 * @Date 2018年6月25日
 * @description 一组线程到达某个屏障后再执行。一组线程互相等待
 */
public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(3);
		List<Runnable> tasks = Arrays.asList(new CyclicTask(cb), new CyclicTask(cb), new CyclicTask(cb));
		tasks.stream().map(task -> new Thread(task)).peek(Thread::start).collect(Collectors.toList());
	}
}

class CyclicTask implements Runnable {

	private CyclicBarrier cb;
	public CyclicTask(CyclicBarrier cb) {
		this.cb = cb;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " run");
			cb.await();
			System.out.println(Thread.currentThread().getName()+" countinue");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
}
