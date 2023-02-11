
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Background extends JComponent {

	private BufferedImage backgroundImage;
	
	public Background() {
		this.setSize(760, 760);
		this.setPreferredSize(new Dimension(760, 760));
		this.setBackground(Color.red);

		try {
			backgroundImage = ImageIO.read(getClass().getResource("/resources/background.jpg"));
		} catch (IOException ex) {
			Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
		}

		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(backgroundImage, 0, 0, 760, 760, null);
	}
	
}
