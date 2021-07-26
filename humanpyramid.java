/**
 * Tori McDonald
 * CECS 274-05
 * Program 4 - Recursion
 * 11/5/19
 */

package humanpyramid;

import java.util.ArrayList;
import java.util.Scanner;

public class humanpyramid {

	public static void main(String[] args) {
		boolean run = true;
		
		do {
			Scanner in = new Scanner(System.in);
			int tall;
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			System.out.println("Welcome to the Human Pyramid!");
			
			System.out.print("How tall is the pyramid?: ");
			tall = in.nextInt(); 
	
			for (int row = 1; row < tall + 1; row++) {	
				
				for(int i =1; i+ row <= tall +1; i++)
				{
					System.out.print("   ");
				}
				
				for (int j = 1; j < row + 1; j++) {
					
					int test = (int)(weightOnBack(j, row, tall));
					
					list.add(test);
					
					System.out.printf("( %d)", test);	
				}
				
				System.out.println();
			}
			
			System.out.println("Would you like to go again? y/n: ");
			String choice = in.next();
			
			if (choice.charAt(0) == 'n') {
				run = !run;
			}
		}
		while (run);
	}
	
	
	public static double weightOnBack(int col, int row, int height) {
		guy temp = new guy(row, col);
		
		double value = temp.carryweight(height);
		
		return value;
	}
}

 
