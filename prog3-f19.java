/**
 * Tori McDonald
 * CECS 274-05
 * Program 3 - Linked Lists
 * 10/14/10
 */


package linkedlist;

import java.util.Random;
import java.util.Scanner;

public class prog3 {

	public static void main(String[] args) {
		Random myRand = new Random();
		Scanner in = new Scanner(System.in);
		linkedList myList = new linkedList();
		int run = 0;
		
		for (int i = 1; i < 101; i++) {
			myList.add(i);
		}
		
		myList.order();
		myList.display();
		System.out.println();
		
		do {	
			int size = myList.size();
			
			System.out.println();
			System.out.println("(A)dd   (D)elete   (F)ind   (Q)uit  Size: " + size + "\n");
			
			String choice = in.next();
	
			if (choice.charAt(0) == 'A' || choice.charAt(0) == 'a') {
				Node n = myList.addNode(myRand.nextInt(size));
				
				myList.order();
				myList.display();
				
				System.out.println("\n");	
				System.out.println(n.getWord() + " was added at position " +  n.getValue());
			}
			else if (choice.charAt(0) == 'F' || choice.charAt(0) == 'f') {
				String word = in.next();
				
				int location = myList.find(word);
				
				if (location == 0) {
					System.out.println(word + " is not in the list.");
				}
				else {
					System.out.println(word + " was found at position " + location);
				}		
			}
			else if (choice.charAt(0) == 'D' || choice.charAt(0) == 'd') {	
				int position = myList.remove(myRand.nextInt(size));
				System.out.println(" was removed from position " + position);
				System.out.println();
				
				myList.order();
				myList.display();
				
				System.out.println();
			}
			else {
				run = 1;
				
				System.out.println("OKAY BYE");
			}
		}
		while (run == 0);
	}	
}
	


