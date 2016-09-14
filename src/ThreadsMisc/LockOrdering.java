package ThreadsMisc;

import java.util.concurrent.CountDownLatch;

public class LockOrdering {

	CustomeLock lock = new CustomeLock();

	public void methodA() {
		synchronized (lock) {
			System.out.println("Method A");
			lock.next = "A";
			lock.notifyAll();
		}
	}

	public void methodB() {
		synchronized (lock) {

			while (!lock.next.equalsIgnoreCase("A")) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
				}
			}

			System.out.println("Method B ");
			lock.next = "B";
			lock.notifyAll();
		}
	}

	public void methodC() {
		synchronized (lock) {

			while (!lock.next.equalsIgnoreCase("B")) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
				}
			}

			System.out.println("Method C");
			lock.next = "C";
			lock.notifyAll();
		}

	}

	public static void main(String[] args) {
		final LockOrdering v1 = new LockOrdering();
		final CountDownLatch cdl = new CountDownLatch(1);

		Thread B = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					cdl.await();
				} catch (InterruptedException e) {
					System.out.println("..B Thread..." + e.getMessage());
				}

				v1.methodB();

			}

		});

		B.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Thread A = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					cdl.await();
				} catch (InterruptedException e) {

					System.out.println("..A Thread..." + e.getMessage());
				}
				v1.methodA();

			}

		});

		A.start();

		Thread C = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					cdl.await();
				} catch (InterruptedException e) {

					System.out.println("..C Thread..." + e.getMessage());
				}
				v1.methodC();

			}

		});

		C.start();

		System.out.println("all threads are invoked at count down...");
		cdl.countDown();
	}

}
