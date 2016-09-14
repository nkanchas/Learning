
 

public class ArraySwapAdjacent {
	


	public static void main(String[] args) {
		String[] arr = {"A", "B", "C", "D", "E"};
		
		
		LinkedL A = new LinkedL("A");
		LinkedL B = new LinkedL("A");
		LinkedL C = new LinkedL("A");
		LinkedL D = new LinkedL("A");
		LinkedL E = new LinkedL("A");
		
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;
		
		
		new ArraySwapAdjacent().swap(A);
		

	}
	
	public LinkedL swap(LinkedL node){
		if(node == null || node.next == null)  return node;
		
		LinkedL q = swap(node.next.next);
		
		LinkedL r = node.next;
		r.next = node;
		
		node.next = q;
		return r;
		
	}

}
