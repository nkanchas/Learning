package BT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class KaramanchiExcercises {

	BinaryTreeOperations bto = new BinaryTreeOperations();
	
	public static void main(String[] args) {
		BinaryTreeNode top = new BinaryTreeNode();
	    /*int[] arry = { 23, 1, 2,4,7,6,9,11};		
	   top.formBinaryTree(arry);*/
		
		 int[] arry = { 6,2,8,1,9, 11, 15};		
		  top.formBinaryTree(arry);
	   
		//This is to delete single node in a binary tree
		//int[] arry = { 23, 1, 2,4,7,6,9,11, 22, 12, 33, 19, 18};
		//top.formSingleChildBinaryTree(arry);		
	    
	    BinaryTreeView<String> btv = new BinaryTreeView<String>(top, 400, 400);
        btv.refresh();
        
        
     // System.out.println("max is "+ new KaramanchiExcercises().findMax(top.root));
      
      //new KaramanchiExcercises().printLevelReservOrder(top.root);
        
     //  System.out.println("height..."+ new KaramanchiExcercises().findHeightWithOutRecursion(top.root));
        
        //print binary tree sideways
       // new KaramanchiExcercises().printSideways(top.root);
        
       // new KaramanchiExcercises().inorderNoRecursion(top.root);
        
       // new KaramanchiExcercises().preOrderNoRecursion(top.root);
      
        ArrayList<Integer> list =  new KaramanchiExcercises().postOrderNoRecursion(top.root);
        System.out.println("POST Order: "+ list);
        
     //  System.out.println("list(Inorder).."+ new KaramanchiExcercises().getInorder(top.root));
       
       //System.out.println("list(PostOrder).."+ new KaramanchiExcercises().getPostOrder(top.root));
       
       //new KaramanchiExcercises().leastCommonAncestorOfBT(top.root, 4, 7);
        
       // new KaramanchiExcercises().deleteSingleNode(top.root);
        
       // new KaramanchiExcercises().deleteMySingle(top.root, null);
        
       //1st way not working.........
        //Boolean doesAllLeafsSameHeight =   new KaramanchiExcercises().checkLeafNode(top.root, 1, 0);
       //System.out.println("...doesAllLeafSameHeight..."+ doesAllLeafsSameHeight);
       
       //2nd way  my own way...working for all cases
        // KaramanchiExcercises m = new KaramanchiExcercises();
        //m.doesAllLeafesOnSameDepth(top.root,1);
       // System.out.println("...map..."+ m.leafmap);
        
        //fails for few scenarios
       // System.out.println(" isBST "+ new KaramanchiExcercises().isBST(top.root));
        
        //works for all cases in best time complexity        
        //System.out.println(" isBST "+ new KaramanchiExcercises().isBSTUsingInOrder(top.root));
	}
	
	
	//from karamanchi chapter.....O(n)
	static int prev = -1;
	public boolean isBSTUsingInOrder(Node root) {	
		
		if (root != null) {

			if (!isBSTUsingInOrder(root.left))
				return false;

			if (prev != -1 && root.data < prev)
				return false;

			prev = root.data;

			return isBSTUsingInOrder(root.right);
		}

		return true;
	}
	
	//this method fails for below tree    int[] arry = { 6,2,8,1,9};	
	/**           6
	 *          /   \
	 *        2      8 
	 *       / \
	 *      1   9
	 * @param root
	 * @return
	 */
	public boolean isBST(Node root){
		if(root == null)  return true;
		
		if(root.left !=null &&  root.left.data > root.data)
			return false;
		else if(root.right != null &&  root.right.data < root.data)
			return false;
		
		if((isBST(root.left)) && (isBST(root.right)))
			return true;
		else 
			return false;
	}
	
	Map<Integer, Integer> leafmap = new HashMap<Integer, Integer>();
	public boolean doesAllLeafesOnSameDepth(Node root, int level){
		if(root == null) return false;
		
		 doesAllLeafesOnSameDepth(root.left, level+1);
		 System.out.println("..node.."+root.data+"..level"+ level);
		
		 doesAllLeafesOnSameDepth(root.right, level+1);
		 
		 if(root.left == null && root.right == null)
			   leafmap.put(root.data, level);
		 
		 --level;		 
		 
		 
		 return true;
	}
	
	
	public boolean checkLeafNode(Node root, int level, int leafNode){
		
		if(root == null) return true;
		
		if(root.left == null && root.right == null){
			
			if(leafNode == 0){
				leafNode = level;
				//return true;
			}			
			
			return (level == leafNode);
		}
		
		return (checkLeafNode(root.left, level+1, leafNode) && checkLeafNode(root.right, level+1, leafNode));
	}
	

   public void deleteMySingle2(Node root){
		
		if(root == null) return ;
		
		if(root.left == null && root.right != null){
			System.out.println("...found sinle node..."+ root.data);
			Node temp = root;			
			root = root.right;
			temp=null;
		}else if(root.left != null && root.right == null){
			System.out.println("...found sinle node..."+ root.data);
			//System.out.println("...single node parent is "+ prevNode.data);
			Node temp = root;
			root = root.left;
			temp = null;
			//root = prevNode;
		}
		
		//prevNode = root;
		deleteMySingle2(root.left);
		
		deleteMySingle2(root.right);		
	}

    /** Delete a node having only one children
     * 
     * @param root
     * @param prevNode
     */
	public void deleteMySingle(Node root, Node prevNode){
		
		if(root == null) return ;
		
		if(root.left == null && root.right != null){
			System.out.println("...found sinle node..."+ root.data);
			System.out.println("...single node parent is "+ prevNode);
			prevNode.right = root.right;
			root = prevNode;
		}else if(root.left != null && root.right == null){
			System.out.println("...found sinle node..."+ root.data);
			System.out.println("...single node parent is "+ prevNode.data);
			if(prevNode.left.data == root.data) {
			   prevNode.left = root.left;
			   root = prevNode.left;
			}else if(prevNode.right.data == root.data) {
				prevNode.right = root.left;
			    root = prevNode.right;
			}
			
			//root = prevNode;
		}
		
		prevNode = root;
		deleteMySingle(root.left, prevNode);
		
		deleteMySingle(root.right, prevNode);		
	}
	
	public void deleteSingleNode(Node root){
		Stack<Node> stack = new Stack<>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
				foundSingle(root, stack);
			}

			if (stack.isEmpty())
				return;

			Node n = stack.pop();

			System.out.print(" (" + n.data+")");
			
			
			root = n.right;
		}
		
	}
	
	public void foundSingle(Node n, Stack<Node> stack){
	 if( n != null && stack.size() > 0)	{
		if(n.left == null && n.right == null)
			System.out.print(" leaf "+ n.data);
		else if((n.left != null && n.right == null) || n.left == null && n.right != null) {
			System.out.println("..single child i guess "+ n.data);
		
				Node singleChildParent = stack.peek();
				
			System.out.println("...parent of single child is "+ singleChildParent.data);
			
		}
	 }
	}
	
	public ArrayList<Integer> postOrderNoRecursion(Node root) {
		
		 ArrayList<Integer> rst = new ArrayList<Integer>();
	        if (root == null)
	            return rst;
	        Stack<Node> stack = new Stack<Node>();
	        Node curr = null;
	        Node prev = null;
	        stack.push(root);
	        while (!stack.empty())
	        {
	            curr = stack.peek();
	          
	            //traverse down
	            if (prev == null || prev.left == curr || prev.right == curr)
	            {
	                if (curr.left != null)
	                    stack.push(curr.left);
	                //need to traverse to the bottom of the tree first before goes to the right side
	                else if (curr.right != null)
	                    stack.push(curr.right);
	            }
	            // here comes the right side
	            else if (curr.left == prev)
	            {
	                if (curr.right != null)
	                    stack.push(curr.right);
	            }
	            //finally we can add nodes
	            else
	            {
	                rst.add(curr.data);
	                stack.pop();
	            }
	            
	            
	            prev = curr;
	        }
	        return rst;
	  
		
		
		/*
		 * Stack<Node> stack = new Stack<Node>(); Node prevnode = null;
		 * while(true) {
		 * 
		 * if(root != null){ stack.push(root); root = root.left; }else
		 * 
		 * if(stack.isEmpty()){ return; }else{
		 * 
		 * if(stack.peek().right == null){ root = stack.pop();
		 * System.out.print(" "+ root.data); //special case. avoid repeatation
		 * if(stack.peek().right != null && (root.data ==
		 * stack.peek().right.data)){ System.out.print(" "+ stack.peek().data);
		 * stack.pop(); }
		 * 
		 * if(!stack.isEmpty()){ root = stack.peek().right; } else root = null;
		 * } } }
		 */

	}
		
	
		
	
	
	//NLR  (PreOrder)
	public void preOrderNoRecursion(Node root){
		Stack<Node> stack = new Stack<Node>();
		
		while(true){
			
			while(root != null){
				System.out.print(" "+ root.data);
				stack.push(root);
				root = root.left;
			}
			
			if(stack.isEmpty()) return;
			
			Node n = stack.pop();
			root = n.right;
		}
	}
	
	//LNR
	public void inorderNoRecursion(Node root) {
		Stack<Node> stack = new Stack<Node>();

		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			if (stack.isEmpty())
				return;

			Node n = stack.pop();

			System.out.print(" " + n.data);

			root = n.right;
		}
	}
	
	
	
	public int findHeightWithOutRecursion(Node root){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int height=0;
		while(true){
			int nodeCount = q.size();
			
			
			if(nodeCount == 0)
				return height;
			
			height++;
			
			while(nodeCount > 0){
				
				Node node = q.remove();
				if(node.left != null)
					 q.add(node.left);
				else if(node.right != null)
					q.add(node.right);
				
				nodeCount--;
			}
		}
		
		
	}
	
	public void printLevelReservOrder(Node root){
		Queue<Node> q = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		q.add(root);
		while(!q.isEmpty() ){
		  Node item = q.poll();
		  
		  if(item.left != null)
			  q.add(item.left);
		  if(item.right != null)
			  q.add(item.right);
		  
		  System.out.print(" "+ item.data);
		  stack.add(item.data);
		}
	
		System.out.println("\n Reserv Order");
		while(stack.peek() != null){
			System.out.print(" "+stack.pop());
		}
		
		
	}
	
	//Problem:1
	public int findMax(Node root) {
		int max = 0, root_val;

		if (root != null) {
            root_val = root.data;
            
			int left = findMax(root.left);
			int right = findMax(root.right);

			if (left > right) {
				max = left;
			} else {
			   max = right;
			}
			
			if(root_val > max)
				max = root_val;
		}
		
		return max;
	}
	
	
	 public void printSideways(Node overallRoot)
     {
         printSideways(overallRoot, 0);
     }
	 
	 
     public void printSideways(Node root, int indent)
     {
         if (root != null)
         {
             String indentS = "";
             for (int i = 0; i < indent; i++)
                 indentS += "    ";
             indent++;
             printSideways(root.right, indent);
             System.out.println(indentS + "(" + root.data + ")");
             printSideways(root.left, indent);
         }
     }
     
     
     //https://www.youtube.com/watch?v=LFjCr2yDJdc
     public void leastCommonAncestorOfBT(Node root, int left, int right){
    	 List<Integer> inorderlist = getInorder(root);
    	 Map<Integer, Integer> postordermap = getPostOrder(root);
    	 
    	 List<Integer> lcplist = new ArrayList<>();
    	 boolean Start= false;    	
    	 for(Integer in : inorderlist){
    		 if(in.intValue() == left) {
    			 Start = true;
    			 
    		 }else if(in.intValue() == right){
    			 Start = false;
    			 lcplist.add(in);    			
    		 }
    		 
    		 if(Start)
    		    lcplist.add(in);
    	 }
    	 
    	 int mindex =0; int key=0;
    	 for(Integer i : lcplist){
    		Integer index =  postordermap.get(i);
    		if(index > mindex) {
    			mindex = index;
    			key = i.intValue();
    		}
    	 }
    	 
    	 System.out.println("LCP OF ( "+ left+", "+ right+") is"+ key );
    	 
     }
     
     
     public List<Integer> getInorder(Node root){
    	 List<Integer> inorderList = new ArrayList<Integer>();
    	 inorder(root, inorderList);
    	 return inorderList;
     }
     
     public Map<Integer, Integer> getPostOrder(Node root){
    	 Map<Integer, Integer> lmap = new LinkedHashMap<Integer, Integer>();
    	 postOrder(root, lmap);
    	 return lmap;
     }
     
     //LNR
     private void inorder(Node root, List<Integer> inorderList) {
    	 if(root == null) return;
    	 inorder(root.left, inorderList);
    	 inorderList.add(root.data);
    	 inorder(root.right, inorderList);
     }
     
     //LRN
     int counter =0;
     private void postOrder(Node root, Map<Integer, Integer> lmap){
    	 if(root == null) return;
    	 postOrder(root.left, lmap);
    	 postOrder(root.right, lmap);
    	 lmap.put(root.data, ++counter);
    	 
     }

}
