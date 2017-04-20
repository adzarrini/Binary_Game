package tests;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import Game.*;

public class FileIOTests {
	
	private static Game game;
	
	@BeforeClass
	public static void setUp(){
		//TODO setup the game 
	}
	
	@Test
	public void testAnswerGeneration() {
		
		game.GenerateQuestion();   //generates the boxes
		ArrayList<Boxes>  boxes = game.getBoxes();
		
		int numberCorrectAns = 0;
		
		for (Box b : boxes) {  
			
			if (b.getValue == game.getAnswer()) {
				numberCorrectAns++;
			}
		}
		
		assertEquals(1, numberCorrectAns); //assert only one correct answer is generated 
	}
	
	public void testQuestionGeneration() {
		
		Map<Integer,Integer> answers = new HashMap<Integer, Integer>();
				
		for (int i = 0; i < 1000; i++) {
			game.generateAnswers();
			
			answers.put(game.getAnswer(), answers.get(game.getAnswer()) + 1);
		}
		
		for (int i : answers.values()) {
			assertEquals(1, i);			//check only one answer is generated per game, no repeats
		}	
	}
	
	public void testNewHighScore() {
		for (int i = 0; i < 100; i++) {
			game.getCurrentScore();
			PrintWriter out = newPrintWriter(FILENAME);
			
			
		}
	}
		
	
	
}
