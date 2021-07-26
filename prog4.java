/* Tori McDonald
 * CECS 274-05
 * Program 4 - Super Duper Man
 * 4/9/19
 */

package superDuper;
import java.util.Scanner;


public class prog4 {
	

	public static void main(String[] args) {
		Pyramid wedge;
		Scanner in = new Scanner(System.in);
		int tall;
		int location;
		double heavy;
		double holding;
		Man favorite;
		Man cooper = new Man(1,1);
		
		System.out.println("Welcome to Cooper's Super Duper Wedgie!");
		
		System.out.print("How tall is the wedge?: ");
		tall = in.nextInt(); 
		
		System.out.print("How much does each man weigh?: ");
		heavy = in.nextDouble();
		
		System.out.print("What is the (row, column) of your favorite man?: ");
		String where = in.next();
		
		String temp1 = "";
		String temp2 = "";
		
		for (int i = 0; i < where.length(); i++) {
			if (where.charAt(i) == ',') {
				i++;
				temp2 = temp1;
				temp1 = "";
				temp1 += where.charAt(i);
			}
			else {
				temp1 += where.charAt(i);
			}
		}
		
		
		int row = Integer.parseInt(temp2);
		int column = Integer.parseInt(temp1);
		
		wedge = new Pyramid(tall, heavy);	
		favorite = new Man(row, column);
		
		holding = wedge.carryweight(favorite);
	
		System.out.println("The man at position (" + row + ", " + column + ") is holding " + holding + " pounds.");
		
		holding = wedge.carryweight(cooper);
		
		System.out.println("Super Duper Cooper is holding " + holding + " pounds.");
	}

	
}
