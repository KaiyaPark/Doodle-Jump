import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Platform extends GameObject{
	static BufferedImage plat;
	Rectangle platform = new Rectangle();
	Platform(int newX, int newY) {
		try {
			plat = ImageIO.read(this.getClass().getResourceAsStream("p.png"));
			x = newX;
			y = newY;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Rectangle getrBox(){
		return platform;
	}
	void update(){
		platform.setBounds(x, y, plat.getWidth(), 5);
	}
	
	void draw(Graphics g){
		g.drawImage(plat, x, y, null);
		g.setColor(Color.BLUE);
		g.drawRect(x, y, plat.getWidth(), 5);
	}
}
