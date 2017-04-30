package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI_MAIN extends JFrame {
	
	List<Image> icons = new ArrayList<Image>();
	
	Game game = new Game();
	
	GUI_MAIN() {
		
	 JFrame_Init();
	 setIcons();
	 
	//TODO add JPanels here 
	 add(new GUI_Menu(), BorderLayout.CENTER);

	 showPlayerInputDialog();  //TODO uncomment 
	 setVisible(true);
	}
	

	private void showPlayerInputDialog() {
		JTextField field  = new JTextField(10);
		JLabel label = new JLabel("Please enter your name: ");
		
		label.setFont(new Font("Bauhaus 93", 0, 25));
		field.setFont(new Font("Bauhaus 93", 0, 20));
		JPanel p = new JPanel(new BorderLayout(5, 2));
		p.add(label, BorderLayout.WEST);
		p.add(field);
		
		JOptionPane.showMessageDialog(null, p, null, JOptionPane.PLAIN_MESSAGE, null);
		
		//TODO set focus to text box
		
		game.setName(field.getText());
	}



	//Initializes the JFrame
	private void JFrame_Init() {
		setTitle("Binary Game (shit title, somebody more creative change this)");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); //opens the JFrame in the center of the screen
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
	}
	
	//sets the icon images
	public void setIcons() {
	
		try {
			icons.add(ImageIO.read(new File("data/Icons/Icon16.jpg")));
			icons.add(ImageIO.read(new File("data/Icons/Icon32.jpg")));
			icons.add(ImageIO.read(new File("data/Icons/Icon64.jpg")));
			icons.add(ImageIO.read(new File("data/Icons/Icon128.jpg")));
		}
		catch (IOException e) {
			System.err.println("Error - Icon Image Failed Read in");
			e.printStackTrace();
		}
		
		setIconImages(icons);
	}
	
	
	
	public static void main(String [] args) {
		GUI_MAIN game = new GUI_MAIN();
	}
	
}
