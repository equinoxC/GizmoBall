package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import controller.CrashHandler;
import layout.GamePane;

public class BouncingBall {

	private final static double VELOCITY_STEP = 2.0;

	private int x = (int) ((Math.random() * 100.0) + 100.0);

	private int y = (int) ((Math.random() * 100.0) + 100.0);

	private int vx = (int) ((Math.random() * VELOCITY_STEP) + VELOCITY_STEP);

	private int vy = (int) ((Math.random() * VELOCITY_STEP) + VELOCITY_STEP);

	private int radius = 6;

	private Color color = new Color(255, 0, 0);

	// Keep track of the animation window that will be drawing this ball.
	private GamePane win;

	private static CrashHandler crashHandler;

	private static BouncingBall instance = null;
	/**
	 * Constructor.
	 * 
	 * @param win
	 *            Animation window that will be drawing this ball.
	 */
	private BouncingBall(GamePane win) {
	    this.win = win;
	}

	public static BouncingBall getInstance(){
        assert (instance==null);
        return instance;
    }

	public static BouncingBall getInstanceByWin(GamePane win){
	    if(instance!=null) return instance;
	    else{
	        instance = new BouncingBall(win);
	        crashHandler = new CrashHandler();
	        return instance;
        }
    }
	/**
	 * @modifies this
	 * @effects Moves the ball according to its velocity. Reflections off walls
	 *          cause the ball to change direction.
	 */
	public void move() {

		x += vx;
		if (x <= radius+30) {
			x = radius+30;
			vx = -vx;
		}
		if (x >= 540 - radius) {
			x = 540 - radius;
			vx = -vx;
		}

		y += vy;
		if (y <= radius+30) {
			y = radius+30;
			vy = -vy;
		}
		if (y >= 540 - radius) {
			y = 540 - radius;
			vy = -vy;
		}
		
		String barrier = crashHandler.isCrashed();
		if(barrier!=null)System.out.println("crashed"+barrier);
		if(barrier!=null) crashHandler.handleCrashed(barrier);
		
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

	public int getX() {
		return x/30;
	}

	public int getY() {
		return y/30;
	}

	public int getVx() {
		return vx;
	}

	public int getVy() {
		return vy;
	}

    public GamePane getWin() {
        return win;
    }

    public int getRadius() {
        return radius;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }
}
