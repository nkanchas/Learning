package Threads.EvenOddThread;

import java.util.Queue;

public class EvenThread implements Runnable {

	int num;
	Object lock;

	public EvenThread(int num, Object lock) {
		this.num = num;
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {

			for (int i = 0; i < num; i += 2) {

				lock.notify();

				System.out.println("EvenThread: " + i);

				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}

}
