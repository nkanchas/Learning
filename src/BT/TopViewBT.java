package BT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewBT {

	public static TreeMap<Integer, Integer> ht = new TreeMap<>();;

	public void topView(Node root, int level) {
		if (root == null)
			return;
		// create a queue for level order traversal
		Queue<QueuePack> queue = new LinkedList<>();
		// add root with level 0 (create a queue item pack)
		queue.add(new QueuePack(level, root));
		while (!queue.isEmpty()) {
			QueuePack q = queue.remove();
			// take out the items from the package
			Node tnode = q.tnode;
			int lvl = q.level;

			// check if this is the first node you are visiting at the level
			if (ht.containsKey(lvl)) {

			} else {// print it, its the first element at his level
				System.out.print(tnode.data + "   ");
				ht.put(lvl, tnode.data);
			}

			// add the left and right children of visiting nodes to the queue
			if (tnode.left != null) {
				queue.add(new QueuePack(lvl - 1, tnode.left));
			}
			if (tnode.right != null) {
				queue.add(new QueuePack(lvl + 1, tnode.right));
			}
		}

	}

	public static void main(String args[]) {
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

		TopViewBT p = new TopViewBT();
		p.topView(root2, 0);
	}
}

class QueuePack {
	int level;
	Node tnode;

	public QueuePack(int level, Node tnode) {
		this.level = level;
		this.tnode = tnode;
	}
}
