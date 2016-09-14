package BT;

public class BalancedTree {

	BinaryTreeOperations bto = new BinaryTreeOperations();
	
	public static void main(String[] args) {
		BinaryTreeNode top = new BinaryTreeNode();
		int[] arry = { 3, 1, 2,4,7,6};		
	    top.formInvalidBinaryTree(arry);
	   
		//top.formBinaryTree(arry);
		
		
	    
	    BinaryTreeView<String> btv = new BinaryTreeView<String>(top, 400, 400);
        btv.refresh();

       // new BalancedTree().isBalancedInPolynomialTime(top, arry);
        
        System.out.println(".....Linear Time Balanced Tree..."+new BalancedTree().isBalancedLinearTime(top));
       
	}
	
	
	public void isBalancedInPolynomialTime(BinaryTreeNode top){
		
		 System.out.println("is this tree balanced "+ new BalancedTree().checkBinaryTreeisBalancedPolynomialTime(top.root));
	}
	
	
	
	
	public boolean isBalancedLinearTime(BinaryTreeNode top) {
		
		if(top.root == null) return true;
		
		int isBalanced = checkHeightInLinearTime(top.root);
		
		if(isBalanced == -1)
			return false;
		else return true;
	}
	
	
	private int checkHeightInLinearTime(Node root){
	    	if(root == null) return 0;
	    	
	    	int lheight = checkHeightInLinearTime(root.left);
	    	if(lheight <= -1)
	    		return -1;
	    	
	    	int rheight = checkHeightInLinearTime(root.right);
	    	if(rheight <= -1)
	    		return -1;
	    	
	    	int diffHeight = Math.abs(lheight-rheight);
	    	
	    	if(diffHeight > 1)
	    		return -1;
	    	else return 1+Math.max(lheight, rheight);   	
	}
	
	/** Below method has to call for each and every node of a tree then it will become polynomial
	 * 
	 * @param root
	 * @return
	 */
	public boolean checkBinaryTreeisBalancedPolynomialTime(Node root){
		if(root == null)
			return true;
		
	   int lheight = bto.findHeight(root.left);
	   int rheight = bto.findHeight(root.right);
	   
	   int diffHeight = Math.abs(lheight-rheight);
	   
	   if(diffHeight > 1){
		   return false;
	   }
	   
	   return true;
		
	}
	
	
	

}
