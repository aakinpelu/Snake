package snake.build;

import java.awt.Color;
import java.awt.Graphics;

public class SnakeBuild {
	private int x, y, width = 10, height = 10;
	
	public SnakeBuild(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x * width, y * height, width, height);
		g.setColor(Color.green);
		g.fillRect(x * width, y * height, width - 2, height - 2);
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
