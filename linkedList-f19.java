package linkedlist;

public class linkedList {

	private Node head;
	
	public linkedList() {
		head = null;
		
	}
	
	public void display() {
		Node temp = head;
		int count = 0;
		
		while (temp != null) {
			temp.display();
			count++;
			temp = temp.getNext();
			
			if (count % 12 == 0) {
				System.out.println();
			}
		}
	}
	
	public void add(int p) {
		Node temp = new Node(p);
		Node curr;
		Node prev;
		
		if (head == null) {
			head = temp;	
		}
		else if (temp.getWord().compareTo(head.getWord()) < 0) {
			temp.setNext(head);
			head = temp;
		}
		else {
			curr = head.getNext();
			prev = head;
			
			while (curr != null) {
				if (temp.getWord().compareTo(curr.getWord()) > 0) {
					prev = curr;
					curr = curr.getNext();
				}
				else {
					prev.setNext(temp);
					temp.setNext(curr);
					break;
				}
			}
			
			if (curr == null) {
				prev.setNext(temp);
			}		
		}
	}
	
	public Node addNode(int n) {
		Node temp = new Node(n);
		Node curr;
		Node prev;
		
		if (head == null) {
			head = temp;	
		}
		else if (temp.getWord().compareTo(head.getWord()) < 0) {
			temp.setNext(head);
			head = temp;
		}
		else {
			curr = head.getNext();
			prev = head;
			
			while (curr != null) {
				if (temp.getWord().compareTo(curr.getWord()) > 0) {
					prev = curr;
					curr = curr.getNext();
				}
				else {
					prev.setNext(temp);
					temp.setNext(curr);
					break;
				}
			}
			
			if (curr == null) {
				prev.setNext(temp);
			}		
		}
		return temp;
	}
	
	public int find(String w) {
		Node temp = head;
		int notfound = 0;
		String compare;
		
		while (temp != null) {
			compare = temp.getWord();
			
			if (w.compareTo(compare) == 0) {
				return temp.getValue();
			}
			else {
				temp = temp.getNext();
			}
		}
		
		return notfound;
	}
	
	public int size() {
		int s = 0;
		Node temp = head;
		
		while (temp != null) {
			s++;
			temp = temp.getNext();
		}
		
		return s;
	}
	
	public int remove(int r) {
		Node prev = head;
		Node temp = prev.getNext();
		Node curr = temp.getNext();
		
		if (prev.getValue() == r) {
			head = temp;
			
			System.out.print(prev.getWord());
				
			return prev.getValue();		
		}
		else {	
			while (temp.getValue() != r) {
				prev = prev.getNext();
				temp = temp.getNext();
				curr = curr.getNext();		
			}	
			
			prev.setNext(curr);
			System.out.print(temp.getWord());
			
			return temp.getValue();
		}
	}
	
	public void order() {
		Node t = head;
		int c = 1;
		
		while (t != null) {	
			t.setValue(c++);
			t = t.getNext();
		}		
	}
}
