import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer t = new Timer(7, this);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	static BufferedImage grid;
	static BufferedImage start;
	Doodler d = new Doodler();
	Platform p = new Platform(250, 575);
	Platform p2 = new Platform(25, 700);
	Platform p3 = new Platform(325, 300);
	Platform p4 = new Platform(125, 400);
	GamePanel() {
		try {
			grid = ImageIO.read(this.getClass().getResourceAsStream("grid.gif"));
			start = ImageIO.read(this.getClass().getResourceAsStream("start.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	void startGame() {
		t.start();
	}

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			d.moveLeft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			d.moveRight = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			currentState = currentState + 1;

		}

		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			d.setY(d.getY() - 20);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			d.moveLeft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			d.moveRight = false;
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
		d.update();
		p.update();
		p2.update();
		p3.update();
		p4.update();
		checkCollision();
		if(d.getY()>=825){
			currentState = currentState + 1;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.drawImage(start, 0, 0, null);
	}

	void drawGameState(Graphics g) {
		g.drawImage(grid, 0, 0, 500, 800, null);
		d.draw(g);
		p.draw(g);
		p2.draw(g);
		p3.draw(g);
		p4.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 500, 800);
	}

	private boolean checkCollision() {
		d.setY(d.getY()+1);
		if (d.getrBox().intersects(p.getrBox())) {
			p.setY(p.getY() + 150);
			p2.setY(p2.getY() + 150);
			p3.setY(p3.getY() + 150);
			p4.setY(p4.getY() + 150);
			return true;
		}
		if (d.getrBox().intersects(p2.getrBox())) {
			p.setY(p.getY() + 150);
			p2.setY(p2.getY() + 150);
			p3.setY(p3.getY() + 150);
			p4.setY(p4.getY() + 150);
			return true;
		}
		if (d.getrBox().intersects(p3.getrBox())) {
			p.setY(p.getY() + 150);
			p2.setY(p2.getY() + 150);
			p3.setY(p3.getY() + 150);
			p4.setY(p4.getY() + 150);
			return true;
		}
		if (d.getrBox().intersects(p4.getrBox())) {
			p.setY(p.getY() + 150);
			p2.setY(p2.getY() + 150);
			p3.setY(p3.getY() + 150);
			p4.setY(p4.getY() + 150);
			return true;
		}
		return false;
	}
}
