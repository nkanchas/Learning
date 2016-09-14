import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeList {

	

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		PriorityQueue<ListNode> listNodeQueue = new PriorityQueue<ListNode>(
				lists.size(), new ListNodeComparator());
		for (ListNode node : lists) {
			if (node != null)
				listNodeQueue.add(node);
		}
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while (!listNodeQueue.isEmpty()) {
			ListNode toAdd = listNodeQueue.poll();
			head.next = toAdd;
			if (toAdd.next != null)
				listNodeQueue.add(toAdd.next);
			head = head.next;
		}
		return dummy.next;

	}

	private class ListNodeComparator implements Comparator<ListNode> {
		public int compare(ListNode a, ListNode b) {
			return a.val - b.val;
		}
	}
	
	public static void main(String args[]){
		ListNode ln1 = new ListNode(1);		
		ListNode ln2 = new ListNode(3);
		ListNode ln3 = new ListNode(5);
		ListNode ln4 = new ListNode(7);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		
		
		ListNode l1 = new ListNode(2);		
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(6);
		ListNode l4 = new ListNode(8);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		
		ListNode p1 = new ListNode(0);		
		ListNode p2 = new ListNode(9);
		ListNode p3 = new ListNode(10);
		ListNode p4 = new ListNode(11);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		
		List<ListNode> list = new ArrayList<ListNode>();
		
		list.add(ln1);
		list.add(l1);
		list.add(p1);
		ListNode dum = new MergeList().mergeKLists(list);
		
		
		System.out.println(".,,,,,,,,.."+ dum);
		
		
	}
}
