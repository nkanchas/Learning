package Threads.EvenOddThread;

import java.util.concurrent.locks.Lock;

public class OddThread implements Runnable {

	int num;
	Object lock;

	public OddThread(int num, Object lock) {
		this.num = num;
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {

			for (int i = 1; i < num; i += 2) {
				lock.notify();
				
				System.out.println("OddThread: " + i);
				
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			//lock.notify();
		}
	}

}
