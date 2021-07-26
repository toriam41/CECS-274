package stackQueue;

import java.util.Scanner;
import java.util.ArrayList;

public class prog6 {

	public static void main(String[] args) {
		System.out.println("Welcome to CrazyTrain!\nPlease enter a list of numbers (no more than 10): ");
		
		ArrayList<Integer> queue = new ArrayList();
		Scanner in = new Scanner(System.in);
		
		String input = in.next();
		
		for (int i = 0; i < input.length(); i++) {
			int num = Character.getNumericValue(input.charAt(i));	
			queue.add(num);		
		}
		
		for (int j = 0; j < queue.size(); j++) {
			System.out.println(queue.get(j));
		}

	}

}
