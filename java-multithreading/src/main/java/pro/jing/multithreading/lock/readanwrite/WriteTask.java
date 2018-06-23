package pro.jing.multithreading.lock.readanwrite;

public class WriteTask implements Runnable {

	private Depot depot;
	
	public WriteTask(Depot depot) {
		this.depot = depot;
	}

	@Override
	public void run() {
		depot.write();
	}
	
}
