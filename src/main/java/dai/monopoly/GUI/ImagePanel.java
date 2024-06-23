package dai.monopoly.Gui;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImagePanel extends JPanel{

	
	 private BufferedImage backgroundImage;

	    public ImagePanel(String imagePath) {
	        try {
	            // Load the image from file
	            backgroundImage = ImageIO.read(new File(imagePath));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        // Draw the background image at the top-left corner of the panel
	        if (backgroundImage != null) {
	            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	        }
	    }
	
}
