package ThreadsMisc;

public class TestSync {

	public static void main(String[] args) {
		
		Employee ee = new Employee();
		Thread t1 = new AccessThread1(ee);
		Thread t2 = new AccessThread2(ee);
		Thread t3 = new AccessThread3(ee);
		Thread t4 = new AccessThread4(ee);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
