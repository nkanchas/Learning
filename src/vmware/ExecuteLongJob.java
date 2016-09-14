package vmware;

public class ExecuteLongJob {
	
	private static boolean interuptTask = false;

	   private static class MyTask extends Thread{

	           public void run(){
	                 while(!interuptTask){
	                	 try {
	                		
							Thread.sleep(200L);
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                 }
	            }
	   }

	public static void main(String[] args) throws InterruptedException {
		Thread task = new MyTask();

		   task.start();

		   Thread.sleep(500L);

		   System.out.println("before interuption");
		   interuptTask = true;

		   System.out.println("after interuption");
		   task.join();


	}

}
