package pro.jing.multithreading.dp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author JING
 * @date 2018年9月3日
 * @describe Future模式，异步获取执行结果的一种模式。无需同步等待执行结果的返回。
 */
public class FutureTaskDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Thread.sleep(100);
				return Integer.valueOf(1);
			}
			
		});
		
		Executors.newFixedThreadPool(1).submit(task);
		
		for (int i = 0; i < 10;i++) {
			System.out.println("main -> " + i);
		}
		
		System.out.println(task.get());
			
		
		
	}
}
