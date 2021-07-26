package solitairePrime;

public class Card {
	private char suit;
	private char rank;

	
	public Card (char r, char s) {
			rank = r;
			suit = s;
	}
	
	public void displaycard() {
		System.out.printf("%c%c ", rank, suit);
		}
	
	public int getValue() {
		int value;
		
		if (rank == 'A') {
			value = 1;
		}
		else if (rank == '2') {
			value = 2;
		}
		else if (rank == '3') {
			value = 3;
		}
		else if (rank == '4') {
			value = 4;
		}
		else if (rank == '5') {
			value = 5;
		}
		else if (rank == '6') {
			value = 6;
		}
		else if (rank == '7') {
			value = 7;
		}
		else if (rank == '8') {
			value = 8;
		}
		else if (rank == '9') {
			value = 9;
		}
		else {
			value = 10;
		}
		return value;
	}
	
	public char getRank() {
		return rank;
	}
	
	public char getSuit() {
		return suit;
	}
}



