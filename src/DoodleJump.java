import javax.swing.JFrame;

public class DoodleJump {
	JFrame f = new JFrame();
	public static final int width = 500;
	public static final int height = 800;
	GamePanel g;

		public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	void setup() {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g = new GamePanel();
		f.add(g);
		f.setVisible(true);
		g.startGame();
		f.setSize(width, height);
		f.addKeyListener(g);
		
	}

	public static void main(String[] args) {
		DoodleJump d = new DoodleJump();
		d.setup();
	}

}
