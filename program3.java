/* Tori McDonald
 * CECS 274-05
 * Prog 3 - Linked Lists
 * 5/22/19
 */

package linkedList;
import java.util.Scanner;
import java.util.Random;

public class program3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LinkedList myList = new LinkedList();
		Random myRand = new Random();
		String choice;	
		Node prev;
		Node post;
		Node current;
		int run = 0;
		int size = 100;
		int temp;
		int t;
		
		do {		
			myList.display();
			//System.out.println();
			System.out.println("///////");
			System.out.println("(R)emove  (A)dd  (F)ind  Size: " + size + "  (Q)uit");
			
			choice = in.next();
			
			System.out.println();
			
			if (choice.equals("r")) {
				temp = myRand.nextInt(100);
				Node n = myList.getHead();
				String word;
			
				for (int i = 0; i < temp; i++) {
					t = n.getValue();
					
					if (t == temp - 1) {
						prev = n;
						current = n.getNext();
						post = current.getNext();
						word = current.getWord();
						
						System.out.println(word + " was removed from location " + temp);
						System.out.println();
						prev.setNext(post);
						prev.changeUp();
						size--;
						
					}
					else {
						n = n.getNext();
					}
				}
				//System.out.println();
			}
			else if (choice.equals("a")) {
				temp = myRand.nextInt(100);
				Node insert = myList.add();
				String word = insert.getWord();
				
				System.out.println(word + " was added at location " + temp);
						
				System.out.println();
				size++;
			System.out.println();	
			}
			else if (choice.equals("f")) {
				System.out.print("Please enter a word to look for: ");
				String look = in.next();
				
				// if found, display word and position
				current = myList.getHead();
				t = 1;
				
				while (current != null) {
					if (look.equals(current.getWord())) {
						System.out.println(look + " was found at location " + current.getValue());
						
						break;
					}
					else {
						current = current.getNext();
					}
				}
				if (current == null) {
					System.out.println(look + " was not found");
				}
				System.out.println();
			}
			else {
				
				run = 1;
			}
		}
		while (run == 0);
	}			
}

	
	
	





