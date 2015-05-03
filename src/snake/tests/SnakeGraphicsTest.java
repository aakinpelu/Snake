package snake.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import snake.controller.SnakeGraphics;

public class SnakeGraphicsTest {

	@Test
	public void testIsGameRun() {
		SnakeGraphics g = SnakeGraphics.getSnakeGraphics();
		g.isGameRun();
	}

	@Test
	public void testSnakeChange() {
		SnakeGraphics g = SnakeGraphics.getSnakeGraphics();
		g.snakeChange();
	}

	@Test
	public void testStart() {
		SnakeGraphics g = SnakeGraphics.getSnakeGraphics();
		g.start();
	}

	@Test
	public void testStop() {
		SnakeGraphics g = SnakeGraphics.getSnakeGraphics();
		g.stop();
	}

	@Test
	public void testRun() {
		SnakeGraphics g = SnakeGraphics.getSnakeGraphics();
		g.run();
	}
	//throws NullPointerException at line 111 which I don't understand,
	//considering the code works...
}
