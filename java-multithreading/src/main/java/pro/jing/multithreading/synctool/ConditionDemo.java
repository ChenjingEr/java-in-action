package pro.jing.multithreading.synctool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition c = lock.newCondition();
		
		try {
			c.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
