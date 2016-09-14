package GeneralProblems;

public class CloneLinkedList {

	public Node root;

	//http://tech-queries.blogspot.in/2011/04/copy-linked-list-with-next-and-random.html
	public CloneLinkedList() {

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		node1.next = node2;

		node2.next = node3;

		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		node1.random = node3;
		node2.random = node5;
		node3.random = node2;
		node4.random = node1;
		node5.random = node5;
		node6.random = node5;

		root = node1;

	}

	public void copyListBetween(Node head) {
		// copy list between original nodes

		while (head != null) {
			Node copy = new Node(head.data);
			copy.next = head.next;
			head.next = copy;
			head = head.next.next;
		}

	}

	public void copyRandomRef(Node orginal) {
		while (orginal != null) {
			orginal.next.random = orginal.random;
			orginal = orginal.next.next;
		}

	}

	public void restore(Node org) {
		Node temp = org.next;
		while (org != null && temp != null) {
			org.next = org.next.next;
			if (temp.next != null) {
				temp.next = temp.next.next;
				temp = temp.next;
			}
			org = org.next.next;
		}
	}

	private class Node {
		public Node(int data) {
			this.data = data;
		}

		public int data;
		public Node next;
		public Node random;
	}

}
