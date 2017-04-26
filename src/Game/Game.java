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
	
	private int currentScore = 0;
	private String highScoreFile = "data/Highscore.txt";

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
		// TODO Auto-generated method stub
		
	}

	public char[] getCurrentScore() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setHighScore(int currentScore, String name) throws FileNotFoundException {

		PrintWriter printWriter;
	
		printWriter = new PrintWriter(highScoreFile);

		printWriter.println(name + ", " + currentScore);
		printWriter.close();
			
	}

	public void checkHighScore() throws FileNotFoundException {
		if (currentScore > getHighScore()){
			try {
			setHighScore(currentScore, getName());
			}
			catch (FileNotFoundException e) {
				System.err.println("Error - HighScoreFile");
			}
		}
	}
	
	public int getHighScore() throws FileNotFoundException {
		FileReader reader = new FileReader(highScoreFile);
		Scanner in = new Scanner(reader);
		String line = in.nextLine();
		String[] score = line.split(" ");
		return Integer.parseInt(score[1]);
	}
	
	public String getName(){
		String name = "Sam";
		//prompt user to input their name, to be written to the highscores file
		return name;
	}

}
