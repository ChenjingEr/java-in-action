package pro.jing.multithreading.lock.readanwrite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteLock {

	public static void main(String[] args) {
		ReadWriteLock lock = new ReentrantReadWriteLock();
		Depot depot = new Depot(lock.readLock(), lock.writeLock());
		for (int i = 0; i < 10; i++) {
			Thread read = new Thread(new ReadTask(depot));
			read.start();
			Thread write = new Thread(new WriteTask(depot));
			write.start();
		}
	}
}
