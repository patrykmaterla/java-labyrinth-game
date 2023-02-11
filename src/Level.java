
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Level {

	private BufferedImage texture;
	private BufferedImage boxTexture;
	private List<Box> boxes = new ArrayList<>();
	private int boxWidth;
	private int boxHeight;
	
	public Level() {
		boxWidth = 40;
		boxHeight = 40;
		initTextures();
		initLevel();
	}

	private void initTextures() {
		try {
			texture = ImageIO.read(GameComponent.class.getResource("/resources/textures.png"));
		} catch (IOException ex) {
			Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		boxTexture = texture.getSubimage(9*16, 17*16, 16, 16);
	}
	
	private void initLevel() {
		
		
//		for (int i = 0; i <= 18; i++) {
//			boxes.add(new Box(i * boxWidth, 0 * boxHeight, boxWidth, boxHeight, boxTexture));
//			boxes.add(new Box(i * boxWidth, 17 * boxHeight, boxWidth, boxHeight, boxTexture));
//			boxes.add(new Box(0 * boxWidth, i * boxHeight, boxWidth, boxHeight, boxTexture));
//			boxes.add(new Box(17 * boxWidth, i * boxHeight, boxWidth, boxHeight, boxTexture));	
//		}
		
		for (int i = 0; i < 17; i++) {
			int[] validValues = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) {
				boxes.add(new Box(i * boxWidth, 0 * boxHeight, boxWidth, boxHeight, boxTexture));
			}
		}
		
		for (int i = 0; i <= 17; i++) {
			int[] validValues = {0, 5, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) 
				boxes.add(new Box(i * boxWidth, 1 * boxHeight, boxWidth, boxHeight, boxTexture));
		}	
		
		for (int i = 0; i <= 17; i++) {
			int[] validValues = {0, 1, 2, 3, 5, 7, 8, 9, 10, 11, 12, 13, 14, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) 
				boxes.add(new Box(i * boxWidth, 2 * boxHeight, boxWidth, boxHeight, boxTexture));
		}
		
		for (int i = 0; i <= 17; i++) {
			int[] validValues = {0, 5, 7, 14, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) 
				boxes.add(new Box(i * boxWidth, 3 * boxHeight, boxWidth, boxHeight, boxTexture));
		}	
		
		for (int i = 0; i <= 17; i++) {
			int[] validValues = {0, 2, 3, 4, 5, 7, 9, 10, 11, 12, 14, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) {
				boxes.add(new Box(i * boxWidth, 4 * boxHeight, boxWidth, boxHeight, boxTexture));
			}
		}
		
		for (int i = 0; i <= 17; i++) {
			int[] validValues = {0, 7, 9, 12, 14, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) {
				boxes.add(new Box(i * boxWidth, 5 * boxHeight, boxWidth, boxHeight, boxTexture));
			}
		}
		
		for (int i = 0; i <= 17; i++) {
			int[] validValues = {0, 1, 2, 3, 4, 5, 6, 7, 9, 11, 12, 14, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) {
				boxes.add(new Box(i * boxWidth, 6 * boxHeight, boxWidth, boxHeight, boxTexture));
			}
		}
		
		for (int i = 0; i <= 17; i++) {
			int[] validValues = {0, 9, 14, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) {
				boxes.add(new Box(i * boxWidth, 7 * boxHeight, boxWidth, boxHeight, boxTexture));
			}
		}
		
		for (int i = 0; i <= 17; i++) {
			int[] validValues = {0, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) {
				boxes.add(new Box(i * boxWidth, 8 * boxHeight, boxWidth, boxHeight, boxTexture));
			}
		}
		
		for (int i = 0; i <= 17; i++) {
			int[] validValues = {0, 2, 7, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) {
				boxes.add(new Box(i * boxWidth, 9 * boxHeight, boxWidth, boxHeight, boxTexture));
			}
		}
		
		for (int i = 0; i <= 17; i++) {
			int[] validValues = {0, 2, 4, 5, 7, 9, 10, 11, 12, 13, 14, 15, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) {
				boxes.add(new Box(i * boxWidth, 10 * boxHeight, boxWidth, boxHeight, boxTexture));
			}
		}
		
		for (int i = 0; i <= 17; i++) {
			int[] validValues = {0, 2, 4, 7, 9, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) {
				boxes.add(new Box(i * boxWidth, 11 * boxHeight, boxWidth, boxHeight, boxTexture));
			}
		}
		
		for (int i = 0; i < 17; i++) {
			int[] validValues = {0, 2, 4, 5, 6, 7, 9, 11, 12, 13, 14, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) {
				boxes.add(new Box(i * boxWidth, 12 * boxHeight, boxWidth, boxHeight, boxTexture));
			}
		}
		
		for (int i = 0; i <= 17; i++) {
			int[] validValues = {0, 2, 9, 11, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) {
				boxes.add(new Box(i * boxWidth, 13 * boxHeight, boxWidth, boxHeight, boxTexture));
			}
		}
		
		for (int i = 0; i <= 17; i++) {
			int[] validValues = {0, 2, 3, 4, 5, 6, 7, 8, 9, 11, 13, 14, 15, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) {
				boxes.add(new Box(i * boxWidth, 14 * boxHeight, boxWidth, boxHeight, boxTexture));
			}
		}
		
		for (int i = 0; i <= 17; i++) {
			int[] validValues = {0, 11, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) {
				boxes.add(new Box(i * boxWidth, 15 * boxHeight, boxWidth, boxHeight, boxTexture));
			}
		}
		
		for (int i = 0; i <= 17; i++) {
			int[] validValues = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11, 12, 13, 14, 16};
			if (Arrays.binarySearch(validValues, i) >= 0) {
				boxes.add(new Box(i * boxWidth, 16 * boxHeight, boxWidth, boxHeight, boxTexture));
			}
		}
		
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
