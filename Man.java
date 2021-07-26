package superDuper;

public class Man {
	private int row;
	private int position;
	
	public Man (int r, int p) {
		position = p;
		row = r;
	}
	
	public void setRow(int x) {
		row = x;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setPosition(int y) {
		position = y;
	}
	
	public int getPosition() {
		return position;
	}
	
}
