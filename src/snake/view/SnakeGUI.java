package snake.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import snake.controller.SnakeGraphics;

public class SnakeGUI extends JFrame {
	
	public SnakeGUI() {
		setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout());
		topPanel.setBorder(new EmptyBorder(10,0,10,0));//padding around north
		add(topPanel, BorderLayout.NORTH);
		
		Icon icon = new ImageIcon("src/snake.png");
		JLabel image = new JLabel(icon);
		topPanel.add(image);
		image.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel title = new JLabel("  SNAKE");
		topPanel.add(title);
		title.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout());
		centerPanel.setBorder(new EmptyBorder(0,20,0,20));//padding around center
		add(centerPanel, BorderLayout.CENTER);
		
		SnakeGraphics graphics = SnakeGraphics.getSnakeGraphics();
		centerPanel.add(graphics);

		JLabel end = new JLabel("Slithering...");
		end.setBorder(new EmptyBorder(5,0,5,0));//padding around south
		add(end, BorderLayout.SOUTH);
		end.setHorizontalAlignment(SwingConstants.CENTER);
		
		//shows you lose instead of slithering once game ends
		if(graphics.isGameRun() == false) {
			end.setText("You Lose!");
		}	
	}
	
	public static void main(String[] args) {
		SnakeGUI frame = new SnakeGUI();
		frame.pack();
		frame.setTitle("Play Snake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
