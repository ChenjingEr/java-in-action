package pro.jing.multithreading.lock.readanwrite;

import java.util.concurrent.locks.Lock;

public class Depot {

	private Lock readLock;
	private Lock writeLock;

	public Depot(Lock readLock, Lock writeLock) {
		this.readLock = readLock;
		this.writeLock = writeLock;
	}

	public void read() {
		readLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " read...");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(Thread.currentThread().getName() + " read done...");
			readLock.unlock();
		}
	}

	public void write() {
		writeLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " write...");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(Thread.currentThread().getName() + " write done...");
			writeLock.unlock();
		}
	}
}
