package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BouncingBall {

	private final static double VELOCITY_STEP = 2.0;

	private int x = (int) ((Math.random() * 100.0) + 100.0);

	private int y = (int) ((Math.random() * 100.0) + 100.0);

	private int vx = (int) ((Math.random() * VELOCITY_STEP) + VELOCITY_STEP);

	private int vy = (int) ((Math.random() * VELOCITY_STEP) + VELOCITY_STEP);

	private int radius = 6;

	private Color color = new Color(255, 0, 0);

	// Keep track of the animation window that will be drawing this ball.
	private AnimationWindow win;

	/**
	 * Constructor.
	 * 
	 * @param win
	 *            Animation window that will be drawing this ball.
	 */
	public BouncingBall(AnimationWindow win) {
		this.win = win;
	}

	/**
	 * @modifies this
	 * @effects Moves the ball according to its velocity. Reflections off walls
	 *          cause the ball to change direction.
	 */
	public void move() {

		x += vx;
		if (x <= radius) {
			x = radius;
			vx = -vx;
		}
		if (x >= win.getWidth() - radius) {
			x = win.getWidth() - radius;
			vx = -vx;
		}

		y += vy;
		if (y <= radius) {
			y = radius;
			vy = -vy;
		}
		if (y >= win.getHeight() - radius) {
			y = win.getHeight() - radius;
			vy = -vy;
		}
	}

	/**
	 * @modifies this
	 * @effects Changes the velocity of the ball by a random amount
	 */
	public void randomBump() {
		vx += (int) ((Math.random() * VELOCITY_STEP) - (VELOCITY_STEP / 2));
		vx = -vx;
		vy += (int) ((Math.random() * VELOCITY_STEP) - (VELOCITY_STEP / 2));
		vy = -vy;
	}

	/**
	 * @modifies the Graphics object <g>.
	 * @effects paints a circle on <g> reflecting the current position of the ball.
	 * @param g
	 *            Graphics context to be used for drawing.
	 */
	public void paint(Graphics g) {

		// the "clip rectangle" is the area of the screen that needs to be
		// modified
		Rectangle clipRect = g.getClipBounds();

		// For this tiny program, testing whether we need to redraw is
		// kind of silly. But when there are lots of objects all over the
		// screen this is a very important performance optimization
		if (clipRect.intersects(this.boundingBox())) {
			g.setColor(color);
			g.fillOval(x - radius, y - radius, radius + radius, radius + radius);
		}
	}

	/**
	 * @return the smallest rectangle that completely covers the current position of
	 *         the ball.
	 */
	public Rectangle boundingBox() {

		// a Rectangle is the x,y for the upper left corner and then the
		// width and height
		return new Rectangle(x - radius - 1, y - radius - 1, radius + radius + 2, radius + radius + 2);
	}
}
