package GeneralProblems;


/**
 * 
 * @author Naresh
 *
 */
public class RSL 
{
	
	public static Node reverseSinglyLinkedList(Node head) {
		 if(head==null || head.next == null)
		        return head;
		 
		    // second node    
		    Node second = head.next;
		    //setting first's next to be null
		    head.next = null;
		 
		    Node rest = reverseSinglyLinkedList(second);
		    second.next = head;
		 
		    return rest;
	}

	
	public static void main(String args[]){
		 Node Node = new Node(1);
	     Node.next = new Node(2);
	     Node.next.next = new Node(3);
	     Node.next.next.next = new Node(4);
	       
	 
	        System.out.println("...before Reverse "+ Node);
		Node NodeR = reverseSinglyLinkedList(Node);
		
		System.out.println("..."+NodeR);
	}
	
	
}
   
	
 
   
 class Node {
    public Node next;
    public int value;
 
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
 
    @Override
    public String toString() {
 
        String data = "";
        Node current = this;
        do {
            data += current.value + ",";
            current = current.next;
        } while (current != null);
 
        return data;
    }
}




