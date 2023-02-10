import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;


public class Game extends JFrame {
	
//	private GameComponent gameComponent;
	
	private  int WIDTH = 960;
	private  int HEIGHT = 720;
	
	public Game() {
		setTitle("My Game");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		// using container
		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		
		content.add(new GameComponent(), BorderLayout.CENTER);
				setVisible(true);


	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
