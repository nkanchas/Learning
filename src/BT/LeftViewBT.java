package BT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewBT {
	List<Integer> result = new ArrayList<Integer>();
	
	public void leftViewWithOutRecursion(Node root){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()){
			
			int size = q.size();
			for(int i=0; i< size; ++i){
				Node node = q.poll();
				
				if(i==0) result.add(node.data);
				
				if(node != null && node.left != null) {
					q.add(node.left);					
				}
				
				if(node != null && node.right != null)
					q.add(node.right);
			}
		}
		
		printResult();
	}

	
	public void printResult(){
      for(Integer val: result){
    	  System.out.print(" "+val );
      }
		System.out.println("\n");
	}
	
	
	
	
	
	
	
	
	public static void main(String args[]) {
		
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

		LeftViewBT lv = new LeftViewBT();
		lv.leftViewWithOutRecursion(root);
		
		//BFS search
		/* Create following Binary Tree
        1
      /  \
     2    3
      \
       4
        \
         5
          \
           6*/
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.right = new Node(4);
		root2.left.right.right = new Node(5);
		root2.left.right.right.right = new Node(6);

		LeftViewBT p = new LeftViewBT();
		p.leftViewWithOutRecursion(root2);
	}

}
