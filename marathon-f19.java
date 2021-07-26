/*
 * Tori McDonald
 * Program 1 - Marathon
 * 9/12/19
 * CECS 274 - 05
 */

package marathon;

import java.util.Scanner;

public class marathon {

	public static void main(String[] args) {
		String name;
		double distance;
		int hours, minutes, seconds;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("What's your name?: ");
		name = in.next();
		
		System.out.print("How far did you run, " + name + "?: ");
		distance = in.nextDouble();
		
		System.out.print("How many hours did it take?: ");
		hours = in.nextInt();
		
		System.out.print("minutes?: ");
		minutes = in.nextInt();
		
		System.out.print("seconds?: ");
		seconds = in.nextInt();
		
		// pace in minutes
		double totaltime = (hours * 60) + minutes + (seconds / 60.0);
		double pace = totaltime / distance;
		int minpace = (int) pace;
		int secpace = (int)((pace - minpace) * 60.0);
		
		System.out.println(name +", your pace was " + minpace + ":" + secpace + ".");
		
		// marathon time in minutes
		double marathon = pace * 26.22;
		int mhour = (int) (marathon / 60);
		int mminute = (int)(marathon - (mhour * 60));
		int msecond = (int)(((marathon - (mhour * 60))- mminute) * 60);
		
		System.out.printf("Your marathon time will be %d:%02d:%02d\n\n", mhour, mminute, msecond);

		double recordmarathon = 121 + (39.0/60.0);
		double recordpace = recordmarathon / 26.22;
		int recordmin = (int)(recordpace);
		int recordsec = (int)((recordpace - recordmin) * 60);
		int rhour = (int)((recordpace * 26.22) / 60);
		int rmin = (int)((recordpace * 26.22) - (60 * rhour));
		int rsec = (int)((((recordpace * 26.22) - (60 * rhour)) - rmin) * 60);
		
		// print the record pace first
		System.out.println("Pace Table");
		System.out.println("Pace\t\tMarathon");
		System.out.printf("%d:%02d\t\t%d:%02d:%02d <--- Eliud Kipchoge\n", recordmin, recordsec, rhour, rmin, rsec);
		
		double record = 121 + (39/60.0);
		double myPace = pace;
		
		record += 17;
		//record += (37 / 60.0);
		
		double newpace = record / 26.22 ;
		
		while (myPace > newpace) {				
			printTable(newpace);
			
			newpace += 0.67189;		
		}
		
		System.out.printf("%d:%02d\t\t%d:%02d:%02d <--- " + name + "\n", minpace, secpace, mhour, mminute, msecond);
	}

	
	public static void printTable(double pace) {
		double m = pace * 26.22;
		int pmin = (int)(pace);
		int psec = (int) ((pace - pmin) * 60.0);
		int mhour = (int)((m) / 60);
		int mmin = (int)(m - (60.0 * mhour));
		int msec = (int)(((m - (60.0 * mhour)) - mmin) * 60.0);
		
			
		System.out.printf("%d:%02d\t\t%d:%02d:%02d\n", pmin, psec, mhour, mmin, msec);
		}
	}

