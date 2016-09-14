package CustomThreadPool;

import java.util.concurrent.BlockingQueue;

public class Worker extends Thread {
	
	private boolean isStopped = false;
	
	private BlockingQueue<Runnable> queue;
	private int name;

	public Worker(BlockingQueue<Runnable> queue, int name){
		this.queue = queue;
		this.name = name;
		
	}
	
	
	
	public synchronized boolean isStopped() {
		return isStopped;
	}



	public synchronized void doStop(boolean isStopped) {
		this.isStopped = isStopped;
		this.interrupted();
	}



	@Override
	public void run() {
		while(!isStopped){
			try {
				Runnable run = queue.take();
				System.out.println("Item taken by thread "+ this.name);
				run.run();
				System.out.print("Iteam completed by thread "+ this.name);
				
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			
		}

	}

}
