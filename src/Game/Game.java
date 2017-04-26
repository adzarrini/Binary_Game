package Game;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class Game {
	
	private int currentScore = 0;
	private int question = 0;
	private String fileName = "data/Highscore.txt";
	private Set<Integer> used;
	private ArrayList<Integer> range;
	private ArrayList<Box> answers;

	public Game() {
		used = new HashSet<Integer>();
		range = new ArrayList<Integer>();
		answers = new ArrayList<Box>();
		answers.add(new Box(100,100)); 
		answers.add(new Box(200,100)); 
		answers.add(new Box(100,200)); 
		answers.add(new Box(200,200)); 
	}
	
	public ArrayList<Box> getBoxes() {
		return answers;
	}

	public void GenerateQuestion() {
		Random rand = new Random();
		do{
		question = rand.nextInt(50);
		} while (!used.contains(question));
		used.add(question);
		
		generateAnswers();
	}

	public int getQuestion() {
		return question;
	}

	public void generateAnswers() {
		Random rand1 = new Random();
		range.clear();
		for(int i = question-10; i < question+10; i++){
			if(i > 0 && i < 51){
				range.add(i);
			}
		}
		range.remove(question);
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
