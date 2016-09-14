
public class Deadlock2 {
	
	
  public static void main(String args[]){
	    Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
	  Thread t1 = new Thread(new SyncThread(obj1, obj2), "T1");
	  Thread t2 = new Thread(new SyncThread(obj2, obj3), "T2");
	  Thread t3 = new Thread(new SyncThread(obj3, obj1), "T3");
	  
	  t1.start();
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	  t2.start();
  }
}

class SyncThread implements Runnable{
	Object obj1,obj2;

	public SyncThread(Object obj1, Object obj2){
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	@Override
	public void run() {
		synchronized (obj1) {
			work();
			synchronized (obj2) {
				work();
			}
		}		
	}
	
	public void work(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}