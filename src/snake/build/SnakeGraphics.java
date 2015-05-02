package snake.build;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import snake.fruit.Apple;
import snake.fruit.BadApple;


public class SnakeGraphics extends JPanel implements Runnable {
	private static SnakeGraphics graphics = null;
	
	final int WIDTH = 300, HEIGHT = 300;
	private boolean gameRun = false;
	private Thread thread;
	
	private SnakeBuild snakePart;
	private ArrayList<SnakeBuild> snakeBuild;
	
	private Apple apple;
	private ArrayList<Apple> apples;
	private Random rand;
	
	private BadApple badApple;
	private ArrayList<BadApple> badApples;
	
	private int x, y, size = 5;
	
	private long moves;
	private boolean right = true;
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	
	private SnakeGraphics() {
		setFocusable(true);
		addKeyListener(new Move());
		
		snakeBuild = new ArrayList<SnakeBuild>();
		apples = new ArrayList<Apple>();
		badApples = new ArrayList<BadApple>();
		rand = new Random();
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		start();
	}
	
	public static SnakeGraphics getSnakeGraphics() {		
		if (graphics == null) {
			SnakeGraphics graphics2 = new SnakeGraphics();
			graphics = graphics2;
		}
		return graphics;
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		
		for(int i = 0; i < snakeBuild.size(); i++) {
			snakeBuild.get(i).paint(g);
		}
		
		for(int i = 0; i < apples.size(); i++) {
			apples.get(i).paint(g);
		}
		
		for(int i = 0; i < badApples.size(); i++) {
			badApples.get(i).paint(g);
		}
	}

	public boolean isGameRun() {
		return gameRun;
	}

	public void snakeChange() {
		if(snakeBuild.size() == 0) {
			snakePart = new SnakeBuild(x, y);
			snakeBuild.add(snakePart);
		}
		
		if(apples.size() == 0) {
			int x = rand.nextInt(29);
			int y = rand.nextInt(29);
			
			apple = new Apple(x,y);
			apples.add(apple);
			
			int x2 = rand.nextInt(29);
			int y2 = rand.nextInt(29);
			
			badApple = new BadApple(x2,y2);
			badApples.add(badApple);
		}
		
		for(int i = 0; i < apples.size(); i++) {
			if(x == apples.get(i).getX() && y == apples.get(i).getY()) {
				size++;
				apples.remove(i);
			}
		}
		
		for(int i = 0; i < badApples.size(); i++) {
			if(x == badApples.get(i).getX() && y == badApples.get(i).getY()) {
				stop();
			}
		}
		
		if(x < 0 || x > 29 || y < 0 || y > 29) {
			stop();
		}
		
		moves++;
		if(moves > 500000) {
			if(right) {
				x++;
			} else if(up) {
				y++;
			} else if(down) {
				y--;
			} else if(left) {
				x--;
			}
			moves = 0;
			
			snakePart = new SnakeBuild(x, y);
			snakeBuild.add(snakePart);
			
			if(snakeBuild.size() > size) {
				snakeBuild.remove(0);
			}
		}
	}
	
	public void start(){
		gameRun = true;
		thread = new Thread(this, "snake");
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
			snakeChange();
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
			
			if(gameRun == false && key == KeyEvent.KEY_PRESSED) {
				gameRun = true;
				start();
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
