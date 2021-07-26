package linkedlist;

import java.util.Random;


public class Node {

	private int pos;
	private Node next;
	private String word;
	
	public Node (int p) {
		pos = p;
		next = null;
		word = "";
		
		String letters = "aeioubcdfghjklmnpqrstvwxyz";
		Random myRand = new Random();
		int temp;
		
		
		for (int i = 0; i < 4; i++) {
			if (i == 1) {
				temp = myRand.nextInt(5);
				word += letters.charAt(temp);
			}
			else {
				temp = myRand.nextInt(26);
				word += letters.charAt(temp);
			}
		}		
	}
	
	public void display() {
		System.out.print(word + ' ');
	}
	
	public int getValue() {
		return pos;
	}
	
	public void setValue(int i) {
		pos = i;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node n) {
		next = n;
	}
	
	public String getWord() {
		return word;
	}
}
