package Game;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class HelpNotes extends JDialog {
	
	private String imageFile = "data/BinaryHelp.png"; //TODO
	
	
	public HelpNotes() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("About Us");
		
		try {
			add(new JLabel(new ImageIcon(ImageIO.read(new File(imageFile)))));
		} catch (IOException e) {
			System.err.println("Error in Help Image Read In");
			e.printStackTrace();
		}

	
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); //opens the JFrame in the center of the screen
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		pack();
		setVisible(true);
	}
	
}
