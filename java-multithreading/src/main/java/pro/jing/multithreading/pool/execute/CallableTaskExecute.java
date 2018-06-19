package pro.jing.multithreading.pool.execute;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import pro.jing.multithreading.pool.task.TaskByCallable;

/**
 * @author JING
 * @Date 2018年6月19日
 * @description callable 任务执行 submit
 */
public class CallableTaskExecute {

	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(2);
		List<Future<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Future<Integer> sum = ex.submit(new TaskByCallable());
			list.add(sum);
		}

		for (Future<Integer> fs : list) {
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				ex.shutdown();
			}
		}

	}
}
