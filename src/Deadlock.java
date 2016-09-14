
public class Deadlock {
	String str1 = "india";
	String str2 = "bharath";

	Thread t1 = new Thread("A-Thread") {
		public void run(){
			synchronized (str1) {
				work();
				synchronized (str2) {
					work();
					System.out.println(str1 + str2);
				}
			}
		}
	};
	
	public void work(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	Thread t2 = new Thread("B-Thread") {
		public void run(){
			synchronized (str2) {
				 work();
				synchronized (str1) {
					 work();
					System.out.println(str1 + str2);
				}
			}
		}
	};
	
	
	public static void main(String[] args) {
		Deadlock d = new Deadlock();
		d.t1.start();
		d.t2.start();
	}

}
