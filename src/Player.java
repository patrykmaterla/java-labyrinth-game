
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Player implements java.awt.event.KeyListener {
	
	private int x;
	private int y;
	private int speed;
	private final GameComponent gameComponent;
	private Rectangle playerRectangle;
	private Level level;
	private int WIDTH;
	private int HEIGHT;
	private BufferedImage character;
	private Clip walkAudio;
	private Clip winAudio;
	private URL url;
	private AudioInputStream audioInputStream;
	private AffineTransform affineTransform;
	private int keyFrame = 0;
	private Timer componentTimer;
	private int maxFrame = 3;
	
	public Player(int x, int y, int speed, GameComponent gameComponent) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.gameComponent = gameComponent;
		playerRectangle = new Rectangle(x, y, 34, 34);
		level = new Level();
		this.WIDTH = 16*17;
		this.HEIGHT = 16*17;
		try {
			character = ImageIO.read(getClass().getResource("/resources/backpack-cat-spritesheet.png"));
		} catch (IOException ex) {
			Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		initAudio();
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
	
	private void initAudio() {
		try {
			walkAudio = AudioSystem.getClip();
			url = getClass().getResource("/resources/footstep.wav");
			audioInputStream = AudioSystem.getAudioInputStream(url);
			walkAudio.open(audioInputStream);
			
			winAudio = AudioSystem.getClip();
			url = getClass().getResource("/resources/win_alert.wav");
			audioInputStream = AudioSystem.getAudioInputStream(url);
			winAudio.open(audioInputStream);
		}
		catch (LineUnavailableException ex) {
			JOptionPane.showMessageDialog(null, "Audio file not found!");
			Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IOException | UnsupportedAudioFileException ex) {
			Logger.getLogger(GameComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	}

	public void moveUp() {
		int newY = y - speed;
		if (isValidMove(x, newY)) {
			y = y - speed;
		}
		walkAudio.start();
		if (walkAudio.getFrameLength() == walkAudio.getFramePosition())
			walkAudio.setFramePosition(0);
	}
	
	public void moveDown() {
		int newY = y + speed;
		if (isValidMove(x, newY)) {
			y = y + speed;
		}
		walkAudio.start();
		if (walkAudio.getFrameLength() == walkAudio.getFramePosition()) {
			walkAudio.setFramePosition(0);
		}
		if (getY() == 620) {
			winAudio.start();
			winAudio.setFramePosition(0);
			setX(45);
			setY(5);
		}
	}
	
	public void moveLeft() {
		int newX = x - speed;
		if (isValidMove(newX, y)) {
			x = x - speed;
		}
		walkAudio.start();
		if (walkAudio.getFrameLength() == walkAudio.getFramePosition())
			walkAudio.setFramePosition(0);
	}
	
	public void moveRight() {
		int newX = x + speed;
		if (isValidMove(newX, y)) {
			x = x + speed;
		}
		walkAudio.start();
		if (walkAudio.getFrameLength() == walkAudio.getFramePosition())
			walkAudio.setFramePosition(0);
	}
	
	private boolean isValidMove(int newX, int newY) {
		Rectangle playerBounds = new Rectangle(newX, newY, 34, 34);
		List<Box> boxes = level.getBoxes();
		
		System.out.println(playerBounds.x + "  " + WIDTH);
		System.out.println(playerBounds.y + "  " + HEIGHT);

		for (Box box : boxes ) {
			if (playerBounds.intersects(box.getRectangle())) {
				return false;
			}
		}
		
		if (playerBounds.x < 0 || playerBounds.x + playerBounds.width > gameComponent.getWidth() || playerBounds.y < 0 || playerBounds.y + playerBounds.height > gameComponent.getHeight()) {
			return false;
		}
		
//		if (playerBounds.x+playerBounds.width+10 >= WIDTH || playerBounds.x < (WIDTH-WIDTH) ) {
//			return false;
//		}
//		if (playerBounds.y+playerBounds.height+35 >= HEIGHT || playerBounds.y < 0 ) {
//			return false;
//		}
		return true;
	}
	
	
	public void action() {
		if (keyFrame < maxFrame) {
			keyFrame++;
		}
		else {
			keyFrame = 0;
		}
	}
	
	public void draw(Graphics g) {
//		g.fillRect(getX(), getY(), 30, 30);
//		g.drawImage(character, getX(), getY(), 30, 30, null);
		
// to do zoom da cat

		Graphics graphicsTemp = g.create();
		Graphics2D graphics2D = (Graphics2D) graphicsTemp;
//		affineTransform = new AffineTransform();
//		affineTransform.scale(2.0, 2.0);
//		AffineTransformOp scaleOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
		
//		BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		
		BufferedImage actualFrame = character.getSubimage(keyFrame * 34, 0, 34, 34);
//		actualFrame = scaleOp.filter(actualFrame, actualFrame);

		Graphics actualFrameGraphics = actualFrame.getGraphics();
		graphics2D.drawImage(actualFrame, getX(), getY(), 34, 34, null);

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
