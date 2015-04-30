package snake.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class SnakeFrame extends JFrame {
	
	public SnakeFrame() {
		setLayout(new GridLayout(1,1,0,0));
		
		SnakeGraphics graphics = new SnakeGraphics();
		add(graphics);
		
		pack();
		setTitle("Play Snake");
		setBackground(Color.black);
//		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SnakeFrame();
		
	}
	
}
