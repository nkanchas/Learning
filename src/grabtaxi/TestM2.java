package grabtaxi;

public class TestM2 {

	public static void main(String[] args) {
		//int[] A ={3,5,6,3,3,5};
		
		int[] A ={3,5,5,3,3,5};
		
		int count = 0;
        for(int i=0;i<A.length;i++)
          for(int j=i+1; j< A.length; j++)
             if(A[i] == A[j]) count++;
        
        
        System.out.println(count);

	}

}
