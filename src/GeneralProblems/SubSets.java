package GeneralProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {
	
	//power set  for n elements 2 power n pairs exist.
	//http://www.geeksforgeeks.org/power-set/
	public static void main(String args[]){
		List<Integer> t = new ArrayList<Integer>();
		int[] nums = {1,2,3};
		SubSets ss = new SubSets();
		ss.dfs(ss.res, t, 0, nums);
		
		System.out.println("output "+ss.res);
	}
	
	
	public List<List<Integer>> res = new ArrayList<List<Integer>>();

	public  void dfs(List<List<Integer>> res, List<Integer> temp, int end,
			int[] nums) {
		
		if(end == nums.length){
			res.add(copyList(temp));
			return;
		}
		
		temp.add(nums[end]);
		dfs(res, temp, end+1, nums);
		temp.remove(temp.size()-1);
		dfs(res, temp, end+1, nums);
		
	}
	
	public List<Integer> copyList(List<Integer> tlist){
		List<Integer> list = new ArrayList<Integer>();
		for(Integer i: tlist){
			list.add(i);
		}
		return list;
	}
}
