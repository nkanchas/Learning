package GeneralProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LongestIncreasingSubsequence {

	static List<List<Integer>> list = new ArrayList<List<Integer>>();
	
	public static void main(String[] args) {
		/*System.out.println("Enter size of array ");
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int[] arry = new int[N];
		for(int i =0;i<N;++i){
			int elem = scan.nextInt();
			arry[i]=elem;
		}
		
		//todo call method here
		findLongestIncreasingSubsequency(arry);
		
		*/
		
		//alternative reading input from file
		 try {
			FileInputStream fis = new FileInputStream("src/GeneralProblems/input.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line;
			int count=-1;
			int nSize=0;
			int[] array = new int[10];
			while((line=br.readLine()) != null){				
				if(count == -1) {
					nSize = Integer.parseInt(line);
					array = new int[nSize];
					count=0;
					//System.out.println("array size is "+ array.length);
				}else {
					int elem = Integer.parseInt(line);
					array[count++]=elem;
				}
			}
			
			findLongestIncreasingSubsequency(array);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
		//end		
		
		int bigsize=0;
		for(List<Integer> ml : list){
			if(ml.size() >  bigsize) bigsize = ml.size();
		}
		
		System.out.println(bigsize);

	}
	
	public static  void findLongestIncreasingSubsequency(int[] arry){
		int prevElem = arry[0];
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(prevElem);		
		list.add(list2);
		System.out.println("..0 "+ list2);
		for(int i=1; i<arry.length;++i){
			if(arry[i] > prevElem){
				prevElem = arry[i];		
				List<Integer> mylist = getList(list,prevElem);
				mylist.add(prevElem);
				System.out.println("....i="+i+" "+mylist);
				list.add(mylist);
			}else{
				List<Integer> mylist = getList(list,arry[i]);
				mylist.add(arry[i]);
				System.out.println("....i="+i+" "+mylist);
				list.add(mylist);
			}
		}
		
		
	}
	
	public static List<Integer> getList(List<List<Integer>> list, int num){
		List<Integer> copylist = new ArrayList<Integer>();
		
		int bigsize=0; 
		for(List<Integer> lst: list){
			int lastind = lst.size();
			int elem = lst.get(lastind-1);
			if(num > elem) {
				
				if(lst.size() > bigsize){
					copylist =  new ArrayList<Integer>(lst);
					bigsize = copylist.size();
				}
				//return copylist;
			}
			
		}
		
		return copylist;
	}

}
