package pro.jing.multithreading.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.validator.ValidateWith;

/**
 * @author JING
 * @Date 2018年6月25日
 * @description 用Condition实现等待/通知
 */
public class DepotWithCondition {

	private volatile int count;
	private Integer capacity;
	private ReentrantLock lock = new ReentrantLock();;
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();

	public DepotWithCondition() {
		this.count = 0;
		this.capacity = 5;
	}

	public void add() {
		lock.lock();
		try {
			if (count >= capacity) {
				System.out.println(Thread.currentThread().getName() + " add await ");
				notFull.await();
			}
			++count;
			System.out.println(Thread.currentThread().getName() + " count = " + count + " add...");
			notEmpty.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void get() {
		lock.lock();
		try {
			if (count <= 0) {
				System.out.println(Thread.currentThread().getName() + " get await");
				notEmpty.await();
			}
			--count;
			System.out.println(Thread.currentThread().getName() + "count = " + count +" get....");
			notFull.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
