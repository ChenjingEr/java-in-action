package pro.jing.multithreading.synctool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * @author JING
 * @Date 2018年6月25日
 * @description 同步工具之CountDownLatch CountDownLatch 等待一组线程完成之后再执行
 */
public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch cdl = new CountDownLatch(3);
		List<Runnable> tasks = Arrays.asList(new DemoTask(cdl), new DemoTask(cdl), new DemoTask(cdl));
		tasks.stream().map(task -> new Thread(task)).peek(Thread::start).collect(Collectors.toList());
		cdl.await();
		System.out.println(Thread.currentThread().getName() + " end..");
	}
}

class DemoTask implements Runnable {

	private CountDownLatch cdl;

	public DemoTask(CountDownLatch cdl) {
		this.cdl = cdl;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " run...");
		cdl.countDown();
	}

}
