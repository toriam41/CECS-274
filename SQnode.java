package stackQueue;

public class Node {

	private int key;
	private Node next;
	
	public Node(int x) {
		key = x;
		next = null;
	}
	
	public int getKey() {
		return key;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node n) {
		next = n;
	}
}
