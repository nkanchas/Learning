package GeneralProblems;

public class PrintAllPaths {
	
	
	int [][] array;
    int rowCount;
    int colCount;
 
 
    public PrintAllPaths(int [][]array){
 
        this.array = array;
        rowCount = array.length;
        colCount = array[0].length;
 
    }
    
    /*static void printPaths (String tempString, int i, int j, int m, int n, int [][] arr) {
		String newString = tempString + arr[i][j];
		if (i == m -1 && j == n-1) {
			System.out.println(newString);
			return;
		}
		//right
		if (j+1 < n) {
			printPaths (newString, i, j+1, m, n, arr);
		}
		//down
		if (i+1 < m) {
			printPaths (newString, i+1, j, m, n, arr);			
		}
	}*/
    
    //http://joaoff.com/2008/01/20/a-square-grid-path-problem/
    public void printAllPaths(int currX, int currY, String path){
    	 
        if(currX == rowCount-1){
            for(int j=currY;j<=colCount-1;j++){
                path = path + array[currX][j];
            }
            System.out.println("Path : " + path);
            return;
        }
 
        if(currY == colCount-1){
            for(int i=currX;i<=rowCount-1;i++){
                path = path + array[i][currY];
            }
            System.out.println("Path : " + path);
            return;
        }
        path = path + array[currX][currY];
        printAllPaths(currX+1, currY, path);
        printAllPaths(currX, currY+1, path); 
    }
    
    
    //count no of paths
    public int  numberOfPaths(int m, int n)
    {
       // If either given row number is first or given column number is first
       if (m == 1 || n == 1)
            return 1;
     
       // If diagonal movements are allowed then the last addition
       // is required.
       return  numberOfPaths(m-1, n) + numberOfPaths(m, n-1); 
               // + numberOfPaths(m-1,n-1);
    }



	public static void main(String[] args) {
		 int [][] ar = new int[][]{{1, 2, 3}, {4, 5, 6}};
		 PrintAllPaths allPathsPrinter = new PrintAllPaths(ar);
	        allPathsPrinter.printAllPaths(0,0,"");
	        
	        //printPaths("", 0, 0, ar.length, ar[0].length, ar);
	
        System.out.println("Algo Count no of paths: "+allPathsPrinter.numberOfPaths(2, 3));
	}

}
