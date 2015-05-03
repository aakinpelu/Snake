package snake.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import snake.model.Apple;
import snake.model.BadApple;
import snake.model.SnakeBuild;


public class SnakeGraphics extends JPanel implements Runnable {
	//Singleton pattern
	private static SnakeGraphics graphics = null;
	
	//frame width/height
	private final int WIDTH = 300, HEIGHT = 300;
	
	//building snake parts
	private SnakeBuild snakePart;
	private ArrayList<SnakeBuild> snakeBuild;
	
	//creating apples in grid randomly
	private Apple apple;
	private ArrayList<Apple> apples;
	private Random random;
	
	private BadApple badApple;
	private ArrayList<BadApple> badApples;
	
	//location and size of snake start
	private int x, y, size = 5;
	
	//how snake moves when key is pressed
	private long moves;
	private boolean right = true;
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;

	//signals whether game is running
	private boolean gameRun = false;
	private Thread thread;
	
	private SnakeGraphics() {
		addKeyListener(new Move());
		
		snakeBuild = new ArrayList<SnakeBuild>();
		apples = new ArrayList<Apple>();
		badApples = new ArrayList<BadApple>();
		random = new Random();
		
		setFocusable(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		start();
	}
	
	//Singleton
	public static SnakeGraphics getSnakeGraphics() {		
		if (graphics == null) {
			SnakeGraphics graphics2 = new SnakeGraphics();
			graphics = graphics2;
		}
		return graphics;
	}
	
	//painting snake and apples
	public void paint(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);//clears trailing snake
		
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
	
	//to check whether game ends to send loser message...needs work
	public boolean isGameRun() {
		return gameRun;
	}

	public void snakeChange() {
		//adding snake parts to whole
		if(snakeBuild.size() == 0) {
			snakePart = new SnakeBuild(x, y);
			snakeBuild.add(snakePart);
		}
		
		//creates new apples randomly
		if(apples.size() == 0) {
			int x = random.nextInt(29);
			int y = random.nextInt(29);
			
			apple = new Apple(x,y);
			apples.add(apple);
			
			int x2 = random.nextInt(29);
			int y2 = random.nextInt(29);
			
			badApple = new BadApple(x2,y2);
			badApples.add(badApple);
		}
		
		//removes eaten apples and increases snake size
		for(int i = 0; i < apples.size(); i++) {
			if(x == apples.get(i).getX() && y == apples.get(i).getY()) {
				size++;
				apples.remove(i);
			}
		}
		
		//stops game when bad apples are eaten
		for(int i = 0; i < badApples.size(); i++) {
			if(x == badApples.get(i).getX() && y == badApples.get(i).getY()) {
				stop();
			}
		}
		
		//stops game when borders are hit
		if(x < 0 || x > 29 || y < 0 || y > 29) {
			stop();
		}
		
		//directs snake around grid
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
			
			//adds to snake to enable movement
			snakePart = new SnakeBuild(x, y);
			snakeBuild.add(snakePart);
			
			//removes end of snake as it moves across grid
			if(snakeBuild.size() > size) {
				snakeBuild.remove(0);
			}
		}
	}
	
	//starts game
	public void start(){
		gameRun = true;
		thread = new Thread(this, "snake");
		thread.start();
	}
	
	//ends game
	public void stop(){
		gameRun = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//runs game, directing changes in snake and apples
	public void run(){
		while(gameRun) {
			snakeChange();
			repaint();
		}
	}
	
	//try implementing in separate class...failed
	//listens to arrow presses to direct snake movement
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
