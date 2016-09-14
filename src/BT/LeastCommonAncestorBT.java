package BT;

/**
 * 
 * @author Naresh
 *
 */
public class LeastCommonAncestorBT {

	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(6);
        root.left.right = new Node(5);
 
        root.right.left = new Node(9);
        root.right.right = new Node(11);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(3);
 
        System.out.println("Lowest Common Ancestor of Node 3 and 9 is: "
                + findLowestCommonAncestor(root, root.right.right.right, root.right.left).data);
         
       /* System.out.println("Lowest Common Ancestor of Node 3 and null is: "
                + findLowestCommonAncestor(root, root.right.right.right, null).data);
         
        System.out.println("Lowest Common Ancestor of Node 5 and 2 is: "
                + findLowestCommonAncestor(root, root.left.right, root.left).data);
        
        System.out.println("Lowest Common Ancestor of Node 9 and 4 is: "
                + findLowestCommonAncestor(root, root.right.left, root.right).data);*/
        
        
        
        
        BinaryTreeNode btn = new BinaryTreeNode();
		btn.setRoot(root);
		BinaryTreeView<String> btv = new BinaryTreeView<String>(btn, 400, 400);
        btv.refresh();

	}
	
	
	public static Node findLowestCommonAncestor(Node root, Node a, Node b) {
		    Node left = null;
	        Node right = null;
	 
	        if (root == null) {
	            return null;
	        }
	 
	        /**
	         * If Node a or Node b is also the root, then the root itself is lowest common ancestor
	         */
	        if ((a != null && root.data == a.data) || ( b!= null && root.data == b.data)) {
	            return root;
	        }
	 
	        left = findLowestCommonAncestor(root.left, a, b);
	        right = findLowestCommonAncestor(root.right, a, b);
	 
	        /**
	         * If Node a and Node b lie in the left, their Lowest Common Ancestor is in the left.
	         * If Node a and Node b lie in the right,their Lowest Common Ancestor is in the right.
	         *
	         * Otherwise, root is the Lowest common ancestor.
	         */
	        if (left != null && right != null) {
	            return root;
	        }
	 
	        return (left != null) ? left : right;
	}

}
