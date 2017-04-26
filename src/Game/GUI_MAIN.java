package Game;

import java.awt.Dimension;
import java.awt.Image;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI_MAIN extends JFrame {
	
	GUI_MAIN() {
	 JFrame_Init();
	 setIcons();
	
	 //TODO add JPanels here
	 
	}
	
	//Initializes the JFrame
	public void JFrame_Init() {
		setTitle("Binary Game (shit title, somebody more creative change this)");
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); //opens the JFrame in the center of the screen
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
	}
	
	//sets the icon images
	public void setIcons() {
		List<Image> icons = new ArrayList<Image>();
		
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