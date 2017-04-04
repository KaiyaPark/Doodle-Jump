import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Rectangle;
import javax.imageio.ImageIO;
import java.awt.Color;
public class Doodler extends GameObject {
	static BufferedImage doodle;
	int speed = 2;
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
			x += speed;
		}
		if(moveLeft){
			x -= speed;
		}
		if(x<-25){
			x=500;
		}
		if(x>500){
			x=0;
		}
		rbox.setBounds(x+30, y+80, 50, 5);
	}
	
	void draw(Graphics g) {
		g.drawImage(doodle,x, y, null);
		g.setColor(Color.red);
		g.drawRect(rbox.x, rbox.y, rbox.width, rbox.height);
	}
	Rectangle getrBox(){
		return rbox;
	}
}
