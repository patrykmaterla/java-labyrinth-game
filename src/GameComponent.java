import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class GameComponent extends JComponent {
	
	//	private List<Rectangle> box = new ArrayList<>(); 
	private Player player;
	BufferedImage bufferedImage;
	private List<Box> boxes = new ArrayList<>();
	private Level level;
	
	public GameComponent() {
		player = new Player(400, 300, 5, this);
		addKeyListener(player);
		setFocusable(true);
		
		// putting buffered image here doesnt call paintComponent
		
		
//			
//			
//			BufferedImage resizedImage = new BufferedImage(50, 50, bufferedImage.getType());
//			
//			Graphics2D g2d = resizedImage.createGraphics();
//			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//				  g2d.dispose();
//			
//			boxes.add(new Box(0, 0, 50, 50, croppedImage));
//			boxes.add(new Box(50, 0, 50, 50, croppedImage));
			
			
//		box.add(new Rectangle(50, 50, 50, 50));

		System.out.println("end");
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
		  		  graphics.setColor(Color.red);

		  System.out.println("tak");
//        graphics.fillRect(player.getX(), player.getY(), 50, 50);
			player.draw(graphics);
		
		  // paint boxes
		
		  
		// TODO: move bellow code in diffrent place
		try {
			bufferedImage = javax.imageio.ImageIO.read(GameComponent.class.getResource("resources/textures.png"));
		}
		catch (Exception exception) {
			System.err.println("Błąd");
		}
//		BufferedImage croppedImage = bufferedImage.getSubimage(0, 7*16, 16, 16);
		try {
			level = new Level();
		} catch (IOException ex) {
			Logger.getLogger(GameComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		level.draw(graphics);


//		boxes.add(new Box(0, 0, 50, 50, croppedImage));
//		boxes.add(new Box(50, 0, 50, 50, croppedImage));

		
//		  for (Rectangle b : box) {
////			  graphics.fillRect(b.x, b.y, b.width, b.height);
//			  graphics.drawImage(croppedImage, b.x, b.y, b.width, b.height, null);
//		  }
		  
//		for (Box box : boxes) {
//			graphics.drawImage(box.getBufferedImage(), box.getRectangle().x, box.getRectangle().y, box.getRectangle().width, box.getRectangle().height, null);
//		}

		  
	}
	
//	protected boolean isValidMove(int newX, int newY) {
//		Rectangle playerBounds = new Rectangle(newX, newY, 50, 50);
////		for (Rectangle b : boxes.)
////		for (Rectangle b : box) {
////			if (playerBounds.intersects(b)) {
////				return false;
////			}
////		}
////		return true;
//
//		for (Box box : boxes) {
//			if (playerBounds.intersects(box.getRectangle())) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	
}
