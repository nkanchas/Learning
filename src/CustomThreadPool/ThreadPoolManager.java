package CustomThreadPool;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolManager {
	BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
	private static int THREAD_CAPACITY;
	List<Worker> threadPool = new ArrayList<Worker>(); 
	private boolean isStopped = false;
	
	public  ThreadPoolManager(int noOfThreads){
		THREAD_CAPACITY=noOfThreads;
		for(int i=0;i<THREAD_CAPACITY;++i){
			threadPool.add(new Worker(queue, i));
		}
		
		for(Worker worker : threadPool){
			worker.start();
		}
	}
	
	public void execute(Runnable run){
		if(isStopped) throw new IllegalStateException("ThreadPool is stopped.");
		queue.offer(run);
	}
	
	public void stop(){
	  this.isStopped = true;
	  for(Worker worker : threadPool){
		  worker.doStop(true);
	  }
	}

}
