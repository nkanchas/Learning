package Threads.PubSub;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadConsumer implements Runnable {
	
	int[] queue;
	AtomicInteger count;
	int maxNum;
	private Broker<Integer> exchanger;
	
	public ThreadConsumer(Broker<Integer> exchanger){
		 this.exchanger = exchanger;
	}

	@Override
	public void run() {
          try {
			for(int i = exchanger.take(); i!=-1; i=exchanger.take()){
				System.out.println("Consumer message "+ i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
