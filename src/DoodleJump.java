import javax.swing.JFrame;

public class DoodleJump {
	JFrame f = new JFrame();
	final int width = 500;
	final int height = 800;
	GamePanel g = new GamePanel();

	DoodleJump() {
		setup();
	}

	void setup() {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(g);
		f.setVisible(true);
		g.startGame();
		f.setSize(width, height);
		f.addKeyListener(g);
	}

	public static void main(String[] args) {
		DoodleJump d = new DoodleJump();

	}

}
