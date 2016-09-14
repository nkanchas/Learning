package BT;



public class TreeFromArray {
	
	Node root = new Node();
	
	
	public void level_order_insert(Node root, int[] arr, int start, int size)
	{
	    int left = 2*start+1;
	    int right = 2*start+2;
	 
	    if(left > size || right > size)
	        return;
	 
	    if(root == null) {
	       Node tobj = createNode(arr[start]);
	        root = tobj;
	    }
	 
	    if(root.left == null && root.right == null) {
	        if(left < size)
	            root.left = createNode(arr[left]);
	        if(right < size)
	            root.right = createNode(arr[right]);
	    }
	    level_order_insert(root.left, arr, left, size);
	    level_order_insert(root.right, arr, right, size);
	 
	}
	
	public Node createNode(int i){
		return new Node(i);
	}
	
	
	
	
	
	public void inorder(Node root){
		if(root == null) return;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
		
	}

	public static void main(String[] args) {
		int A[] = {0,1,2,3,4,5,6,7,8,9};
		 TreeFromArray tfa  = new TreeFromArray();
		tfa.level_order_insert(tfa.root, A, 0, 10);
		System.out.println("tree building done...");
		
		BinaryTreeNode btn = new BinaryTreeNode();
		btn.setRoot(tfa.root);
		BinaryTreeView<String> btv = new BinaryTreeView<String>(btn, 400, 400);
        btv.refresh();
		
		tfa.inorder(tfa.root);
	}

}
