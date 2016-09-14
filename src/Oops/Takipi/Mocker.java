package Oops.Takipi;


//http://blog.takipi.com/4-out-of-5-java-developers-failed-to-solve-this-question/?utm_content=buffer70deb&utm_medium=social&utm_source=twitter.com&utm_campaign=buffer
import java.sql.SQLException;

public class Mocker<T extends Exception> {
	
	public void pleaseThrow(final Exception t) throws T{
		  throw (T)t;
	}
	
	
	public static void main(String args[]){
		//try{
		 new Mocker<RuntimeException>().pleaseThrow(new SQLException());
		 
		//}catch(final SQLException ex){
			//ex.printStackTrace();
		//}
	}

}
