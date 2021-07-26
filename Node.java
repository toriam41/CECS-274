/* Tori McDonald
 * CECS 274-05
 * Prog 3 - Linked Lists
 * 5/22/19
 */

package linkedList;

import java.util.Random;

public class Node {
	private int value;
	private Node next;
	private String word;

	
	public Node(int n) {
		value = n;
		next = null;
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		String vowels = "aeiou";
		Random myRand = new Random();
		word = "";
		int temp;
		
		for (int i = 0; i < 4; i++) {
			if (i == 1) {
				temp = myRand.nextInt(5);
				word += vowels.charAt(temp);						
			}
			else {
				temp = myRand.nextInt(26);
				word += alpha.charAt(temp);
			}
		}		
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int n) {
		value = n;
	}
	
	public void changeUp() {
		int start = value + 1;
		Node n = next;
		
		while (n != null) {
			n.setValue(start);
			start++;
			
			n = n.getNext();
		}
	}
	

	public void display() {
		System.out.print(word);
	}
	
	public void setNext(Node m) {
		next = m;
	}
	
	public Node getNext() {
		return next;
	
	}
	
	public void setWord(String s) {
		word = s;
	}
	
	public String getWord() {
		return word;
	}
}
