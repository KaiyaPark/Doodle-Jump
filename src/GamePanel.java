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
	Timer t = new Timer(1000 / 10000, this);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	static BufferedImage grid;
	GamePanel() {
		try {
			grid=ImageIO.read(this.getClass().getResourceAsStream("grid.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if(currentState == MENU_STATE){
			updateMenuState();
		}else if(currentState == GAME_STATE){
			updateGameState();
		}else if(currentState == END_STATE){
			updateEndState();
		}

	}

	void startGame() {
		t.start();
	}

	public void paintComponent(Graphics g) {
		
		if(currentState == MENU_STATE){
			drawMenuState(g);
		}else if(currentState == GAME_STATE){
			drawGameState(g);
		}else if(currentState == END_STATE){
			drawEndState(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			System.out.println("ihjiuhiuh");
			currentState = currentState++;
		}

		if(currentState > END_STATE){
			currentState = MENU_STATE;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	void updateMenuState() {

	}

	void updateGameState() {

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 500, 800);
//		System.out.println("hi");
	}

	void drawGameState(Graphics g) {
		//System.out.println("hi");
		g.drawImage(grid, 0, 0, 500, 800, null);
		}

	void drawEndState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 500, 800);    

	}
}
