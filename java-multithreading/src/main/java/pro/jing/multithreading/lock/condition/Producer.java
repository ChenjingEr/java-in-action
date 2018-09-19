package pro.jing.multithreading.lock.condition;

public class Producer implements Runnable {

	private DepotWithCondition depot;

	public Producer(DepotWithCondition depot) {
		super();
		this.depot = depot;
	}

	@Override
	public void run() {
		depot.add();
	}
}
