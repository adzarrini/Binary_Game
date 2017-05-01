package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GUI_Menu extends JPanel {
	
	private Game game;
		
	GUI_Menu() {
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0,4));
		panel1.add(helpButton());
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,2));
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
		help.addActionListener(new helpButtonListener());
		
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
		puzzle.addActionListener(new puzzleButtonListener());

		
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
		snake.addActionListener(new snakeButtonListener());

		JPanel panel = new JPanel();
		panel.add(snake);
		
		return panel;
	}
	
	//=============================================================
	// ACTION LISTENERS
	//============================================================
	class helpButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("help");
		}
		
	}
	
	class puzzleButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("puzzle");
		}	
	}
	
	class snakeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("snake");
		}	
	}
	
}
