package linkedin;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger implements NestedIntegerIntf {
	
	private Integer value;
	boolean isInteger = false;
	private List<NestedInteger> list;
	
	public NestedInteger(){
		
	}
	
	
	
	public NestedInteger(Integer value, boolean isInteger){
		this.value = value;
		this.isInteger = true;
	}

	@Override
	public boolean isInteger() {
		if(value == null) return false;
		else return true;
	}

	@Override
	public Integer getInteger() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public List<NestedInteger> getList() {
		
		return list;
	}

	public void setList(List<NestedInteger> list) {
		this.list = list;
	}
	
	
	
	public static void main(String args[]){
		//Case:1
		List<NestedInteger> flist = new ArrayList<>();
		
		NestedInteger one = new NestedInteger(1, false);
		NestedInteger two = new NestedInteger(2, false);
		
		
		
		List<NestedInteger> list = new ArrayList<>();
		list.add(one);
		list.add(one);
		NestedInteger index0 = new NestedInteger();
		index0.setList(list);
		
		flist.add(index0);
		
		flist.add(new NestedInteger(2, true));		
		
	    flist.add(index0);
		
		for(NestedInteger n : flist){
			System.out.println("....."+ n);
		}
		
		
		System.out.println("...sum is "+ new NestedInteger().depthSum(flist));
	}
	
	
	
	public int reverseDepthSum(List<NestedInteger> input) {
		  if (input == null)
		   return 0;
		  return getReverseDepthSum(input, 1);
	 }
	
	
	private int getReverseDepthSum(List<NestedInteger> input, int maxDepth) {
		int sum = 0;
		
		if(input != null && input.size() == 0)  return 0;
		
		for (NestedInteger nested : input) {
			if (nested.isInteger()) {
				sum += nested.getInteger() * maxDepth;
			} else {
				sum += getReverseDepthSum(nested.getList(), maxDepth++);
			}
		}

		return sum;
	}
	
	
	//Working model for sum  incremental depth
	public int depthSum(List<NestedInteger> input) {
		  if (input == null)
		   return 0;
		  return getSum(input, 1);
	 }
	
	
	
	//Working model for sum  incremental depth	 
	private int getSum(List<NestedInteger> input, int depth) {
		int sum = 0;
		for (NestedInteger nested : input) {
			if (nested.isInteger()) {
				sum += nested.getInteger() * depth;
			} else {
				sum += getSum(nested.getList(), depth++);
			}
		}

		return sum;
	}
	 




	@Override
	public String toString() {
		return "NestedInteger [value=" + value + ", isInteger=" + isInteger
				+ ", list=" + list + "]";
	}
	
	

}
