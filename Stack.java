package stackQueue;

public class Stack {

	private Node top;
	
	public Stack() {
		top = null;
	}
	
	public void push(int i) {
		Node temp = new Node(i);
		
		temp.setNext(top);
		
		top = temp;
	}
	
	public int pop() {
		int temp = top.getKey();
		top = top.getNext();
		
		return temp;
	}
	
	public boolean isEmpty() {
		return (top == null);
	}
}
