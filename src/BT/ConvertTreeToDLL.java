package BT;



public class ConvertTreeToDLL {

	public static void main(String args[]) throws InterruptedException {
		BinaryTreeNode<Integer> top = new BinaryTreeNode<Integer>();
		

		int[] arry = { 1,2,3,4,5,6,7};
		for (int i = 0; i < arry.length; ++i) {
			top.insertNoBinaryTree(arry[i]);
		}

		
	
		 BinaryTreeView<Integer> btv = new BinaryTreeView<Integer>(top, 400, 400);
	        btv.refresh();
	      
	       Node root = new ConvertTreeToDLL().convertToDLL(top.root);
	       
	       new ConvertTreeToDLL().print(root);
	        
	}
	
	public void print(Node root){
		while(root.left != null){
			root = root.left;
		}
		
		while(root != null) {
			System.out.println(" "+root.data);
			root = root.right;
		}
	}
	
	public Node convertToDLL(Node root){
		while(root.left != null) {
			Node left = convertToDLL(root.left);
			while(left != null && left.right != null)
				left = left.right;
			
			left.right = root;
			root.left = left;
			
			
		}
		
		while(root.right != null) {
			Node right = convertToDLL(root.right);
			while(right != null && right.left != null){
				right = right.left;
			}
			
			right.left = root;
			root.right = right;
			
		}
		
		return root;
	}
}
