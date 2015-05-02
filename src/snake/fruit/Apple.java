package snake.fruit;

import java.awt.Color;
import java.awt.Graphics;

public class Apple {
	private int x, y, width = 10, height = 10;
	
	public Apple(int x, int y) {
		this.x = x;
		this.y = y;
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