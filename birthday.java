/**
 * Tori McDonald
 * CECS 274-05
 * Program 0 - Happy Birthday
 * 8/29/19
 */

package beginnerPrograms;
import java.util.Scanner;



public class birthday {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String name;
		String reply;
		int age;
		int birthYear;
		char thisYear;
		
		System.out.print("What's your name?: ");
		name = in.next();
		
		System.out.print("How old are you, " + name + "?: ");
		age = in.nextInt();
		
		System.out.print(name + ", have you had your birthday this year yet?: ");
		reply = in.next();
		thisYear = reply.charAt(0);
		
		if (thisYear == 'y' || thisYear == 'Y') {
			birthYear = 2019 - age;
		}
		else {
			birthYear = 2019 - age - 1;
		}
		
		System.out.println("You were probably born in " + birthYear +".");

	}

}
