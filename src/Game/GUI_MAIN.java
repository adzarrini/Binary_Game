package Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI_MAIN extends JFrame {
	
	List<Image> icons = new ArrayList<Image>();
	
	private static Game game;
	
	public GUI_MAIN() {

		JFrame_Init();
		setIcons();

		//TODO add JPanels here 
		game.getInstance().generateQuestion();
		add(game.getInstance(), BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		
		
		showPlayerInputDialog(); 
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
		
		game.getInstance().setName(field.getText());
	}
	
	private JMenu createFileMenu(){
		JMenu menu = new JMenu("File");
		menu.add(createFileExitItem());
		//menu.add(createHelpNotes());
		//menu.add(createAboutUs());
		return menu;
	}
	
	private JMenuItem createHelpNotes() {
		JMenuItem item = new JMenuItem("Help!");
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				HelpNotes help = new HelpNotes(); 	
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}
	
	private JMenuItem createFileExitItem(){
		JMenuItem item = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}
	
	private JMenuItem createAboutUs() {
		JMenuItem item = new JMenuItem("About Us");
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				AboutUs about = new AboutUs();
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}
	

	//Initializes the JFrame
	private void JFrame_Init() {
		setTitle("Binary Game)");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		
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
