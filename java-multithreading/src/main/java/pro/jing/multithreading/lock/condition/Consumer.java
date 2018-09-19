package pro.jing.multithreading.lock.condition;

public class Consumer implements Runnable{
	
	private DepotWithCondition depot;
	
	public Consumer(DepotWithCondition depot) {
		super();
		this.depot = depot;
	}

	@Override
	public void run() {
		depot.get();
	}

	
}
