package Threads.PubSub;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PubSubMain {

	
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		Broker<Integer> exchanger = new WaitNotifyBroker<Integer>();
		ThreadProducer tp = new ThreadProducer(exchanger);
		ThreadConsumer tc = new ThreadConsumer(exchanger);
		service.execute(tp);
		service.execute(tc);
        service.shutdown();
	}

}
