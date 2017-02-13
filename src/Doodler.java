import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Doodler extends GameObject {
	static BufferedImage doodle;
		
	Doodler() {
		try {
			doodle = ImageIO.read(this.getClass().getResourceAsStream("doodler.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void update() {

	}

	void draw(Graphics g) {
		g.drawImage(doodle, 0, 0, 500, 800, null);
	}
}
