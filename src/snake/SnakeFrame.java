package snake;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame {
	
	public SnakeFrame() {
		setLayout(new GridLayout());
		
		SnakeGraphics graphics = new SnakeGraphics();
		add(graphics);
		
		pack();
		setTitle("Play Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SnakeFrame();
	}
	
}
