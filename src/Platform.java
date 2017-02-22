import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Platform {
	static BufferedImage plat;
	int px = 250;
	int py = 600;
	
	Platform() {
		try {
			plat = ImageIO.read(this.getClass().getResourceAsStream("p.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void update(){
		
	}
	
	void draw(Graphics g){
		g.drawImage(plat, px, py, null);
	}
}
