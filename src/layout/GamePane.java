package layout;

import javax.swing.*;

import barrierPieceType.barrierBlackCircle;
import barrierPieceType.barrierBlueTriangle;
import barrierPieceType.barrierBlueTriangle2;
import barrierPieceType.barrierBlueTriangle3;
import barrierPieceType.barrierBlueTriangle4;
import barrierPieceType.barrierCyanCircle;
import barrierPieceType.barrierGrayCircle;
import barrierPieceType.barrierGreenCircle;
import barrierPieceType.barrierHorizontalFlipper;
import barrierPieceType.barrierLeftFlipper;
import barrierPieceType.barrierMagentaBar;
import barrierPieceType.barrierPiece;
import barrierPieceType.barrierPinkCircle;
import barrierPieceType.barrierRedRectangular;
import barrierPieceType.barrierRightFlipper;
import barrierPieceType.barrierYellowBall;
import entity.BouncingBall;
import entity.Barrier;
import controller.DragRule;

import java.awt.*;
import java.awt.event.*;

public class GamePane extends JScrollPane implements MouseListener, MouseMotionListener, KeyListener {
	public Barrier point[][];
	public int unitWidth, unitHeight;
	private int x_axis, y_axis;
	private int x, y;
	private boolean move = false;
	public String typeName;
	//private AnimationWindow animationWindow;

	int startX, startY;
	int startI, startJ;
	int endI, endJ;
	DragRule dragRule = null;
	// public MakeChessManual record = null;
	
	
	private static final long serialVersionUID = 3257281448464364082L;

	// Controls how often we redraw
	private static int FRAMES_PER_SECOND = 100;

	private AnimationEventListener eventListener;

	private BouncingBall ball;

	private Timer timer;

	private boolean mode;

	public Barrier[][] getPoint() {
		return point;
	}

	public int getX_axis() {
		return x_axis;
	}

	public int getY_axis() {
		return y_axis;
	}

	public GamePane(int w, int h, int r, int c) {
		super(); // do the standard JPanel setup stuff
		
		ball = BouncingBall.getInstanceByWin(this);

		// this only initializes the timer, we actually start and stop the
		// timer in the setMode() method
		eventListener = new AnimationEventListener();

		// The first parameter is how often (in milliseconds) the timer
		// should call us back.
		timer = new Timer(1000 / FRAMES_PER_SECOND, eventListener);

		mode = false;
		setLayout(null);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);
		Color bc = getBackground();
		unitWidth = w;
		unitHeight = h;
		x_axis = r;
		y_axis = c;

