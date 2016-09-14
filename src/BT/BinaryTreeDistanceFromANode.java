package BT;

//http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
public class BinaryTreeDistanceFromANode {

	public static void main(String[] args) {
		formMyTree();
	}
	
	
	private static void formMyTree(){
		

			Node root = new Node(20);
			
			
		    root.left = new Node(8);
		    root.right = new Node(22);
		    root.left.left = new Node(4);
		    root.left.right = new Node(12);
		    root.left.right.left = new Node(10);
		    root.left.right.right = new Node(14);
		    Node  target = root.left.right;
		    
		    
		    
		    BinaryTreeNode top = new BinaryTreeNode();
		    top.setRoot(root);
		    BinaryTreeView<String> btv = new BinaryTreeView<String>(top, 400, 400);
	        btv.refresh();
		    
	        printkdistanceNode(root, target, 2);
	}
	
	/* Recursive function to print all the nodes at distance k in the
	   tree (or subtree) rooted with given root. See  */
	public static void printkdistanceNodeDown(Node root, int k)
	{
	    // Base Case
	    if (root == null || k < 0)  return;
	 
	    // If we reach a k distant node, print it
	    if (k==0)
	    {
	        //cout << root->data << endl;
	        System.out.println(root.data);
	        return;
	    }
	 
	    // Recur for left and right subtrees
	    printkdistanceNodeDown(root.left, k-1);
	    printkdistanceNodeDown(root.right, k-1);
	}
	
	public static int printkdistanceNode(Node root, Node target , int k)
	{
	    // Base Case 1: If tree is empty, return -1
	    if (root == null) return -1;
	 
	    // If target is same as root.  Use the downward function
	    // to print all nodes at distance k in subtree rooted with
	    // target or root
	    if (root == target)
	    {
	        printkdistanceNodeDown(root, k);
	        return 0;
	    }
	 
	    // Recur for left subtree
	    int dl = printkdistanceNode(root.left, target, k);
	 
	    // Check if target node was found in left subtree
	    if (dl != -1)
	    {
	         // If root is at distance k from target, print root
	         // Note that dl is Distance of root's left child from target
	         if (dl + 1 == k)
	           // cout << root.data << endl;
	         System.out.println(root.data);
	 
	         // Else go to right subtree and print all k-dl-2 distant nodes
	         // Note that the right child is 2 edges away from left child
	         else
	            printkdistanceNodeDown(root.right, k-dl-2);
	 
	         // Add 1 to the distance and return value for parent calls
	         return 1 + dl;
	    }
	 
	    // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
	    // Note that we reach here only when node was not found in left subtree
	    int dr = printkdistanceNode(root.right, target, k);
	    if (dr != -1)
	    {
	         if (dr + 1 == k)
	            //cout << root.data << endl;
	            System.out.println(root.data);
	         else
	            printkdistanceNodeDown(root.left, k-dr-2);
	         return 1 + dr;
	    }
	 
	    // If target was neither present in left nor in right subtree
	    return -1;
	}
}
