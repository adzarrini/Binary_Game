package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Box {
	
	private boolean isAnswer;  //set to true if it's the correct answer
	private int x;
	private int y;
	private boolean isQuestion;
	private final static int NUM_BITS = 6;
	private final static int WIDTH = 200;
	private final static int HEIGHT = 100;
	
	
	private int value;

	public Box(int x, int y, boolean b){
		this.x = x;
		this.y = y;
		isQuestion = b;
	}
	
	public void drawBox(Graphics g){
		if(!isQuestion){
			g.setColor(Color.BLUE);
			g.fillRect(x, y, WIDTH, HEIGHT);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Bauhaus 93", 0, 30));
			g.drawString(Integer.toBinaryString((1 << NUM_BITS) | value).substring(1), x + WIDTH/2 - 50, y + HEIGHT/2 + 7);
			//g.drawString(Integer.toString(value), x + WIDTH/2 - 15, y + HEIGHT/2 + 7);
			
		}
		else{
			g.setColor(Color.ORANGE);
			g.fillRect(x, y, WIDTH, HEIGHT);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Bauhaus 93", 0, 30));
			g.drawString(Integer.toString(value), x + WIDTH/2 - 15, y + HEIGHT/2 + 7);
		}
		
	}
	

	
	public boolean containsClick(int x, int y){
		if(x >= this.x && x <= this.x + WIDTH && y >= this.y && y <= this.y + HEIGHT) return true;
		return false;
	}
	
	public int getValue() {
		return value;
	}

	public void setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
	}

	public void setValue(int Value) {
		this.value = Value;
	}
	
	public boolean getAnswer(){
		return isAnswer;
	}
	
	

}
