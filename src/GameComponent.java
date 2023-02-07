import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;

public class GameComponent extends JComponent {
	
	private Player player;
	
	public GameComponent() {
		player = new Player(400, 300, 5, this);
		addKeyListener(player);
		setFocusable(true);
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.fillRect(player.getX(), player.getY(), 50, 50);
		
	}
	
	
}
