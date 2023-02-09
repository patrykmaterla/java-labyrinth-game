import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

public class GameComponent extends JComponent {
	
	private Player player;
	private List<Rectangle> box = new ArrayList<>(); 
	
	public GameComponent() {
		player = new Player(400, 300, 5, this);
		addKeyListener(player);
		setFocusable(true);
		
		box.add(new Rectangle(50, 50, 50, 50));
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.fillRect(player.getX(), player.getY(), 50, 50);
		
		  // paint boxes
		  graphics.setColor(Color.red);
		  
		  for (Rectangle b : box) {
			  graphics.fillRect(b.x, b.y, b.width, b.height);
		  }
		  
	}
	
	protected boolean isValidMove(int newX, int newY) {
		Rectangle playerBounds = new Rectangle(newX, newY, 50, 50);
		for (Rectangle b : box) {
			if (playerBounds.intersects(b)) {
				return false;
			}
		}
		return true;
	}
	
	
}
