package snake.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import snake.model.BadApple;

public class BadAppleTest {

	@Test
	public void testGetX() {
		BadApple b = new BadApple(10, 10);
		b.getX();
	}

	@Test
	public void testSetX() {
		BadApple b = new BadApple(10, 10);
		b.setX(15);
	}

	@Test
	public void testGetY() {
		BadApple b = new BadApple(10, 10);
		b.getY();
	}

	@Test
	public void testSetY() {
		BadApple b = new BadApple(10, 10);
		b.setY(100);
	}

}
