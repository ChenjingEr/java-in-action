package pro.jing.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter {

	private AtomicInteger counter = new AtomicInteger();

	public Integer getNext() {
		return counter.getAndIncrement();
	}

	public static void main(String[] args) {
		AtomicIntegerCounter counter = new AtomicIntegerCounter();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + " " + counter.getNext());
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + " " + counter.getNext());
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + " " + counter.getNext());
				}
			}
		}).start();

	}
}
