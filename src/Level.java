
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class Level {

	private Player player;
	private BufferedImage bufferedImage;
	private List<Box> boxes = new ArrayList<>();
	
//	public Level() {
//				boxes.add(new Box(0, 0, 50, 50, null));
//		boxes.add(new Box(50, 0, 50, 50, null));
//				boxes.add(new Box(100, 0, 50, 500, null));
//
//	}
//	
	public Level() throws IOException {
		System.out.println("level()");
		setBufferedImage(ImageIO.read(Level.class.getResource("resources/textures.png")));
//		try {
//			bufferedImage = javax.imageio.ImageIO.read(GameComponent.class.getResource("resources/textures.png"));
//		}
//		catch (Exception exception) {
//			System.err.println("Błąd");
//		}
		BufferedImage croppedImage = bufferedImage.getSubimage(9*16, 17*16, 16, 16);
//		
		boxes.add(new Box(0, 0, 50, 50, croppedImage));
		boxes.add(new Box(50, 0, 50, 50, croppedImage));
		boxes.add(new Box(100, 0, 50, 500, croppedImage));
	}

	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
	
	public void draw(Graphics g) {
		for (Box box : boxes) {
			g.drawImage(box.getBufferedImage(), box.getRectangle().x, box.getRectangle().y, box.getRectangle().width, box.getRectangle().height, null);
		}
	}
	
	public List getBoxes() {
		return boxes;
	}
	
}
