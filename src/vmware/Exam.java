package vmware;

import java.util.ArrayList;
import java.util.List;

public class Exam {
	
	static int val =1;

	
	public int myval(){
		try{
			val = val +1;
			return val;
		}catch(Exception e){
			return 0;
		}finally{
			val = val +1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Exam e = new Exam();
          System.out.println(e.myval());
          System.out.println(Exam.val);
          
          List<Integer> list = new ArrayList<Integer>();
          list.add(10);
          list.add(20);
          List xl = list;
          xl.add("Hi");
          
          for(Object o: xl){
        	  System.out.println(o);
          }
	}

}
