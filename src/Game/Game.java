package Game;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Game {
	
	private int currentScore = 0;
	private String fileName = "data/Highscore.txt";

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

	public void setHighScore(int i, String name) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			String content = name + " " + i;
			
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void checkHighScore() throws FileNotFoundException {
		if (currentScore > getHighScore()){
			setHighScore(currentScore, getName());
		}
	}
	
	public int getHighScore() throws FileNotFoundException {
		FileReader reader = new FileReader(fileName);
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
