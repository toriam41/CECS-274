package solitairePrime;

import java.util.Random;
import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> data;
	private int top;

	public Deck() {
		String suits = "SHCD";
		String ranks = "A23456789TJQK";
		int count = 0;

		data = new ArrayList<Card>();
		// top = 0;

		Card C1;

		for (int s = 0; s < suits.length(); s++) {
			for (int r = 0; r < ranks.length(); r++) {
				C1 = new Card(ranks.charAt(r), suits.charAt(s));
				data.add(count, C1);
			}
		}
	}

	public void displaydeck() {
		for (int i = 0; i < data.size(); i++) {
			if (i % 13 == 0) {
				System.out.println();
			}
			
			data.get(i).displaycard();
		}
		
		System.out.println();
		System.out.println();
	}

	public void shuffle() {
		ArrayList<Character> place;
		ArrayList<Card> shuffle;

		place = new ArrayList<Character>();
		shuffle = new ArrayList<Card>();
		Random myRand = new Random();
		int counter = 0;
		int temp;

		for (int i = 0; i < 52; i++) {
			place.add(i, '0');
		}

		while (counter < 52) {
			temp = myRand.nextInt(52);

			if (place.get(temp) == '0') {
				shuffle.add(counter, data.get(temp));
				place.set(temp, '1');
				counter++;
			}
		}
		
		data = shuffle;
	}
	

	public Card deal() {
		top = 0;
		Card temp;
		
		temp = data.get(top);
		
		data.remove(top);
		
		return temp;
	}
}












