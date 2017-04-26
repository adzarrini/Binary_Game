package Game;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Game {
	
	private int currentScore;
	private String highScoreFile;
	
	public Game() {
		highScoreFile = "data/HighScore.txt";
		currentScore = 0;
	}

	public ArrayList<Box> getBoxes() {
		// TODO Auto-generated method stub
		return null;
	}

	public void GenerateQuestion() {
		// TODO Auto-generated method stub
		
	}

	public int getAnswer() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void generateAnswers() {
		// TODO Auto-generated method stub
		
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
		String name = "Sam";
		//prompt user to input their name, to be written to the highscores file
		return name;
	}

}
