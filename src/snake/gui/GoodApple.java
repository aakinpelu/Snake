package snake.gui;

import java.awt.Color;
import java.awt.Graphics;

public class GoodApple {
	private int x, y, width, height;
	
	public GoodApple(int x, int y, int tileSize) {
		this.x = x;
		this.y = y;
		width = tileSize;
		height = tileSize;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x * width, y * height, width, height);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}