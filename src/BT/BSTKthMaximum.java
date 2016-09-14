package BT;

public class BSTKthMaximum {

	public static void main(String[] args) {
		Node root = new Node(17);
		
		
	    root.left = new Node(13);
	    root.right = new Node(21);
	    root.left.left = new Node(10);
	    root.left.right = new Node(15);
	    root.left.right.right = new Node(16);
	    
	    
	    root.right.right = new Node(24);
	    root.right.left = new Node(20);
	    
	    root.right.right.left = new Node(23);
	    root.right.right.right = new Node(27);
	    Node  target = root.left.right;
	    
	    
	    
	    BinaryTreeNode top = new BinaryTreeNode();
	    top.setRoot(root);
	    BinaryTreeView<String> btv = new BinaryTreeView<String>(top, 400, 400);
        btv.refresh(); 
        
       Node node = FindKthMax(root, 5);
        
        System.out.println("..."+ node.data);
        
       //Node n = LargestHelper(root, 5, 0);
       //System.out.println(n.data);

	}
	
	
	static int count=0;

	public static Node FindKthMax(Node root, int k) {
		if (root == null)
			return root;
		
		Node right = FindKthMax(root.right, k);
		
		if (count == k)
			return right;
		
		++count;
		
		if (count == k)
			return root;
		
		return FindKthMax(root.left, k);

	}

}
