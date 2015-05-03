package snake.model;

import java.awt.Color;
import java.awt.Graphics;

public class BadApple {
	//defines bad apple size, note: bad apple is-NOT an Apple
	private int x, y, width = 10, height = 10;
	
	public BadApple(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
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
