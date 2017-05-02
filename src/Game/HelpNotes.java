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
		setTitle("Help!");
		
		try {
			add(new JLabel(new ImageIcon(ImageIO.read(new File(imageFile)))));
		} catch (IOException e) {
			System.err.println("Error in Help Image Read In");
			e.printStackTrace();
		}


		
		pack();
		setVisible(true);
	}
	
}
