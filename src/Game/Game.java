package Game;

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


public class Game {

	private int question = 0;
	private int currentScore;
	private String highScoreFile;
	private ArrayList<Integer> possibleQuestions;
	private ArrayList<Integer> range;
	private ArrayList<Box> answers;

	public Game() {
		range = new ArrayList<Integer>();
		possibleQuestions = new ArrayList<Integer>();
		for(int i = 1; i < 51; i++){
			possibleQuestions.add(i);
		}
		Collections.shuffle(possibleQuestions);
		answers = new ArrayList<Box>();
		answers.add(new Box(100,100)); 
		answers.add(new Box(200,100)); 
		answers.add(new Box(100,200)); 
		answers.add(new Box(200,200));
		highScoreFile = "data/HighScore.txt";
		currentScore = 0;
	}

	public ArrayList<Box> getBoxes() {
		return answers;
	}

	public void GenerateQuestion() {
		question = possibleQuestions.get(0);
		possibleQuestions.remove(0);

		generateAnswers();
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
		int correct = rand1.nextInt(4);

		for(int i = 0; i < 4; i++){

			if(i == correct){
				answers.get(i).setAnswer(true);
				answers.get(i).setBinary_value(question);
			}
			else {
				answers.get(i).setAnswer(false);
				int index = rand1.nextInt(range.size());
				answers.get(i).setBinary_value(range.get(index));
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
		String name = "Sam";
		//prompt user to input their name, to be written to the highscores file
		return name;
	}

}
