import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer t = new Timer(5, this);
	final int MENU_STATE = 0;
	Font hi = new Font("Tangerine", Font.PLAIN, 24);
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	static BufferedImage grid;
	static BufferedImage start;
	Doodler d = new Doodler();
	final int doodlerStartX = 175;
	final int doodlerStartY = 600;
	ObjectManager oM = new ObjectManager();
	DoodleJump main = new DoodleJump();
	int score;

	GamePanel() {
		try {
			grid = ImageIO.read(this.getClass().getResourceAsStream("grid.gif"));
			start = ImageIO.read(this.getClass().getResourceAsStream("start.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startGame();
		score = 0;
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
			d.setY(doodlerStartY);
			d.setX(doodlerStartX);
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			d.setY(d.getY() - 20);
		}
	}
	private void bing(){
		try{
			AudioClip sound = JApplet.newAudioClip(getClass().getResource("bing.wav"));
			sound.play();
		} catch(Exception e){
			
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
		oM.update();
		if (checkCollision()) {
			repaint();
			d.setY(d.getY() - 100);
			score = score + 1;
			bing();
		}
		if (d.getY() >= main.getHeight()) {
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
		oM.draw(g);
		g.setColor(Color.BLACK);
		g.setFont(hi);
		g.drawString("Score is " + score, 350, 75);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.WHITE);
		g.drawString("You lose! Your score was " + score + ". Beat your score! To play again press enter.", 25, 200);
	}

	private boolean checkCollision() {
		d.setY(d.getY() + 1);
		return oM.isColliding(d.getrBox());
	}
}
