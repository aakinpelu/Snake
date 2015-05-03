package snake.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import snake.model.SnakeBuild;

public class SnakeBuildTest {

	@Test
	public void testGetX() {
		SnakeBuild build = new SnakeBuild(10, 10);
		build.getX();
	}

	@Test
	public void testSetX() {
		SnakeBuild build = new SnakeBuild(10, 10);
		build.setX(20);
	}

	@Test
	public void testGetY() {
		SnakeBuild build = new SnakeBuild(10, 10);
		build.getY();
	}

	@Test
	public void testSetY() {
		SnakeBuild build = new SnakeBuild(10, 10);
		build.setY(30);
	}

}
