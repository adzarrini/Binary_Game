package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GUI_Menu extends JPanel {
	
	List<Image> icons = new ArrayList<Image>();
	
	GUI_Menu() {
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0,4));
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,2));
		
		panel1.add(helpButton());
		
		panel2.add(new JPanel());
		panel2.add(new JPanel());
		panel2.add(puzzleButton());
		panel2.add(snakeButton());
		
		add(panel1);
		add(panel2);
	
	}
	
	public JPanel helpButton() {
		JButton help = new JButton("Help!");
		help.setFont(new Font("Bauhaus 93", 0, 30));
		help.setPreferredSize(new Dimension(150,50));
		help.setBackground(Color.RED);
		help.setFocusable(false);
		
		JPanel panel = new JPanel();
		panel.add(help);
		return panel;
	}
	
	public JPanel puzzleButton() {
		JButton puzzle = new JButton("Puzzle Practice");
		puzzle.setFont(new Font("Bauhaus 93", 0, 30));
		puzzle.setPreferredSize(new Dimension(300,100));
		puzzle.setBackground(Color.CYAN);
		puzzle.setFocusable(false);

		
		JPanel panel = new JPanel();
		panel.add(puzzle);
		
		return panel;
	}
	
	public JPanel snakeButton() {
		JButton snake = new JButton("Snake? TODO");
		
		snake.setFont(new Font("Bauhaus 93", 0, 30));
		snake.setPreferredSize(new Dimension(300,100));
		snake.setBackground(Color.CYAN);
		snake.setFocusable(false);


		
		JPanel panel = new JPanel();
		panel.add(snake);
		
		return panel;
	}
	
	public void setIcons() {
		
//		try {
//			//TODO add icons
//		}
//		catch (IOException e) {
//			System.err.println("Error - Icon Image Failed Read in");
//			e.printStackTrace();
//		}
		
	}
	
	
}
