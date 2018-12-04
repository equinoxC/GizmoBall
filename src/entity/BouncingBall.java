package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import layout.GamePane;

public class BouncingBall {

	private final static double VELOCITY_STEP = 1.0;

	private int x = (int) ((Math.random() * 100.0) + 100.0);

	private int y = (int) ((Math.random() * 100.0) + 100.0);

	private int vx = (int) ((Math.random() * VELOCITY_STEP) + VELOCITY_STEP);

	private int vy = (int) ((Math.random() * VELOCITY_STEP) + VELOCITY_STEP);

	private int radius = 6;

	private Color color = new Color(255, 0, 0);

	// Keep track of the animation window that will be drawing this ball.
	private GamePane win;

	/**
	 * Constructor.
	 * 
	 * @param win
	 *            Animation window that will be drawing this ball.
	 */
	public BouncingBall(GamePane win) {
		this.win = win;
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
		
		if(x/30 != 0 && y/30 != 0) {
			if(win.getPoint(x/30, y/30).isPiece()) {
				int temp_x = win.getPoint(x/30, y/30).getX();
				int temp_y = win.getPoint(x/30, y/30).getY();
				int ballx = x+radius;
				int bally = y+radius;
				if(win.getPoint(x/30, y/30).getPiece().getName()=="greenCircle") {
					if ((ballx-temp_x-15)*(ballx-temp_x-15)+(bally-temp_y-15)*(bally-temp_y-15)<=(radius+15)*(radius+15)) {
						vx = -vx;
						vy = -vy;
					}
				} else if(win.getPoint(x/30, y/30).getPiece().getName()=="redRectangular") {
					if (ballx>=temp_x-radius&&ballx<=temp_x+30+radius&&bally>=temp_y-radius&&bally<=temp_y+30+radius) {
						vx = -vx;
						vy = -vy;
					}
				} else if(win.getPoint(x/30, y/30).getPiece().getName()=="blueTriangle") {
					double la = Math.sqrt((ballx-temp_x)*(ballx-temp_x)+(bally-temp_y)*(bally-temp_y));
					double lb = Math.sqrt((ballx-temp_x-30)*(ballx-temp_x-30)+(bally-temp_y)*(bally-temp_y));
					double lc = Math.sqrt((ballx-temp_x)*(ballx-temp_x)+(bally-temp_y-30)*(bally-temp_y-30));
					double Pab = (la+lb+30)/2;
					double Sab = Math.sqrt(Pab*(Pab-la)*(Pab-lb)*(Pab-30));
					double Pac = (la+lc+30)/2;
					double Sac = Math.sqrt(Pac*(Pac-la)*(Pac-lc)*(Pac-30));
					double Pbc = (lb+lc+30*1.414)/2;
					double Sbc = Math.sqrt(Pbc*(Pbc-lb)*(Pbc-lc)*(Pbc-30*1.414));
					double hab = 2*Sab/30;
					double hac = 2*Sac/30;
					double hbc = 2*Sbc/(1.414*30);
					System.out.println("1::hab="+hab+"hac"+hac+"hbc"+hbc);
					if (hab<=radius || hac<=radius || hbc<=radius) {
						vx = -vx;
						vy = -vy;
					}
				} else if(win.getPoint(x/30, y/30).getPiece().getName()=="blueTriangle2") {
					double la = Math.sqrt((ballx-temp_x-30)*(ballx-temp_x-30)+(bally-temp_y)*(bally-temp_y));
					double lb = Math.sqrt((ballx-temp_x)*(ballx-temp_x)+(bally-temp_y)*(bally-temp_y));
					double lc = Math.sqrt((ballx-temp_x-30)*(ballx-temp_x-30)+(bally-temp_y-30)*(bally-temp_y-30));
					double Pab = (la+lb+30)/2;
					double Sab = Math.sqrt(Pab*(Pab-la)*(Pab-lb)*(Pab-30));
					double Pac = (la+lc+30)/2;
					double Sac = Math.sqrt(Pac*(Pac-la)*(Pac-lc)*(Pac-30));
					double Pbc = (lb+lc+30*1.414)/2;
					double Sbc = Math.sqrt(Pbc*(Pbc-lb)*(Pbc-lc)*(Pbc-30*1.414));
					double hab = 2*Sab/30;
					double hac = 2*Sac/30;
					double hbc = 2*Sbc/(1.414*30);
					System.out.println("2::hab="+hab+"hac"+hac+"hbc"+hbc);
					if (hab<=radius || hac<=radius || hbc<=radius) {
						vx = -vx;
						vy = -vy;
					}
				} else if(win.getPoint(x/30, y/30).getPiece().getName()=="blueTriangle3") {
					double la = Math.sqrt((ballx-temp_x-30)*(ballx-temp_x-30)+(bally-temp_y-30)*(bally-temp_y-30));
					double lb = Math.sqrt((ballx-temp_x)*(ballx-temp_x)+(bally-temp_y-30)*(bally-temp_y-30));
					double lc = Math.sqrt((ballx-temp_x-30)*(ballx-temp_x-30)+(bally-temp_y)*(bally-temp_y));
					double Pab = (la+lb+30)/2;
					double Sab = Math.sqrt(Pab*(Pab-la)*(Pab-lb)*(Pab-30));
					double Pac = (la+lc+30)/2;
					double Sac = Math.sqrt(Pac*(Pac-la)*(Pac-lc)*(Pac-30));
					double Pbc = (lb+lc+30*1.414)/2;
					double Sbc = Math.sqrt(Pbc*(Pbc-lb)*(Pbc-lc)*(Pbc-30*1.414));
					double hab = 2*Sab/30;
					double hac = 2*Sac/30;
					double hbc = 2*Sbc/(1.414*30);
					System.out.println("3::hab="+hab+"hac"+hac+"hbc"+hbc);
					if (hab<=radius || hac<=radius || hbc<=radius) {
						vx = -vx;
						vy = -vy;
					}
				} else if(win.getPoint(x/30, y/30).getPiece().getName()=="blueTriangle4") {
					double la = Math.sqrt((ballx-temp_x)*(ballx-temp_x)+(bally-temp_y-30)*(bally-temp_y-30));
					double lb = Math.sqrt((ballx-temp_x)*(ballx-temp_x)+(bally-temp_y)*(bally-temp_y));
					double lc = Math.sqrt((ballx-temp_x-30)*(ballx-temp_x-30)+(bally-temp_y-30)*(bally-temp_y-30));
					double Pab = (la+lb+30)/2;
					double Sab = Math.sqrt(Pab*(Pab-la)*(Pab-lb)*(Pab-30));
					double Pac = (la+lc+30)/2;
					double Sac = Math.sqrt(Pac*(Pac-la)*(Pac-lc)*(Pac-30));
					double Pbc = (lb+lc+30*1.414)/2;
					double Sbc = Math.sqrt(Pbc*(Pbc-lb)*(Pbc-lc)*(Pbc-30*1.414));
					double hab = 2*Sab/30;
					double hac = 2*Sac/30;
					double hbc = 2*Sbc/(1.414*30);
					System.out.println("4::hab="+hab+"hac"+hac+"hbc"+hbc);
					if (hab<=radius || hac<=radius || hbc<=radius) {
						vx = -vx;
						vy = -vy;
					}
				} else if(win.getPoint(x/30, y/30).getPiece().getName()=="cyanCircle") {
					if ((ballx-temp_x-15)*(ballx-temp_x-15)+(bally-temp_y-15)*(bally-temp_y-15)<=(radius+15)*(radius+15)) {
						vx = -vx;
						vy = -vy;
					}
				} else if(win.getPoint(x/30, y/30).getPiece().getName()=="pinkCircle") {
					if ((ballx-temp_x-15)*(ballx-temp_x-15)+(bally-temp_y-15)*(bally-temp_y-15)<=(radius+15)*(radius+15)) {
						vx = -vx;
						vy = -vy;
					}
				} else if(win.getPoint(x/30, y/30).getPiece().getName()=="blackCircle") {
					if ((ballx-temp_x-15)*(ballx-temp_x-15)+(bally-temp_y-15)*(bally-temp_y-15)<=(radius+15)*(radius+15)) {
						vx = -vx;
						vy = -vy;
					}
				} else if(win.getPoint(x/30, y/30).getPiece().getName()=="grayCircle") {
					if ((ballx-temp_x-15)*(ballx-temp_x-15)+(bally-temp_y-15)*(bally-temp_y-15)<=(radius+15)*(radius+15)) {
						vx = -vx;
						vy = -vy;
					}
				}
			}
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
