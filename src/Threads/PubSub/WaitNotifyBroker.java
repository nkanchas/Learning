package Threads.PubSub;

public class WaitNotifyBroker<T> implements Broker<T>{
	
	private boolean empty=true;
	private T message;

	@Override
	public synchronized void put(T message) throws InterruptedException {
		while(!empty)
		   this.wait();
		
		empty = false;
		this.message = message;
		this.notify();
	}

	@Override
	public synchronized T take() throws InterruptedException {
		while(empty)
		  this.wait();
		
		empty = true;
		this.notifyAll();
		return message;
		
		
		
	}

}
