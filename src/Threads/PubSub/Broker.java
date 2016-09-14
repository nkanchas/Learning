package Threads.PubSub;

public interface Broker<T> {
	void put(T message) throws InterruptedException;
	
	T take() throws InterruptedException;

}
