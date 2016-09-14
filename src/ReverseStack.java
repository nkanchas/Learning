import java.util.Stack;


public class ReverseStack {
	
	public Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) {
		ReverseStack rs = new ReverseStack();
        rs.push();
        rs.init();
        rs.print();
	}
	
	public void print(){
		while(stack.peek() != null){
			System.out.println("Stack "+ stack.pop());
		}
	}
	
	public void init(){
		reverseStack(stack);
	}
	
	public void reverseStack(Stack<Integer> stack){
		if(stack.isEmpty()) return;
		Integer elem = stack.pop();
		reverseStack(stack);
		System.out.println("....."+elem.intValue());
		insertBottom(stack, elem);
	}
	
	public void insertBottom(Stack<Integer> stack, int elem) {
		System.out.println("insertBottom");
		if(stack.isEmpty()){
			System.out.println("is empty "+elem);
			stack.push(elem);
			return;
		}
		
		int n = stack.pop();
		
		insertBottom(stack, elem);
		
		//stack.push(n);
		System.out.println("....elem n"+n);
		stack.push(n);
	}
	
	public void push(){
	   stack.push(23);
	   stack.push(12);
	   stack.push(6);
	   stack.push(2);
	   
	}

}
