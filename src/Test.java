


import java.util.Stack;

import BT.BinaryTreeNode;
import BT.BinaryTreeView;
import BT.Node;




public class Test {

	public static void main(String[] args) {
		
		
		
		BinaryTreeNode top = new BinaryTreeNode();
		 int[] arry = { 6,2,8,1,9, 11, 15};		
		  top.formBinaryTree(arry);
	    
	    BinaryTreeView<String> btv = new BinaryTreeView<String>(top, 400, 400);
        btv.refresh();
        
        System.out.println(new Test().postorderNoRec(top.getRoot()));
	}
	
	public Stack<Integer> postorderNoRec(Node root){
		Node prev=null;
		Node curr=null;
		
		Stack<Node> st = new Stack<Node>();
		Stack<Integer> result = new Stack<Integer>();
		
		st.push(root);
		
		while(!st.isEmpty()){
			curr = st.peek();
			
			if(prev == null || curr == prev.getLeft() 
				|| curr == prev.getRight()){
				
				if(curr.getLeft() != null){
					st.push(curr.getLeft());
				}else if(curr.getRight() != null){
					st.push(curr.getRight());
				}
			}else if(prev == curr.getLeft()){
				if(curr.getRight() != null)
					st.push(curr.getRight());
			}else{
				result.add(curr.getData());
				st.pop();
			}
			
			prev = curr;
		}
		
		return result;
		
	}

}
