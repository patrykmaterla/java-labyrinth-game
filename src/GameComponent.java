import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class GameComponent extends JComponent implements ActionListener {
	
	private final Player player;
	private final Level level;
	private Clip backgroundAudio;
	private BufferedImage bufferedImage;
	private URL url;
	private final Timer componentTimer;
	private final int width;
	private final int height;
	
	public GameComponent() {
		player = new Player(45, 5, 5, this);
		addKeyListener(player);
		setFocusable(true);
		level = new Level();
		width = 40 * 17;
		height = 40 * 17;
		initAudio();
		componentTimer = new Timer(100, this);
		componentTimer.start();
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
	
	private void initAudio() {
		try {
			backgroundAudio = AudioSystem.getClip();
			url = getClass().getResource("/resources/simple-piano-melody.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
			backgroundAudio.open(audioInputStream);
			backgroundAudio.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch (LineUnavailableException ex) {
			JOptionPane.showMessageDialog(null, "Audio file not found!");
			Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IOException | UnsupportedAudioFileException ex) {
			Logger.getLogger(GameComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		backgroundAudio.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		player.action();
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.setColor(Color.red);
		try {
			bufferedImage = javax.imageio.ImageIO.read(GameComponent.class.getResource("resources/textures.png"));
		} catch (IOException ex) {
			Logger.getLogger(GameComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		level.draw(graphics);
		player.draw(graphics);
	}

}
