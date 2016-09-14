package CustomThreadPool;

public class Test {

	public static void main(String[] args) {
		ThreadPoolManager tpm = new ThreadPoolManager(3);
		
		tpm.execute(new Runnable(){
			
			@Override
			public void run() {				
				System.out.println("Starting Thread A");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
				System.out.println("Thread A Completed.");
			}			
		});
		
		
      tpm.execute(new Runnable(){			
			@Override
			public void run() {				
				System.out.println("Starting Thread B");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
				System.out.println("Thread B Completed.");
			}			
		});

	}

}
