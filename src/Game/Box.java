package Game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Box {
	
	private boolean isAnswer;  //set to true if it's the correct answer
	private int x;
	private int y;
	private boolean isQuestion;
	private boolean clicked;
	private final static int NUM_BITS = 6;
	private final static int WIDTH = 200;
	private final static int HEIGHT = 100;
	
	
	private int value;

	public Box(int x, int y, boolean b, boolean c){
		this.x = x;
		this.y = y;
		isQuestion = b;
		clicked = c;
	}
	
	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public void drawBox(Graphics g){
		if(!isQuestion){
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(7));
			g.setColor(Color.BLACK);
			g.drawRect(x, y, WIDTH, HEIGHT);
			
			g.setColor(Color.BLUE);
			g.fillRect(x, y, WIDTH, HEIGHT);
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Bauhaus 93", 0, 30));
			if(Game.getInstance().getDecimal()){
			g.drawString(Integer.toBinaryString((1 << NUM_BITS) | value).substring(1), x + WIDTH/2 - 50, y + HEIGHT/2 + 7);
			}
			else{
				g.drawString(Integer.toString(value), x + WIDTH/2 - 15, y + HEIGHT/2 + 7);
			}
			
		}
		else{
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(7));
			g.setColor(Color.BLACK);
			g.drawRect(x, y, WIDTH, HEIGHT);
			g.setColor(Color.ORANGE);
			g.fillRect(x, y, WIDTH, HEIGHT);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Bauhaus 93", 0, 30));
			if(Game.getInstance().getDecimal()){
				g.drawString(Integer.toString(value), x + WIDTH/2 - 15, y + HEIGHT/2 + 7);
			}
			else{
				g.drawString(Integer.toBinaryString((1 << NUM_BITS) | value).substring(1), x + WIDTH/2 - 50, y + HEIGHT/2 + 7);
			}
		}
		
	}
	
	public void drawRedBox(Graphics g){
	
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(7));
			g.setColor(Color.BLACK);
			g.drawRect(x, y, WIDTH, HEIGHT);
			g.setColor(Color.RED);
			g.fillRect(x, y, WIDTH, HEIGHT);
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Bauhaus 93", 0, 30));
			g.drawString(Integer.toBinaryString((1 << NUM_BITS) | value).substring(1), x + WIDTH/2 - 50, y + HEIGHT/2 + 7);
			//g.drawString(Integer.toString(value), x + WIDTH/2 - 15, y + HEIGHT/2 + 7);
			
		
	
		
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
