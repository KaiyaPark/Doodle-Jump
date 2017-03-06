import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Rectangle;
import javax.imageio.ImageIO;
import java.awt.Color;
public class Doodler extends GameObject {
	static BufferedImage doodle;
	int speed = 1;
	boolean moveRight = false;
	boolean moveLeft = false;
	Rectangle rbox = new Rectangle();
	
	Doodler() {
		
		try {
			doodle = ImageIO.read(this.getClass().getResourceAsStream("doodler.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void update() {
		if(moveRight){
			doodlex += speed;
		}
		if(moveLeft){
			doodlex -= speed;
		}
		if(doodlex<-25){
			doodlex=500;
		}
		if(doodlex>500){
			doodlex=0;
		}
		rbox.setBounds(doodlex, doodley, 100, 90);
	}
	
	void draw(Graphics g) {
		g.drawImage(doodle, doodlex, doodley, null);
		g.setColor(Color.red);
		g.drawRect(rbox.x, rbox.y, rbox.width, rbox.height);
	}
	Rectangle getrBox(){
		return rbox;
	}
}
