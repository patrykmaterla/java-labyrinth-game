import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Box {

	private Rectangle rectangle = new Rectangle();
	private final BufferedImage bufferedImage;
	
	public Box(int x, int y, int width, int height, BufferedImage bufferedImage) {
		this.rectangle = new Rectangle(x, y, width, height);
		this.bufferedImage = bufferedImage;
	}	
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}
	
}
