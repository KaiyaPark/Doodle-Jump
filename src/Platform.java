import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Platform {
	static BufferedImage plat;
	int px = 250;
	int py = 600;
	Rectangle platform = new Rectangle();
	Platform() {
		try {
			plat = ImageIO.read(this.getClass().getResourceAsStream("p.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Rectangle getrBox(){
		return platform;
	}
	void update(){
		platform.setBounds(px, py, plat.getWidth(), plat.getHeight());
	}
	
	void draw(Graphics g){
		g.drawImage(plat, px, py, null);
		g.setColor(Color.BLUE);
		g.drawRect(px, py, plat.getWidth(), plat.getHeight());
	}
}
