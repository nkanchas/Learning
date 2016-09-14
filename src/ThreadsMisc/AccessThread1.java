package ThreadsMisc;

public class AccessThread1 extends Thread{
	
	private Employee e;
	
	public AccessThread1(Employee e){
		this.e = e;
	}
	
	public void run(){
		e.m1();
	}

}
