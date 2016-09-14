package BT;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

//import sun.misc.Queue;

/*class Node {
	int data;
	Node left;
	Node right;
}*/

public class BinaryTreeNode<E> {

	Node root = null;
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}



	int height = 10;
	
	public void formBinaryTree(int[] arry){		
		for (int i = 0; i < arry.length; ++i) {
			try {
				insertNoBinaryTree(arry[i]);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}

	public void insertNoBinaryTree(int k) throws InterruptedException {

		Node node = new Node();
		node.data = k;

		if (root == null) {
			root = node;
		} else {
			Queue<Node> q = new Queue<Node>();
			q.enqueue(root);
			Node finalTrace = null;
			while(!q.isEmpty()){
				Node temp = q.dequeue();
				finalTrace = temp;
				if(temp.left != null)
					q.enqueue(temp.left);
				else break;
				if(temp.right != null)
					q.enqueue(temp.right);
				else break;
			}
			
			if(finalTrace.left == null){
				finalTrace.left = node;
			}else{
				finalTrace.right= node;
			}
		}
	}
	
	
	public void formInvalidBinaryTree(int[] arry){		
		for (int i = 0; i < arry.length; ++i) {
			try {
				insertInvalidBinaryTree(arry[i]);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
	
	public void formSingleChildBinaryTree(int[] arry){		
		for (int i = 0; i < arry.length; ++i) {
			try {
				insertSingleChildInvalidBinaryTree(arry[i]);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
	
	
	public void insertSingleChildInvalidBinaryTree(int k) throws InterruptedException {

		Node node = new Node();
		node.data = k;

		if (root == null) {
			root = node;
		} else {
			Queue<Node> q = new Queue<Node>();
			q.enqueue(root);
			Node finalTrace = null;
			while(!q.isEmpty()){
				Node temp = q.dequeue();
				finalTrace = temp;
				if(temp.left != null)
					q.enqueue(temp.left);
				else break;
				if(temp.right != null)
					q.enqueue(temp.right);
				else break;
			}
			
			Random r = new Random();
			int rnum = r.nextInt(10); 
			
			if(finalTrace.left == null){
			   if(!(rnum == 11 || rnum == 5 || rnum == 2 || rnum == 1 || rnum == 4 || rnum == 16 || rnum == 15))
				finalTrace.left = node;
			}else if(!(rnum == 7 || rnum == 3 || rnum == 6 || rnum == 7 || rnum == 8 || rnum == 9)){
				finalTrace.right= node;
			}
		}
	}

	
	/** This will form a non balanced Binary Tree
	 * 
	 * @param k
	 * @throws InterruptedException
	 */
	public void insertInvalidBinaryTree(int k) throws InterruptedException {

		Node node = new Node();
		node.data = k;

		if (root == null) {
			root = node;
		} else {
			Queue<Node> q = new Queue<Node>();
			q.enqueue(root);
			Node finalTrace = null;
			while(!q.isEmpty()){
				Node temp = q.dequeue();
				finalTrace = temp;
				
				if(temp.left != null)
					q.enqueue(temp.left);
				
				
				if(temp.right != null)
					q.enqueue(temp.right);
				
			}
			
			
			Random r = new Random();
			int rnum = r.nextInt(20); 
			
			if(finalTrace.left == null) {		
				
				finalTrace.left = node;
			}else {
				
				finalTrace.right= node;
			}
		}
	}
	
	

	public void printTree() throws InterruptedException {
		Queue<Node> q = new Queue<Node>();

		q.enqueue(root);

		while (!q.isEmpty()) {
			Node temp = q.dequeue();
			System.out.println("" + temp.data + ", ");
			if (temp.left != null)
				q.enqueue(temp.left);
			if (temp.right != null)
				q.enqueue(temp.right);
		}
	}
	
	/*
	 * With Recursion
	 */
	public void preOrder(Node root){
		if(root == null)  return;
		System.out.print("Data "+root.data+", ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void preOrderNoRecursion(Node root) {
		Stack<Node> stack = new Stack<Node>();
		// stack.push(root);
		while (true) {

			while (root != null) {
				System.out.print("Data " + root.data + " ");

				stack.push(root);
				root = root.left;
			}

			if (stack.isEmpty())
				break;

			Node right = stack.pop();

			root = right.right;

		}
	}
	
	public void postOrderNonRecursive(Node root) {
		Stack<Node> stack = new Stack<Node>();

		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			}else{
				//if(stack.)
			}

		}

	}
	
	

	public static void main(String args[]) throws InterruptedException {
		BinaryTreeNode top = new BinaryTreeNode();

		int[] arry = { 3, 1, 2,4,7,6,9};
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
	     
	     System.out.println("No of Halfnode");
	}
}
