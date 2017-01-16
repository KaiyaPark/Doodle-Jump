import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer t = new Timer(1000 / 10000, this);
	int x = 250;
	int y = 600;
	int width = 100;
	int height = 100;

	GamePanel() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();

	}

	void startGame() {
		t.start();
	}
public void paintComponent(Graphics g){
	g.fillRect(x, y, width, height);
	}

@Override
public void keyTyped(KeyEvent e) {
		
}

@Override
public void keyPressed(KeyEvent e) {
if(e.getKeyCode()==KeyEvent.VK_LEFT){
	x = x-10;
}
if(e.getKeyCode()==KeyEvent.VK_RIGHT){
	x = x+10;
}
}

@Override
public void keyReleased(KeyEvent e) {

	
}
}
