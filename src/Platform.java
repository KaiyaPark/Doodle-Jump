import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Platform extends GameObject {
	static BufferedImage plat;
	Rectangle platform = new Rectangle();

	Platform(int newY) {
		try {
			plat = ImageIO.read(this.getClass().getResourceAsStream("p.png"));
			x = new Random().nextInt(DoodleJump.width - plat.getWidth());
			y = newY;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fall(int distance) {
		y = y + distance;
	}

	Rectangle getrBox() {
		return platform;
	}

	void update() {
		platform.setBounds(x, y, plat.getWidth(), 5);

	}

	void draw(Graphics g) {
		g.drawImage(plat, x, y, null);
		g.setColor(Color.BLUE);
		g.drawRect(x, y, plat.getWidth(), 5);
	}
}
