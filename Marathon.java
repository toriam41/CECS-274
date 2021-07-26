package marathon;

import java.util.Scanner;

public class Marathon {
	public static void main (String[] args) {
		double mile = 1.61;
		double marathon = 26.2;
		double K = 10.0;
		
		Scanner in = new Scanner(System.in);
		String name;
		double distance;
		double hours;	
		double minutes;
		double seconds;
		
		// ask user for name
		System.out.print("What is your first name?: ");
		name = in.next();
		
		// ask user for floating point
		System.out.print("How far did you run today?: ");
		distance = in.nextDouble();
		
		// ask for number of hours, minutes, secs
		System.out.print("How long did it take? Hours: ");
		hours = in.nextInt();
		
		System.out.print("Minutes: ");
		minutes = in.nextInt();
		
		System.out.print("Seconds: ");
		seconds = in.nextInt();
		System.out.println();
		
		System.out.println("Hi " + name + ",");
		
		// figure out pace; pace = time to run 1 mile
		//double s = seconds / 60;
		double m = minutes * 60;
		double h = 60 * 60 * hours;
		double time = m + seconds + h;
		double pace = (time / 60) / distance;
		int temp = (int) pace;
		int secs = (int) (pace - temp);

	
		if (secs < 10) {
			System.out.println("Your pace was " + temp + ":0" + secs);
		}
		else {
			System.out.println("Your pace was " + temp + ":" + secs);
		}
		
		
		double tmarathon = pace * marathon;
		int totalmin = (int) tmarathon;
		int totalsec = (int) ((tmarathon - (double) totalmin) * 60.0);
		int hourcount = 0;
		int mincount = 0;
		
		while (totalmin > 0) {
			if (totalmin / 60 >= 1) {
				hourcount = totalmin / 60;	
				totalmin = totalmin - (hourcount * 60);
				}
			else {
				mincount = totalmin;
				totalmin = totalmin - mincount;
			}
		}
		System.out.println("At this rate your time would be " + hourcount + ":" + mincount + ":" + totalsec);
		
		// find 10K time
		time = temp * (10 / mile);
		hourcount = 0;
		totalmin = (int) time;
		totalsec = (int)((time - totalmin) * 60);
		
		while (totalmin > 0) {
			if (totalmin / 60 >= 1) {
				hourcount = totalmin / 60;	
				totalmin = totalmin - (hourcount * 60);
				}
			else {
				mincount = totalmin;
				totalmin = totalmin - mincount;
			}
		}
		
		System.out.println("Your 10K time would be " + hourcount + ":" + mincount + ":" + totalsec);
		System.out.println("Look at this table!");
		System.out.println();
		System.out.println("Pace        10K        Marathon");
		
		pace = 281;
		
		
		
		for (int i = 0; i < 8; i++) {
			temp = (int) pace / 60;
			int temp2 = (int) (pace - (temp * 60));
			
			time = (pace / 60) * (10 / mile);
			
			totalmin = (int) time;
			totalsec = (int)((time - totalmin) * 60);
			// format 10K minutes and secs
			
			tmarathon = (pace / 60) * marathon;
			int tmin = (int) tmarathon;
			int tsec = (int) ((tmarathon - tmin) * 60);
			//System.out.println(tsec);
			int hcount = 0;
			int mcount = 0;

			while (tmin > 0) {
				if (tmin / 60 >= 1) {
					hcount = tmin / 60;	
					tmin = tmin - (hcount * 60);
					}
				else {
					mcount = tmin;
					tmin = tmin - mcount;
				}
			}
			
			System.out.format("%d:%d %8d:%d %8d:%d:%d\n", temp, temp2, totalmin, totalsec, hcount, mcount, tsec);
			pace = pace + 30;
		}
			
		}
		
	}

