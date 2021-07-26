/**
 * Tori McDonald
 * CECS 274-05
 * Program 2 -  Solitaire Prime
 * 9/26/19
 */

package solitaireprime;

import java.util.Scanner;

public class solitairePrime {
	
	public static void main(String[] args) {
		boolean run = true;
		Deck myDeck = new Deck();
		
		do {
			System.out.println("Welcome to Solitaire Prime!");
			System.out.println("1) New Deck\n2) Display Deck\n3) Shuffle Deck\n4) Play Solitaire Prime\n5) Exit");
			
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			
			if (choice == 1) {
				myDeck = new Deck();
			}
			else if (choice == 2) {
				myDeck.display();
				System.out.println("\n");
			}
			else if (choice == 3) {
				myDeck.shuffle();
			}
			else if (choice == 4) {
				playGame(myDeck);
			}
			else {
				System.out.println("Okay, bye!");
				run = false;
			}
			
			
		}
		while (run);
	}
	
	static void playGame(Deck gameDeck) {
		Deck deck = gameDeck;
		Card playingCard;
		int sum;
		int piles = 1;	
		//System.out.println(sum);
		boolean prime;
		
		playingCard = deck.deal();
		playingCard.display();
		
		sum = playingCard.getValue();
		prime = isPrime(sum);
		
		while (deck.cardsLeft() > 0) {
			if (prime == false) {
				playingCard = deck.deal();
				playingCard.display();
				
				sum += playingCard.getValue();
				prime = isPrime(sum);
			}
			else {
			System.out.println("Prime: " + sum);
			
			sum = 0;
			piles++;
			
			playingCard = deck.deal();
			playingCard.display();
			
			sum = playingCard.getValue();
			prime = isPrime(sum);
			}
		}
		
		if (isPrime(sum)) {
			System.out.println("Prime: " + sum + "  Winner!");
			System.out.println("You won in " + piles + " piles!\n");
		}
		else {
			System.out.println("Loser!\n");
		}
		
	}	
	
	static boolean isPrime(int num) {
		int n = num;
		int sqrt = (int) Math.sqrt(n);
		
		if (n == 1) {
			return false;
		}
		else if (sqrt == 1) {
			return true;
		}
		else {
			for (int i = 2; i <= sqrt; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			
			return true;
		}
	}

}
