/* Tori McDonald
 * CECS 274 - 05
 * Program 2 - Solitaire Prime
 * 2/28/19
 */

package solitairePrime;
import java.util.Scanner;


public class SolitairePrime {

	static boolean isPrime(int number) {
		int n = number;
		int root = (int) Math.sqrt(n);
		
		if (n == 1) {
			return false;
		}
		else if (root == 1) {
			return true;
		}
		else {
			for (int i = 2; i <= root; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			
			return true;
		}		
	}
	
	
	static int menu() {
		Scanner in = new Scanner(System.in);	
		int user;
		
		System.out.println("Welcome to Solitaire Prime!");
		System.out.println("1. New Deck");
		System.out.println("2. Display Deck");
		System.out.println("3. Shuffle Deck");
		System.out.println("4. Play game");
		System.out.println("5. Exit");
		
		user = in.nextInt();
		
		return user;	
	}
	
	
	public static void main(String[] args) {
		Deck gameDeck = new Deck();
		Card playingCard;
		int choice;
		
		int run = 0;
		
		int sum = 0;
		
		
		do {
			int totalCards = 52;
			choice = menu();
			int piles = 1;
			
			if (choice == 5) {
				System.out.println("Bye!");
				run = 1;
			}
			else {
				if (choice == 1) {
				 gameDeck = new Deck();	
					continue;
				}
				else if (choice == 2) {
					gameDeck.displaydeck();
				}
				else if(choice == 3) {
					gameDeck.shuffle();
				}
				else if (choice == 4){
					do {	
						playingCard = gameDeck.deal();
						totalCards--;
						playingCard.displaycard();
						sum += playingCard.getValue();
						
						if (isPrime(sum)) {
							System.out.println("Prime: " + sum);
							sum = 0;
							piles++;
						}					
					}
					while (totalCards > 0);
					
					if (isPrime(sum)) {
						System.out.println("Winner in " + piles + " piles!");
						System.out.println();
					}
					else {
						System.out.println("Loser!");
						System.out.println();
					}
				}
			}
		}
		while (run == 0);
	}
}
