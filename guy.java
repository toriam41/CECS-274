package humanpyramid;

public class guy {
	private int row;
	private int position;
	private double holding;
	private double weight = 150.0;
	
	public guy(int r, int p) {
		position = p;
		row = r;
	}
	
	public double carryweight(int height) {
		guy above;
		guy above2;
				
		if (row == 1) {
			holding = 0;
		}
		else if (position == 1 || position == row ) {
			above = new guy(row - 1, 1);
			holding = (above.carryweight(height) + weight) * .5;
		}	
		else {
			above = new guy(row - 1, position - 1);
			above2 = new guy(row - 1, position);
			holding = (.5 * above.carryweight(height)) + (.5 * above2.carryweight(height)) + weight;
		}	
		
		return holding;
	}
}
