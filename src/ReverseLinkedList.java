
public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);		
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(6);
		ListNode l4 = new ListNode(8);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		ReverseLinkedList rl = new ReverseLinkedList();
		System.out.println("given list");
		rl.printNodes(l1);
        System.out.println("\n");
		System.out.println("----Reversing Logic---");
		ListNode rv = rl.reverse(l1);
		
		rl.printNodes(rv);
	}
	
	public ListNode reverse(ListNode list){
		if(list == null) return list;
		
		if(list.next == null) return list;
		
		ListNode node = list.next;
		
		list.next = null;
		
		ListNode reverseList = reverse(node);
		
		node.next = list;
		
		return reverseList;
		
		
	}
	
	public void printNodes(ListNode ln){
		System.out.print(ln.val);
		ln = ln.next;
		while(ln != null && ln.val > 0){
			System.out.print("-->"+ln.val);
			ln = ln.next;
		}
	}

}
