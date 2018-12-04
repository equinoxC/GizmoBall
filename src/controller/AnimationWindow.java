package controller;

import entity.BouncingBall;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.Timer;


public class AnimationWindow extends JComponent {

	private static final long serialVersionUID = 3257281448464364082L;

	// Controls how often we redraw
	private static int FRAMES_PER_SECOND = 100;

	private AnimationEventListener eventListener;

	private BouncingBall ball;

	private Timer timer;

	private boolean mode;

	/**
	 * @effects initializes this to be in the off mode.
	 */
	public AnimationWindow() {

		super(); // do the standard JPanel setup stuff

		//ball = new BouncingBall(this);

		// this only initializes the timer, we actually start and stop the
		// timer in the setMode() method
		eventListener = new AnimationEventListener();

		// The first parameter is how often (in milliseconds) the timer
		// should call us back.
		timer = new Timer(1000 / FRAMES_PER_SECOND, eventListener);

		mode = false;
	}

	/**
	 * @modifies g
	 * @effects Repaints the Graphics area g. Swing will then send the newly painted
	 *          g to the screen.
	 * @param g
	 *            Graphics context received by either system or app calling
	 *            repaint()
	 */
	public void paintComponent(Graphics g) {
		// first repaint the proper background color (controlled by
		// the windowing system)
		// super.paintComponent(g);
		int w;// 横坐标
		int h;// 纵坐标
		h = 0;
		w = 0;
		for (int i = 1; i <= 540; i = i+30) {
			for (int j = 1; j <= 540; j = j+30) {
				g.setColor(Color.black);
				g.drawRect(w, h, 30, 30);
				w = w+30;
			}
			h = h+30;
			w = 0;
		}
		
		ball.paint(g);
	}
	
	/**
	 * This method is called when the Timer goes off and we need to move and repaint
	 * the ball.
	 * 
	 * @modifies both the ball and the window that this listener owns
	 * @effects causes the ball to move and the window to be updated to show the new
	 *          position of the ball.
	 */
	private void update() {
		Rectangle oldPos = ball.boundingBox();

		ball.move(); // make changes to the logical animation state

		Rectangle repaintArea = oldPos.union(ball.boundingBox());

		// Have Swing tell the AnimationWindow to run its paint()
		// method. One could also call repaint(), but this would
		// repaint the entire window as opposed to only the portion that
		// has changed.
		repaint(repaintArea.x, repaintArea.y, repaintArea.width, repaintArea.height);

	}

	/**
	 * @modifies this
	 * @effects Turns the animation on/off.
	 * @param m
	 *            Boolean indicating if animation is on/off
	 */
	public void setMode(boolean m) {

		if (mode == m) {
			// Nothing to do.
			return;
		}

		if (mode == true) {
			// we're about to change mode: turn off all the old listeners
			removeMouseListener(eventListener);
			removeMouseMotionListener(eventListener);
			removeKeyListener(eventListener);
		}

		mode = m;

		if (mode == true) {
			// the mode is true: turn on the listeners
			addMouseListener(eventListener);
			addMouseMotionListener(eventListener);
			addKeyListener(eventListener);
			requestFocus(); // make sure keyboard is directed to us
			timer.start();
		} else {
			timer.stop();
		}
	}

	/**
	 * Overview: AnimationEventListener is an inner class that responds to all sorts
	 * of external events, and provides the required semantic operations for our
	 * particular program. It owns, and sends semantic actions to the ball and
	 * window of the outer class
	 */
	class AnimationEventListener extends MouseAdapter implements MouseMotionListener, KeyListener, ActionListener {

		// MouseAdapter gives us empty methods for the MouseListener
		// interface: mouseClicked, mouseEntered, mouseExited, mousePressed,
		// and mouseReleased.

		/**
		 * For this example we only need to override mouseClicked
		 * 
		 * @modifes the ball that this listener owns
		 * @effects causes the ball to be bumped in a random direction
		 * @param e
		 *            Detected MouseEvent
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			ball.randomBump();
		}

		/**
		 * MouseMotionListener interface Override this method to act on mouse drag
		 * events.
		 * 
		 * @param e
		 *            Detected MouseEvent
		 */
		public void mouseDragged(MouseEvent e) {
		}

		/**
		 * MouseMotionListener interface Override this method to act on mouse move
		 * events.
		 * 
		 * @param e
		 *            Detected MouseEvent
		 */
		public void mouseMoved(MouseEvent e) {
		}

		/**
		 * We implement the KeyListener interface so that we can bump the ball in a
		 * random direction if keys A-J is presse.
		 * 
		 * @modifies the ball that this listener owns
		 * @effects causes the ball to be bumped in a random direction but only if one
		 *          of the keys A-J is pressed.
		 * @param e
		 *            Detected Key Press Event
		 */
		public void keyPressed(KeyEvent e) {
			//
			int keynum = e.getKeyCode();

			if ((keynum >= 65) && (keynum <= 74)) {
				System.out.println("keypress " + e.getKeyCode());
				ball.randomBump();
			}
		}

		/**
		 * Do nothing.
		 * 
		 * @param e
		 *            Detected Key Released Event
		 */
		public void keyReleased(KeyEvent e) {
		}

		/**
		 * Do nothing.
		 * 
		 * @param e
		 *            Detected Key Typed Event
		 */
		public void keyTyped(KeyEvent e) {
		}

		/**
		 * This is the callback for the timer
		 * 
		 * @param e
		 *            ActionEvent generated by timer
		 */
		public void actionPerformed(ActionEvent e) {
			update();
		}
	}
}
