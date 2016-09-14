package ThreadsMisc;

public class AccessThread2 extends Thread {

private Employee e;
	
	public AccessThread2(Employee e){
		this.e = e;
	}
	
	public void run(){
		e.m2();
	}
}
