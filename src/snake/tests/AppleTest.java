package snake.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import snake.model.Apple;

public class AppleTest {

	@Test
	public void testGetX() {
		Apple a = new Apple(10, 10);
		a.getX();
	}

	@Test
	public void testSetX() {
		Apple a = new Apple(10, 10);
		a.setX(40);
	}

	@Test
	public void testGetY() {
		Apple a = new Apple(10, 10);
		a.getY();
	}

	@Test
	public void testSetY() {
		Apple a = new Apple(10, 10);
		a.setY(5);
	}

}
