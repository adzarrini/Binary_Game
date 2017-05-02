package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Game extends JPanel{

	private int question = 0;
	private int currentScore = 0;
	private String highScoreFile;
	private String currentPlayer;
	private ArrayList<Integer> possibleQuestions;
	private ArrayList<Integer> range;
	private ArrayList<Box> boxes;
	private static Game theInstance = new Game();
	private int livesLeft = 3;
	private int pointsLost;
	private int redBox = -1;

	private boolean decimal = true;
	private Random rand;

	


	public Game() {
		range = new ArrayList<Integer>();
		possibleQuestions = new ArrayList<Integer>();
		for(int i = 1; i < 51; i++){
			possibleQuestions.add(i);
		}
		Collections.shuffle(possibleQuestions);
		boxes = new ArrayList<Box>();

		boxes.add(new Box(300,50,true, false));
		boxes.add(new Box(100,200, false, false)); 
		boxes.add(new Box(500,200, false, false)); 
		boxes.add(new Box(100,400, false, false)); 
		boxes.add(new Box(500,400, false, false));

		rand = new Random();

		highScoreFile = "data/HighScore.txt";
		currentScore = 0;

		addMouseListener(new BoxListener());
	}

	public static Game getInstance() {
		return theInstance;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

//		for(Box a: boxes){
//			a.drawBox(g);
//		}
		for (int i = 0; i < boxes.size(); i++) {
			if (i != redBox && !boxes.get(i).isClicked()) {
				boxes.get(i).drawBox(g);
			}
			else {
				boxes.get(i).drawRedBox(g);
			}
		}

		g.setColor(Color.BLACK);
		g.drawString("Current Score: " + String.valueOf(currentScore), 5, 30);
		try {
			g.drawString("High Score: " + String.valueOf(getHighScore()), 5, 60);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawString("Lives Left: " + String.valueOf(livesLeft), 5, 90);
		
	}
	



	public ArrayList<Box> getBoxes() {
		return boxes;
	}

	public void generateQuestion() {
		question = possibleQuestions.get(0);
		possibleQuestions.remove(0);
		
		boxes.get(0).setValue(question);

		pointsLost = 0;
		redBox = -1;
		generateAnswers();
		
		int z = rand.nextInt(2);
		if(z == 0) decimal = true;
		else decimal = false;
		
		repaint();
	}

	public int getQuestion() {
		return question;
	}

	public void generateAnswers() {
		Random rand1 = new Random();
		range.clear();
		for(int i = question-10; i < question+11; i++){
			if(i > 0 && i < 51){
				range.add(i);
			}
		}
		range.remove(range.indexOf(question));
		int correct = rand1.nextInt(4) + 1; 

		for(int i = 1; i < 5; i++){

			if(i == correct){
				boxes.get(i).setAnswer(true);
				boxes.get(i).setValue(question);
			}
			else {
				boxes.get(i).setAnswer(false);
				int index = rand1.nextInt(range.size());
				//range.remove(range.indexOf(index));
				boxes.get(i).setValue(range.get(index));
			}
		}
	}

	public void setCurrentScore(int i) {
		currentScore = i;	
	}

	public char[] getCurrentScore() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setHighScore(int currentScore, String name) {
		//TODO should be reworked
		//We should only have to read in the highScore at the beginning of the game, and then
		//write the score at the end of the game. This is confusing with all the setters and getters 

		PrintWriter printWriter;

		try {
			printWriter = new PrintWriter(highScoreFile);
			printWriter.println(name + ", " + currentScore);
			printWriter.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("Error - HighScoreFile");
			e.printStackTrace();
		}

	}

	public void checkHighScore() throws FileNotFoundException {
		if (currentScore > getHighScore()){
			setHighScore(currentScore, getName());
		}
	}

	public int getHighScore() throws FileNotFoundException {
		//where is this exception handled? I don't think it is 
		FileReader reader = new FileReader(highScoreFile);
		Scanner in = new Scanner(reader);
		String line = in.nextLine();
		String[] score = line.split(", ");
		return Integer.parseInt(score[1]);	
	}

	public String getName(){
		return currentPlayer;
	}

	public void setName(String n) {
		currentPlayer = n;
	}
	
	public boolean getDecimal(){
		return decimal;
	}

	public void handleClick(int index){
		if(boxes.get(index).getAnswer()){
			currentScore += 5 - pointsLost;
			generateQuestion();
			for (Box b: boxes) {
				b.setClicked(false);
			}
		}
		else{
			//JOptionPane.showMessageDialog(null, "You are a piece of SHIT", "You Suck", JOptionPane.INFORMATION_MESSAGE);
			pointsLost++;
			livesLeft--;
			boxes.get(index).setClicked(true);
			redBox = index;
			if (livesLeft >= 0) {
			repaint();
			}
			else {
			JOptionPane.showMessageDialog(null, "You are a piece of SHIT. You lose.", "You Suck", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
			}
			
		}
	}

	public class BoxListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {
			for(int i = 1; i < 5; i++){
				if (boxes.get(i).containsClick(e.getX(), e.getY())) {
					handleClick(i);
					repaint();
				}
			}
		}

	}

}
