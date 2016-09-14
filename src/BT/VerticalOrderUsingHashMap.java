package BT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalOrderUsingHashMap {
	
	public void getVerticalOrder(Node root, int hd, Map<Integer, List<Integer>> map){
		if(root == null)  return;
		
		if(map.get(hd) != null){
			((List<Integer>)map.get(hd)).add(root.data);			
		}else{
			List<Integer> l = new ArrayList<Integer>();
			l.add(root.data);
			map.put(hd, l);
		}
		
		getVerticalOrder(root.left, hd-1, map);
		getVerticalOrder(root.right, hd+1, map);
	}
	
	
	public void printVerticalOrder(Node root){
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		
		getVerticalOrder(root, 0, map);
		
		System.out.println(map);
	}
	
	public static void main (String args[]) {
		/* Create following Binary Tree
        1
      /  \
     2    3
    / \   /\
   4   5 6  7
          \  \
           8  9
        */     
         
         
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);

		new VerticalOrderUsingHashMap().printVerticalOrder(root);
	}
	

}


