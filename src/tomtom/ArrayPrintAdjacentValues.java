package tomtom;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ArrayPrintAdjacentValues {

	public static void main(String[] args) {
		int[] arr = {0,3,3,7,5,3,11,1};
		
		 Map<Integer, List<Integer>> m = solution(arr);
        getpairs(m);
	}
	
	public static void getpairs( Map<Integer, List<Integer>>  map){
		
		Iterator itr = map.values().iterator();
		List<Integer> left = (List<Integer>)itr.next();
		int count = 0;
		while(itr.hasNext()){
			List<Integer> right = (List<Integer>)itr.next();
			count += permutations(left, right);
			left = right;
		}
		
		
		
		System.out.println("final count "+ count);
	}
	
	public static int permutations(List<Integer> l, List<Integer> r){
		int mycount = 0;
		for(int i=0; i < l.size(); ++i) {
			for(int j=0; j<r.size(); ++j){
				int v1 = l.get(i);
				int v2 = r.get(j);
				if(v1 > v2) System.out.println("("+v2+","+v1+")");
				else System.out.println("("+v1+","+v2+")");
				++mycount;
			}
		}
		
		//get pairs of himself
		if(r.size() > 1) {
		for(int k=0;k<r.size();++k){
			for(int p=k+1; p < r.size(); ++p) {
				int v1 = r.get(k);
				int v2 = r.get(p);
				if(v1 > v2) System.out.println("("+v2+","+v1+")");
				else System.out.println("("+v1+","+v2+")");
				++mycount;
			 }
		}
		}
		return mycount;
	}
	
	public static Map<Integer, List<Integer>> solution(int[] arry){
		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		
		for(int i=0; i< arry.length; ++i){
			
			List<Integer> list =null;
			if(map.get(arry[i]) != null){
				list = map.get(arry[i]);								
			}else{
				list = new ArrayList<Integer>();
			}
			
			list.add(i);
			map.put(arry[i], list);
		}
		
		System.out.println(map);
		return map;
		
	}

}
