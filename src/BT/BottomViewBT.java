package BT;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BottomViewBT {
	
	class QueuePack {
		int level;
		Node tnode;

		public QueuePack(int level, Node tnode) {
			this.level = level;
			this.tnode = tnode;
		}
	}
	
	
	public void bottomView(Node root) {
		
		Queue<QueuePack> q = new LinkedList<QueuePack>();
		QueuePack qp = new QueuePack(0, root);
		q.add(qp);
		Map<Integer, Integer> rmap = new HashMap<Integer, Integer>();
		
		while(!q.isEmpty()){
			
			QueuePack qpack = q.poll();
			Node node = qpack.tnode;
			int level = qpack.level;
			
			rmap.put(level, node.data);
			
			if(node != null && node.left != null)
				q.add(new QueuePack(level-1, node.left));
			
			if(node != null && node.right != null)
			    q.add(new QueuePack(level+1, node.right));
			
			
		}
	
		System.out.println("map: "+ rmap);
	}
	
	
	
	

	public static void main(String[] args) {
		//BFS search
		/* Create following Binary Tree
        1
      /  \
     2    3
      \
       4
        \
         5
          \
           6*/
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.right = new Node(4);
		root2.left.right.right = new Node(5);
		root2.left.right.right.right = new Node(6);

		BottomViewBT p = new BottomViewBT();
		p.bottomView(root2);
		
		
		
		
		/* Create following Binary Tree
        1
      /  \
     2    3
    / \   /\
   4   5 6  7
          \  \
           8  9
        */     
         
         
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);

		BottomViewBT bt = new BottomViewBT();
		bt.bottomView(root);

	}
}