		point = new Barrier[r + 1][c + 1];

		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				point[i][j] = new Barrier(i * unitWidth, j * unitHeight, false);
			}
		}

		dragRule = new DragRule(this, point);
	}
	
	public int getStartI() {
		return startI;
	}
	
	public void setStartI(int startI) {
		this.startI = startI;
	}
	
	public int getStartJ() {
		return startJ;
	}
	
	public void setStartJ(int startJ) {
		this.startJ = startJ;
	}
	
	public void setEndI(int endI) {
		this.endI = endI;
	}

	public void setEndJ(int endJ) {
		this.endJ = endJ;
	}

	public int getEndI() {
		return endI;
	}
	
	public int getEndJ() {
		return endJ;
	}
	
	public Barrier getPoint(int a, int b) {
		return point[a][b];
	}
	
	public int getPositionX(int a, int b) {
		return point[a][b].x;
	}
	
	public int getPositionY(int a, int b) {
		return point[a][b].y;
	}

	public Barrier createGreenCircle(String typeName, int x, int y) {
		barrierPiece greenCircle = new barrierGreenCircle(typeName, Color.green, 30, 30, this);
		point[x][y].setPiece(greenCircle, this);
		return point[x][y];
	}
	
	public Barrier createRedRectangular(String typeName, int x, int y) {
		barrierPiece redRectangular = new barrierRedRectangular(typeName, Color.red, 30, 30, this);
		point[x][y].setPiece(redRectangular, this);
		return point[x][y];
	}
	
	public Barrier createBlueTriangle(String typeName, int x, int y) {
		barrierPiece blueTriangle = new barrierBlueTriangle(typeName, Color.blue, 30, 30, this);
		point[x][y].setPiece(blueTriangle, this);
		return point[x][y];
	}
	
	public Barrier createBlueTriangle2(String typeName, int x, int y) {
		barrierPiece blueTriangle2 = new barrierBlueTriangle2(typeName, Color.blue, 30, 30, this);
		point[x][y].setPiece(blueTriangle2, this);
		return point[x][y];
	}
	
	public Barrier createBlueTriangle3(String typeName, int x, int y) {
		barrierPiece blueTriangle3 = new barrierBlueTriangle3(typeName, Color.blue, 30, 30, this);
		point[x][y].setPiece(blueTriangle3, this);
		return point[x][y];
	}
	
	public Barrier createBlueTriangle4(String typeName, int x, int y) {
		barrierPiece blueTriangle4 = new barrierBlueTriangle4(typeName, Color.blue, 30, 30, this);
		point[x][y].setPiece(blueTriangle4, this);
		return point[x][y];
	}
	
	public Barrier createCyanCircle(String typeName, int x, int y) {
		barrierPiece cyanCircle = new barrierCyanCircle(typeName, Color.cyan, 30, 30, this);
		point[x][y].setPiece(cyanCircle, this);
		return point[x][y];
	}
	
	public Barrier createPinkCircle(String typeName, int x, int y) {
		barrierPiece pinkCircle = new barrierPinkCircle(typeName, Color.pink, 30, 30, this);
		point[x][y].setPiece(pinkCircle, this);
		return point[x][y];
	}
	
	public Barrier createBlackCircle(String typeName, int x, int y) {
		barrierPiece blackCircle = new barrierBlackCircle(typeName, Color.black, 30, 30, this);
		point[x][y].setPiece(blackCircle, this);
		return point[x][y];
	}
	
	public Barrier createGrayCircle(String typeName, int x, int y) {
		barrierPiece grayCircle = new barrierGrayCircle(typeName, Color.gray, 30, 30, this);
		point[x][y].setPiece(grayCircle, this);
		return point[x][y];
	}
	
	public Barrier createHorizontalFlipper(String typeName, int x, int y) {
		barrierPiece horizontalFlipper = new barrierHorizontalFlipper(typeName, Color.orange, 30, 30, this);
		point[x][y].setPiece(horizontalFlipper, this);
		return point[x][y];
	}
	
	public Barrier createLeftFlipper(String typeName, int x, int y) {
		barrierPiece leftFlipper = new barrierLeftFlipper(typeName, Color.orange, 30, 30, this);
		point[x][y].setPiece(leftFlipper, this);
		return point[x][y];
	}
	
	public Barrier createRightFlipper(String typeName, int x, int y) {
		barrierPiece rightFlipper = new barrierRightFlipper(typeName, Color.orange, 30, 30, this);
		point[x][y].setPiece(rightFlipper, this);
		return point[x][y];
	}
	
	public Barrier createYellowBall(String typeName, int x, int y) {
		barrierPiece yellowBall = new barrierYellowBall(typeName, Color.yellow, 30, 30, this);
		point[x][y].setPiece(yellowBall, this);
		return point[x][y];
	}
	
	public Barrier createMagentaBar(String typeName, int x, int y) {
		barrierPiece magentaBar = new barrierMagentaBar(typeName, Color.magenta, 90, 30, this);
		point[x][y].setPiece(magentaBar, this);
		return point[x][y];
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
		super.paintComponent(g);

		for (int j = 1; j <= y_axis; j++) {
			g.drawLine(point[1][j].x, point[1][j].y, point[x_axis][j].x, point[x_axis][j].y);
		}
		for (int i = 1; i <= x_axis; i++) {
			g.drawLine(point[i][1].x, point[i][1].y, point[i][y_axis].x, point[i][y_axis].y);
		}
		for (int i = 1; i <= x_axis; i++) {
			g.drawString("" + i, i * unitWidth, unitHeight / 2);
		}
		for (int j = 1; j <= y_axis; j++) {
			g.drawString("" + j, unitWidth / 4, j * unitHeight);
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
		// GizmoBallInterface: mouseClicked, mouseEntered, mouseExited, mousePressed,
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
		 * MouseMotionListener GizmoBallInterface Override this method to act on mouse drag
		 * events.
		 * 
		 * @param e
		 *            Detected MouseEvent
		 */
		public void mouseDragged(MouseEvent e) {
		}

		/**
		 * MouseMotionListener GizmoBallInterface Override this method to act on mouse move
		 * events.
		 * 
		 * @param e
		 *            Detected MouseEvent
		 */
		public void mouseMoved(MouseEvent e) {
		}

		/**
		 * We implement the KeyListener GizmoBallInterface so that we can bump the ball in a
		 * random direction if keys A-J is presse.
		 * 
		 * @modifies the ball that this listener owns
		 * @effects causes the ball to be bumped in a random direction but only if one
		 *          of the keys A-J is pressed.
		 * @param e
		 *            Detected Key Press Event
		 */
		public void keyPressed(KeyEvent e) {
			/*
			int keynum = e.getKeyCode();

			if ((keynum >= 65) && (keynum <= 74)) {
				System.out.println("keypress " + e.getKeyCode());
				ball.randomBump();
			}*/
			/*
			for(int i = 1; i <= x_axis; i++) {
				for(int j = 1; j <= y_axis; j++) {
					Barrier barrier = this.
					if (barrier.getPiece().getName()=="horizontalFlipper") {
						if (e.getKeyCode() == KeyEvent.VK_UP) {
							System.out.println("\n Go Up");
							barrier.setY(barrier.getY()-30);
						} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
							System.out.println("\n Go Down");
							barrier.setY(barrier.getY()+30);
						} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
							System.out.println("\n Go Left");
							barrier.setX(barrier.getX()-30);
						} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
							System.out.println("\n Go Right");
							barrier.setX(barrier.getX()+30);
						} else
							System.out.println(e.getKeyChar());
						repaint();
					}
				}
			}*/
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

	/** 鼠标按下事件 */
	public void mousePressed(MouseEvent e) {
		barrierPiece piece = null;
		Rectangle rect = null;
		if (e.getSource() == this)
			move = false;
		if (move == false) {
			if (e.getSource() instanceof barrierPiece) {
				piece = (barrierPiece) e.getSource();
				startX = piece.getBounds().x;
				startY = piece.getBounds().y;

				rect = piece.getBounds();
				for (int i = 1; i <= x_axis-1; i++) {
					for (int j = 1; j <= y_axis-1; j++) {
						int x = point[i][j].getX();
						int y = point[i][j].getY();
						if (rect.contains(x+unitWidth/2, y+unitHeight/2)) {
							startI = i;
							startJ = j;
							break;
						}

					}
				}
			}
			endI = startX/unitWidth;
			endJ = startY/unitHeight;
		}
	}

	public void mouseMoved(MouseEvent e) {
	}

	/** 鼠标拖动事件 */
	public void mouseDragged(MouseEvent e) {

		barrierPiece piece = null;
		if (e.getSource() instanceof barrierPiece) {
			piece = (barrierPiece) e.getSource();

			move = true;

			e = SwingUtilities.convertMouseEvent(piece, e, this);
		}

		if (e.getSource() == this) {
			if (move && piece != null) {
				x = e.getX();
				y = e.getY();
				piece.setLocation(x - piece.getWidth() / 2, y - piece.getHeight() / 2);
			}
		}
	}

	/** 松开鼠标事件 */
	public void mouseReleased(MouseEvent e) {
		barrierPiece piece = null;
		move = false;
		Rectangle rect = null;
		if (e.getSource() instanceof barrierPiece) {
			piece = (barrierPiece) e.getSource();
			rect = piece.getBounds();

			e = SwingUtilities.convertMouseEvent(piece, e, this);
		}
		if (e.getSource() == this) {
			boolean containChessPoint = false;
			int x = 0, y = 0;
			int m = 0, n = 0;
			if (piece != null) {
				for (int i = 1; i <= x_axis-1; i++) {
					for (int j = 1; j <= y_axis-1; j++) {
						x = point[i][j].getX();
						y = point[i][j].getY();
						if (rect.contains(x+unitWidth/2, y+unitHeight/2)) {

							containChessPoint = true;
							m = i;
							n = j;
							break;
						}

					}
				}
			}
			if (piece != null && containChessPoint) {
				Color pieceColor = piece.getColor();
				if (point[m][n].isPiece()) {
					Color c = (point[m][n].getPiece()).getColor();
					if (pieceColor.getRGB() == c.getRGB()) {
						piece.setLocation(startX, startY);
						(point[startI][startJ]).setHasChess(true);
					} else {
						boolean ok = dragRule.movePieceRule(piece, startI, startJ, m, n);
						if (ok) {
							barrierPiece pieceRemoved = point[m][n].getPiece();
							point[m][n].reMovePiece(pieceRemoved, this);
							point[m][n].setPiece(piece, this);
							(point[startI][startJ]).setHasChess(false);
							validate();
							repaint();
						} else {
							piece.setLocation(startX, startY);
							(point[startI][startJ]).setHasChess(true);
						}
					}

				} else {

					boolean ok = dragRule.movePieceRule(piece, startI, startJ, m, n);
					if (ok) {
						point[m][n].setPiece(piece, this);
						(point[startI][startJ]).setHasChess(false);
					} else {
						piece.setLocation(startX, startY);
						(point[startI][startJ]).setHasChess(true);
					}
				}
			}

			if (piece != null && !containChessPoint) {
				piece.setLocation(startX, startY);
				(point[startI][startJ]).setHasChess(true);
			}
			endI = m;
			endJ = n;
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keynum = e.getKeyCode();

		if ((keynum >= 65) && (keynum <= 74)) {
			System.out.println("keypress " + e.getKeyCode());
			ball.randomBump();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
