package Threads.PubSub;



public class ThreadProducer implements Runnable{

	
	Broker<Integer> exchanger;
	
	public ThreadProducer(Broker<Integer> exchanger){
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
         for(int i=1;i<5;++i)
			try {
				exchanger.put(i);
				System.out.format("Producer produced %s%n", i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
	}
	
	

}
