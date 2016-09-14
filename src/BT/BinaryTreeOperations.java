package BT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.Stack;

//import sun.misc.Queue;

public class BinaryTreeOperations {
	
	public void preOrder(BinaryTreeNode node){
		//System.out.println("Data: "+ );
	}
	
	public int findHalfNodeInBT(Node root){
		Queue<Node> q = new Queue<Node>();
		q.enqueue(root);
		int count = 0;
		while(!q.isEmpty()){
			try {
				Node node = q.dequeue();
				if((node.left==null && node.right!=null) || (node.left!=null && node.right==null)){
					count++;
				}
				if(node.left != null) q.enqueue(node.left);
				if(node.right != null) q.enqueue(node.right);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return count;
	}

	public static void main(String[] args) throws InterruptedException {
		BinaryTreeNode top = new BinaryTreeNode();
		BinaryTreeOperations btreeOps = new BinaryTreeOperations();

		int[] arry = { 3, 1, 2,4,7,6,9,5};
		for (int i = 0; i < arry.length; ++i) {
			top.insertNoBinaryTree(arry[i]);
		}

		
		//top.printTree();
		//PrintPretty.getDotFile(top);
		 BinaryTreeView<String> btv = new BinaryTreeView<String>(top, 400, 400);
	        btv.refresh();
	        
	    // top.preOrder(top.root);	     
	     System.out.println("Pre Order without recursion");
	     top.preOrderNoRecursion(top.root);
	     
	     //Find existance of a path with the given sum
	     System.out.println("\n");
	     System.out.println("is path exist for sum=8 "+ btreeOps.hasPathSum(top.root, 8));
	     //End
	     
	     //No of HalfNodes
	     System.out.println("No of Halfnode");
         System.out.println(""+btreeOps.findHalfNodeInBT(top.root));
         //End
         
         //Find height of the tree
          System.out.println("Height of BTree is: "+btreeOps.findHeight(top.root));
         //End
         
          //Find diameter of the tree
          System.out.println("Diameter of BTree is "+ btreeOps.diameterOfBinaryTree(top.root));
          //End
         
         //Start logic to find are these trees structurally identical
         System.out.println("Are structurally same trees ?");
         BinaryTreeNode top2 = new BinaryTreeNode();
 		 int[] arry2 = { 3, 1, 2,4,7,6,9,22};
 		 for (int i = 0; i < arry2.length; ++i) {
 		 	top2.insertNoBinaryTree(arry2[i]);
 		 }
 		 System.out.println("are these tree structurally identicall? "
 		 +btreeOps.areStructurallyIdentical(top.root, top2.root));
 		 //End structurally indentical tree logic         
 		 
 		 
 		 //Mirror of a binary tree
 		 Node mirrorNode = btreeOps.mirrorOfBTree(top.root);
 		// BinaryTreeNode mirrorTreeNode = new BinaryTreeNode();
 		 //mirrorTreeNode.setRoot(mirrorNode);
 		 //BinaryTreeView<String> mirrorBTV = new BinaryTreeView<String>(mirrorTreeNode, 400, 400);
 		 //mirrorBTV.refresh();
 		 //End
 		 
 		//Zig Zag Binary Tree
 		btreeOps.ZigZagBinaryTree(top.root);
 		
 		
 		 
	}
	
	
	
	public void ZigZagBinaryTree(Node root){
		Stack<Node> currentLevel = new Stack<Node>();
		Stack<Node> nextLevel = new Stack<Node>();
		int leftToRight = 1;
		System.out.println("*** ZIG ZAG Binary Tree ***");
		currentLevel.add(root);
		while(!currentLevel.isEmpty()){
			Node node = currentLevel.pop();
			System.out.print(" "+ node.data);
			if (node != null) {
				if (leftToRight == 1) {
					if(node.left != null)
					nextLevel.add(node.left);
					if(node.right != null)
					nextLevel.add(node.right);
				} else {
					if(node.right != null)
					nextLevel.add(node.right);
					if(node.left != null)
					nextLevel.add(node.left);
				}

				if (currentLevel.isEmpty()) {
					leftToRight = 1 - leftToRight;
					currentLevel.addAll(nextLevel);
					nextLevel.clear();
				}
			}
		}
		
		
	}
	
	public Node mirrorOfBTree(Node root){
		Node temp;
		
		if(root != null){
			mirrorOfBTree(root.left);
			mirrorOfBTree(root.right);
			temp = root.left;
			root.setLeft(root.right);
			root.setRight(temp);
		}
		
		return root;
	}
	
	public boolean hasPathSum(Node root, int sum, List<Integer> paths) {
		if (root == null)
			return (sum == 0);
		else {
			paths.add(root.data);
			sum = sum - root.data;
			return (hasPathSum(root.left, sum) || hasPathSum(root.right, sum));
		}
	}
	public boolean hasPathSum(Node root, int sum){
		List<Integer> paths = new ArrayList<Integer>();
		boolean isSumExist =  hasPathSum(root, sum, paths);
		if(isSumExist)
		  System.out.println(">>>>>>> Path is "+paths);
		return isSumExist;
	}
	
	//https://www.youtube.com/watch?v=i9nVJDr4HmA
	public int diameterOfBinaryTree(Node root){
		if(root == null) return 0;
		int lheight = findHeight(root.left);
		int rheight = findHeight(root.right);
		
		int ldiameter = diameterOfBinaryTree(root.left);
		int rdiameter = diameterOfBinaryTree(root.right);
		
		return Math.max((lheight+rheight+1), (ldiameter+rdiameter));
	}
	
	public int findHeight(Node root){
		if(root == null) return 0;
		else
			return(1+ Math.max(findHeight(root.left), findHeight(root.right)));
	}
	
	
	
	public boolean areStructurallyIdentical(Node node1, Node node2){
		if(node1 == null && node2 == null)
			return true;
		
		if(node1 != null && node2==null)
			return false;
		
		if(node1 == null && node2 != null)
			return false;
		
		return ((node1.data == node2.data) && (areStructurallyIdentical(node1.left, node2.left))
				&& (areStructurallyIdentical(node1.right, node2.right)));
		
	}

}
