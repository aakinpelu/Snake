package snake.gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import snake.build.SnakeGraphics;

public class SnakeFrame extends JFrame {
	
	public SnakeFrame() {
		setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout());
		topPanel.setBorder(new EmptyBorder(10,0,10,0));
		add(topPanel, BorderLayout.NORTH);
		
		Icon icon = new ImageIcon("snake.png");
		JLabel image = new JLabel(icon);
		topPanel.add(image);
		image.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel title = new JLabel("  SNAKE");
		topPanel.add(title);
		title.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout());
		add(centerPanel, BorderLayout.CENTER);
		
		SnakeGraphics graphics = SnakeGraphics.getSnakeGraphics();
		centerPanel.add(graphics);

		JLabel end = new JLabel("Slithering...");
		end.setBorder(new EmptyBorder(5,0,5,0));
		add(end, BorderLayout.SOUTH);
		end.setHorizontalAlignment(SwingConstants.CENTER);
		
		if(graphics.isGameRun() == false) {
			end.setText("You Lose!");
		}	
	}
	
	public static void main(String[] args) {
		SnakeFrame frame = new SnakeFrame();
		frame.pack();
		frame.setTitle("Play Snake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
