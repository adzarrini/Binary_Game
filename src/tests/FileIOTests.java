package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import Game.*;

public class FileIOTests {
	
	private static Game game;
	
	@BeforeClass
	public static void setUp(){
		 game = new Game();
	}
	
	@Test
	public void testAnswerGeneration() {
		game.generateQuestion();   //generates the boxes
		ArrayList<Box>  boxes = game.getBoxes();
		
		int numberCorrectAns = 0;
		
		for (Box b : boxes) {  
			
			if (b.getValue() == game.getQuestion()) {
				numberCorrectAns++;
			}
		}
		
		assertEquals(1, numberCorrectAns); //assert only one correct answer is generated 
	}
	
	@Test
	public void testQuestionGeneration() {
		
		Set<Integer> questions = new HashSet<Integer>();
				
		for (int i = 0; i < 49; i++) {
			game.generateQuestion();
			
			questions.add(game.getQuestion());
		}
		assertEquals(49, questions.size());
	}
	
	@Test
	public void testNewHighScore() throws FileNotFoundException {
		//TODO - this shouldn't throw an exception 
		game.setHighScore(100, "Bill");
		game.setCurrentScore(150);
		
		game.checkHighScore();
		assertEquals(150, game.getHighScore());
	}

	
		
	
	
}
