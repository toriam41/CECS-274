package superDuper;

public class Pyramid {
	private static int height;
	private static double weight;
	private int position;
	private int row;
	private Man duper;
	private double holding;
	
	
	public Pyramid(int h, double w) {
		height = h;
		weight = w;

		for (row = height; row > 0; row--) {
			position = 1;
			
			for (int j = 0; j < row; j++) {
				duper = new Man(0, 0);
				duper.setRow(row);
				duper.setPosition(position++);
			}		
		}
	}
	
	
	public double carryweight(Man m) {
		Man duper = m;
		Man above;
		Man above2;
		
		row = duper.getRow();
		position = duper.getPosition();
		
		if (row == height) {
			holding = 0.0;
		}
		else if (row == 1 && position == 1) {
			above = new Man(2, 1);
			holding = 2 * (carryweight(above) + weight);
		}
		else if (position == 1 || position == row ) {
			above = new Man(row + 1, 1);
			above2 = new Man(row + 1, 2);
			
			holding = carryweight(above) + weight + .5 * (carryweight(above2) + weight);
		}
		
		else {
			above = new Man(row + 1, position);
			holding = carryweight(above) + weight;
		}	
		
		return holding;
	}
	
	
	
}
