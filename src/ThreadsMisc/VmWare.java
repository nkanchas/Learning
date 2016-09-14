package ThreadsMisc;


import java.util.concurrent.CountDownLatch;


public class VmWare {

	Object  lockA = new Object();
	Object  lockB = new Object();
	Boolean alock = new Boolean(true);
	Boolean block = new Boolean(true);
	
	public void  methodA(){
		synchronized (lockA) {
		  
		   System.out.println("Method A");
		   alock = new Boolean(false);
		   lockA.notify();
		}
	}
	
	
    public void  methodB(){
    	synchronized (lockA) {
    		synchronized (lockB) {
    		if(alock.booleanValue()) {
    		    try {
					lockA.wait();
				} catch (InterruptedException e) {
				}
    		}
    		
    		
    		System.out.println("Method B");
    		block = new Boolean(false);
 		    lockB.notify();
    		}
    	}
	}


    public void  methodC(){
    
    	synchronized (lockB) {	
    		
    		if(block.booleanValue()) {
    		    try {
					lockB.wait();
				} catch (InterruptedException e) {
				}
    		}
    		
    		
    	  System.out.println("Method C");
    	}
	}

    
    
	public static void main(String[] args) {
		final VmWare v1 = new VmWare();
		final CountDownLatch  cdl = new CountDownLatch(1);	
		
		Thread B = new Thread(new Runnable(){

			@Override
			public void run() {
				       
				        	try {
								cdl.await();
							} catch (InterruptedException e) {
								System.out.println("..B Thread..."+e.getMessage());								
							}	
						
		        		v1.methodB();
				
			}
			
		});
		
		B.start();
		
		
		
		Thread A = new Thread(new Runnable(){

			@Override
			public void run() {
				   try {
					   cdl.await();
					} catch (InterruptedException  e) {
						
						System.out.println("..A Thread..."+e.getMessage());
					}
		        		v1.methodA();
				
			}
			
		});
		
		A.start();
		
		
		
		
		
		Thread C = new Thread(new Runnable(){

			@Override
			public void run() {
				    try {
				    	cdl.await();
					} catch (InterruptedException  e) {
						
						System.out.println("..C Thread..."+e.getMessage());
					}
		        		v1.methodC();
				
			}
			
		});
		
		C.start();
		
		
		System.out.println("all threads are invoked at count down...");
		cdl.countDown();

	}

}
