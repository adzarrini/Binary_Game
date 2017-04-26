package Game;

public class Box {
	
	private boolean isAnswer;  //set to true if it's the correct answer
	private int x;
	private int y;
	
	private int binary_value;

	public Box(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
	}

	public void setBinary_value(int binary_value) {
		this.binary_value = binary_value;
	}

}
