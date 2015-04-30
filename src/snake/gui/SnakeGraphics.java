package snake.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class SnakeGraphics extends JPanel implements Runnable {
	final int WIDTH = 500, HEIGHT = 500;
	private boolean gameRun = false;
	private Thread thread;
	
	private Snake snakePart;
	private ArrayList<Snake> snake;
	
	private GoodApple goodApple;
	private ArrayList<GoodApple> goodApples;
	private Random rand;
	
	private BadApple badApple;
	private ArrayList<BadApple> badApples;
	
	private int x, y, size = 5;
	
	private long ticks;
	private boolean right = true;
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	
	public SnakeGraphics() {
		setBackground(Color.black);
		setFocusable(true);
		addKeyListener(new Move());
		
		snake = new ArrayList<Snake>();
		goodApples = new ArrayList<GoodApple>();
		badApples = new ArrayList<BadApple>();
		rand = new Random();
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		start();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.clearRect(0, 0, WIDTH, HEIGHT);
		setBackground(Color.black);
		for(int i = 0; i < WIDTH / 10; i++) {
			g.drawLine(i * 10, 0, i * 10, HEIGHT);
		}
		
		for(int i = 0; i < HEIGHT / 10; i++) {
			g.drawLine(0, i * 10, WIDTH, i * 10);
		}
		
		for(int i = 0; i < snake.size(); i++) {
			snake.get(i).paint(g);
		}
		
		for(int i = 0; i < goodApples.size(); i++) {
			goodApples.get(i).paint(g);
		}
		
		for(int i = 0; i < badApples.size(); i++) {
			badApples.get(i).paint(g);
		}
	}
	
	public void tick() {
		if(snake.size() == 0) {
			snakePart = new Snake(x, y, 10);
			snake.add(snakePart);
		}
		
		if(goodApples.size() == 0) {
			int x = rand.nextInt(49);
			int y = rand.nextInt(49);
			
			goodApple = new GoodApple(x,y, 10);
			goodApples.add(goodApple);
			
			int x2 = rand.nextInt(49);
			int y2 = rand.nextInt(49);
			
			badApple = new BadApple(x2,y2, 10);
			badApples.add(badApple);
		}
		
		for(int i = 0; i < goodApples.size(); i++) {
			if(x == goodApples.get(i).getX() && y == goodApples.get(i).getY()) {
				size++;
				goodApples.remove(i);
				i--;
			} else if(x == badApples.get(i).getX() && y == badApples.get(i).getY()) {
				stop();
			}
		}
		
		for(int i = 0; i < goodApples.size(); i++) {
			if(x == snake.get(i).getX() && y == snake.get(i).getY()) {
				if(i != snake.size() - 1) {
					stop();
				}
			}
		}
		
		if(x < 0 || x > 49 || y < 0 || y > 49) {
			stop();
		}
		
		ticks++;
		
		if(ticks > 250000) {
			if(right) {
				x++;
			} else if(up) {
				y++;
			} else if(down) {
				y--;
			} else if(left) {
				x--;
			}
			ticks = 0;
			
			snakePart = new Snake(x, y, 10);
			snake.add(snakePart);
			
			if(snake.size() > size) {
				snake.remove(0);
			}
		}
	}
	
	public void start(){
		gameRun = true;
		thread = new Thread(this, "Game loop");
		thread.start();
	}
	
	public void stop(){
		gameRun = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		while(gameRun) {
			tick();
			repaint();
		}
	}

	public class Move implements KeyListener {

		@Override
		public void keyPressed(KeyEvent k) {
			int key = k.getKeyCode();
			
			if(key == KeyEvent.VK_RIGHT && !left) {
				right = true;
				up = false;
				down = false;
			}
			
			if(key == KeyEvent.VK_LEFT && !right) {
				left = true;
				up = false;
				down = false;
			}
			
			if(key == KeyEvent.VK_UP && !down) {
				down = true;
				right = false;
				left = false;
			}
			
			if(key == KeyEvent.VK_DOWN && !up) {
				up = true;
				right = false;
				left = false;
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}

	}
}
