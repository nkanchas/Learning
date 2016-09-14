package ThreadsMisc;

public class AccessThread3 extends Thread{
	
private Employee e;
	
	public AccessThread3(Employee e){
		this.e = e;
	}
	
	public void run(){
		Employee.m3();
	}

}
