package pro.jing.multithreading.lock.readanwrite;

public class ReadTask implements Runnable {

	private Depot depot;
	
	public ReadTask(Depot depot) {
		this.depot = depot;
	}

	@Override
	public void run() {
		depot.read();
	}
	
}
