
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JPanel;



public class Player implements java.awt.event.KeyListener {
	
	private int x;
	private int y;
	private int speed;
	private final GameComponent gameComponent;
	private Rectangle playerRectangle;
	private Level level;
	private int WIDTH;
	private int HEIGHT;
	
	public Player(int x, int y, int speed, GameComponent gameComponent) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.gameComponent = gameComponent;
		playerRectangle = new Rectangle(x, y, 50, 50);
		level = new Level();
		this.WIDTH = 960;
		this.HEIGHT = 720;
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
		int newY = y - speed;
		if (isValidMove(x, newY)) {
			y = y - speed;
		}
		System.out.println("moveUp");
	}
	
	public void moveDown() {
		int newY = y + speed;
		if (isValidMove(x, newY)) {
			y = y + speed;
		}
	}
	
	public void moveLeft() {
		int newX = x - speed;
		if (isValidMove(newX, y)) {
			x = x - speed;
		}
	}
	
	public void moveRight() {
		int newX = x + speed;
		if (isValidMove(newX, y)) {
			x = x + speed;
		}
	}
	
	private boolean isValidMove(int newX, int newY) {
		Rectangle playerBounds = new Rectangle(newX, newY, 30, 30);
		List<Box> boxes = level.getBoxes();
		System.out.println(playerBounds.x + "  " + WIDTH);
				System.out.println(playerBounds.y + "  " + HEIGHT);


		for (Box box : boxes ) {
			if (playerBounds.intersects(box.getRectangle())) {
				return false;
			}
		}
//		if (playerBounds.x+playerBounds.width+10 >= WIDTH || playerBounds.x < (WIDTH-WIDTH) ) {
//			return false;
//		}
//		if (playerBounds.y+playerBounds.height+35 >= HEIGHT || playerBounds.y < 0 ) {
//			return false;
//		}

		return true;
	}
	
	public void draw(Graphics g) {
		g.fillRect(getX(), getY(), 30, 30);
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
