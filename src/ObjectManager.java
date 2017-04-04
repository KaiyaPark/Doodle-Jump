
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<Platform> objects;
	

	public ObjectManager() {
		objects = new ArrayList<Platform>();
		addObject(new Platform(575));
		addObject(new Platform(700));
		addObject(new Platform(300));
		addObject(new Platform(400));
		addObject(new Platform(150));
		addObject(new Platform(0));
		addObject(new Platform(-100));
		addObject(new Platform(500));
		addObject(new Platform(675));
		addObject(new Platform(350));
		addObject(new Platform(425));
		addObject(new Platform(200));
		addObject(new Platform(25));
		addObject(new Platform(-200));
		addObject(new Platform(800));
		addObject(new Platform(750));
	}

	public void addObject(Platform o) {
		objects.add(o);
	}

	public void fall(int distance) {
		for (int i = 0; i < objects.size(); i++) {
			Platform o = objects.get(i);
			o.fall(distance);
		}
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			Platform o = objects.get(i);
			o.update();
		}
	}

	public boolean isColliding(Rectangle doodleBox) {
		for (int i = 0; i < objects.size(); i++) {
			Platform o = objects.get(i);
			if (doodleBox.intersects(o.getrBox())) {

				for (int j = 0; j < objects.size(); j++) {
					Platform p = objects.get(j);
					p.setY(p.getY() + 100);
				
					return true;
				}
			}
		}
		return false;

	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			Platform o = objects.get(i);
			o.draw(g);
		}
	}

	public void reset() {
		objects.clear();
	}

}
