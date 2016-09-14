package ThreadsMisc;

import java.text.SimpleDateFormat;

public class Employee{
	private String name;
	private String department;
	
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");
	
	
	
	public synchronized void m1(){
		String dateString = formatter.format(new java.util.Date());
		System.out.println("..inside method m1()..."+ dateString);
		try{
			Thread.sleep(5000);
		}catch(Exception ex){}
		System.out.println("..inside method m1()...exit");
	}
	
	public synchronized void m2(){
		String dateString = formatter.format(new java.util.Date());
		System.out.println("..inside method m2()..."+dateString);
		try{
			Thread.sleep(4000);
		}catch(Exception ex){}
		System.out.println("..inside method m2()...exit");
	}
	
	
	public static synchronized void m3(){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");
		String dateString = f.format(new java.util.Date());
		System.out.println("..inside method m3()..."+ dateString);
		try{
			Thread.sleep(3000);
		}catch(Exception ex){}
		System.out.println("..inside method m3()...exit");
	}
	
	public static synchronized void m4(){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");
		String dateString = f.format(new java.util.Date());
		System.out.println("..inside method m4()..."+ dateString);
		try{
			Thread.sleep(3000);
		}catch(Exception ex){}
		System.out.println("..inside method m4()...exit");
	}

	
}
