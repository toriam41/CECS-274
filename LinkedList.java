/* Tori McDonald
 * CECS 274-05
 * Prog 3 - Linked Lists
 * 5/22/19
 */

package linkedList;

public class LinkedList {
	private Node head;
	
	
	public LinkedList() {
		head = null;		
		
		for (int i = 100; i > 0; i--) {
			addNode();
		}
		
		Order();
	}
		
	public void addNode() {
		Node n = new Node(0);
		Node ptr1;
		Node ptr2 = null;
		
		if (head == null) {
			head = n;
		}
		else {
			
			ptr1 = head;
			
			while (ptr1 != null) {
				int comp = n.getWord().compareTo(ptr1.getWord());
				
				if (comp > 0) {
					
					ptr2 = ptr1; //saving prior node location 
					ptr1 = ptr1.getNext();
					
					if (ptr1 == null) {
						ptr2.setNext(n);
					}	
				}
				else {
					if (ptr1 == head) {
						n.setNext(ptr1); // moves new node to front of list
						
						head = n; // changes head node to new front of list
						
						break;
					}
					else {
						n.setNext(ptr1); // puts node in front of pointer
						
						if (ptr2 != null) {
							ptr2.setNext(n);
							n.setValue(ptr2.getValue() + 1);
			
							break;
						}			
		
					}
				}
			}
		}
	}
	
	public Node add() {
		Node n = new Node(0);
		Node ptr1;
		Node ptr2 = null;
		
		ptr1 = head;
		
		while (ptr1 != null) {
			int comp = n.getWord().compareTo(ptr1.getWord());
				
			if (comp > 0) {
				ptr2 = ptr1; //saving prior node location 
				ptr1 = ptr1.getNext();
				
				if (ptr1 == null) {
					ptr2.setNext(n);
					int x = ptr2.getValue();
					n.setValue(x + 1);
				}
			}
			else {
				if (ptr1 == head) {
					int y = ptr1.getValue();
					
					n.setNext(ptr1); // moves new node to front of list
					n.setValue(y);
					n.changeUp();
					
					head = n; // changes head node to new front of list
				}
				else {
					int z = ptr1.getValue();
					
					n.setNext(ptr1); // puts node in front of pointer
					
					if (ptr2 != null) {
						ptr2.setNext(n);
						n.setValue(z);
						n.changeUp();
		
						break;
					}
				}
			}
		}
		return n;
	}
	
	public void Order() {
		Node ptr = head;
		
		ptr.setValue(0);
		ptr.changeUp();	
	}
	
	public Node getHead() {
		return head;
	}
		
	public void display() {
		
		Node temp = head;
		int i = 1;
		
		while (temp != null) {
			temp.display();
			System.out.print("  ");
			
			temp = temp.getNext();
			
			if (i % 10 == 0) {
				System.out.println();
			}
			
			i++;
		}
	
	}
		
}
		