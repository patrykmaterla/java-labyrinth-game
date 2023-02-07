
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;



public class Player implements java.awt.event.KeyListener {
	
	private int x;
	private int y;
	private int speed;
	private GameComponent gameComponent;
	
	public Player(int x, int y, int speed, GameComponent gameComponent) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.gameComponent = gameComponent;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void moveUp() {
		y = y - speed;
	}
	
	public void moveDown() {
		y = y + speed;
	}
	
	public void moveLeft() {
		x = x - speed;
	}
	
	public void moveRight() {
		x = x + speed;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				moveUp();
				break;
			case KeyEvent.VK_DOWN:
				moveDown();
				break;
			case KeyEvent.VK_LEFT:
				moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				moveRight();
				break;
		}
		gameComponent.repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
