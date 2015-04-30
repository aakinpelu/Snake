package snake.gui;

import java.awt.Color;
import java.awt.Graphics;

public class Snake {
	private int x, y, width, height;
	
	public Snake(int x, int y, int tileSize) {
		this.x = x;
		this.y = y;
		width = tileSize;
		height = tileSize;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x * width, y * height, width, height);
		g.setColor(Color.green);
		g.fillRect(x * width + 2, y * height + 2, width - 2, height - 2);
	}
}
