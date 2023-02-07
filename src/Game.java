import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;


public class Game extends JFrame {
	
	public Game() {
		setTitle("My Game");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		// using container
		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		
		content.add(new GameComponent(), BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
