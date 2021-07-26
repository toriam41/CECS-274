package solitaireprime;

import java.util.Random;

public class Deck {

	private Card [] storage;
	private int top;
	private int length;
	
	public Deck() {
		char [] suits = {'S', 'H', 'C', 'D'};
		char [] ranks = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};		
		storage = new Card[52];
		top = 0;
		length = 51;
		int count = 0;
		Card C1;
		
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < ranks.length; j++) {
				C1 = new Card (ranks[j], suits[i] );
				
				storage[count] = C1;
				count++;
			}
		}
	}
	
	public void display() {
		for (int i = 0; i < storage.length; i++) {
			if (i % 13 == 0) {
				System.out.println();
			}

			storage[i].display();
		}
	}
	
	public void shuffle() {
		Random rand = new Random();
		
		for (int i = 0; i < 100; i++) {
			int x = rand.nextInt(52);
			int y = rand.nextInt(52);
			Card temp = storage[x];
			storage[x] = storage[y];
			storage[y] = temp;
		}
	}
	
	public Card deal() {
		Card dealt = storage[top];
		length--;	
		if (length >= 0) {
			top++;
		}
		
		return dealt;
	}
	
	public int cardsLeft() {
		return length + 1;
	}

}
