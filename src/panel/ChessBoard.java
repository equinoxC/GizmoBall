package panel;

import javax.swing.*;

import chessPieceType.ChessBlackCircle;
import chessPieceType.ChessBlueTriangle;
import chessPieceType.ChessBlueTriangle2;
import chessPieceType.ChessBlueTriangle3;
import chessPieceType.ChessBlueTriangle4;
import chessPieceType.ChessCyanCircle;
import chessPieceType.ChessGrayCircle;
import chessPieceType.ChessGreenCircle;
import chessPieceType.ChessHorizontalFlipper;
import chessPieceType.ChessLeftFlipper;
import chessPieceType.ChessMagentaBar;
import chessPieceType.ChessPiece;
import chessPieceType.ChessPinkCircle;
import chessPieceType.ChessRedRectangular;
import chessPieceType.ChessRightFlipper;
import chessPieceType.ChessYellowBall;
import main.AnimationWindow;
import main.BouncingBall;
import main.ChessPoint;
import main.Rule;

import java.awt.*;
import java.awt.event.*;

public class ChessBoard extends JScrollPane implements MouseListener, MouseMotionListener {
	public ChessPoint point[][];
	public int unitWidth, unitHeight;
	private int x_axis, y_axis;
	private int x, y;
	private boolean move = false;
	public String typeName;
	//private AnimationWindow animationWindow;

	int startX, startY;
	int startI, startJ;
	int endI, endJ;
	Rule rule = null;
	// public MakeChessManual record = null;
	
	
	private static final long serialVersionUID = 3257281448464364082L;

	// Controls how often we redraw
	private static int FRAMES_PER_SECOND = 100;

	private AnimationEventListener eventListener;

	private BouncingBall ball;

	private Timer timer;

	private boolean mode;

	public ChessBoard(int w, int h, int r, int c) {
		super(); // do the standard JPanel setup stuff
		
		ball = new BouncingBall(this);

		// this only initializes the timer, we actually start and stop the
		// timer in the setMode() method
		eventListener = new AnimationEventListener();

		// The first parameter is how often (in milliseconds) the timer
		// should call us back.
		timer = new Timer(1000 / FRAMES_PER_SECOND, eventListener);

		mode = false;
		//add(animationWindow);
		setLayout(null);
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		Color bc = getBackground();
		unitWidth = w;
		unitHeight = h;
		x_axis = r;
		y_axis = c;

		point = new ChessPoint[r + 1][c + 1];

		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				point[i][j] = new ChessPoint(i * unitWidth, j * unitHeight, false);
			}
		}

		rule = new Rule(this, point);
		// record = new MakeChessManual(this, point);
	}
	
	public int getStartI() {
		return startI;
	}
	
	public int getStartJ() {
		return startJ;
	}
	
	public int getEndI() {
		return endI;
	}
	
	public int getEndJ() {
		return endJ;
	}
	
	public ChessPoint getPoint(int a, int b) {
		return point[a][b];
	}
	
	public int getPositionX(int a, int b) {
		return point[a][b].x;
	}
	
	public int getPositionY(int a, int b) {
		return point[a][b].y;
	}

	public void createGreenCircle(String typeName) {
		ChessPiece greenCircle = new ChessGreenCircle(typeName, Color.green, 30, 30, this);
		point[3][5].setPiece(greenCircle, this);
	}

	public void createRedRectangular(String typeName) {
		ChessPiece redRectangular = new ChessRedRectangular(typeName, Color.red, 30, 30, this);
		point[5][5].setPiece(redRectangular, this);
	}
	
	public ChessPiece createBlueTriangle(String typeName) {
		ChessPiece blueTriangle = new ChessBlueTriangle(typeName, Color.blue, 30, 30, this);
		point[7][5].setPiece(blueTriangle, this);
		return blueTriangle;
	}
	
	public ChessPiece createBlueTriangle1(String typeName) {
		ChessPiece blueTriangle = new ChessBlueTriangle(typeName, Color.blue, 30, 30, this);
		return blueTriangle;
	}
	
	public ChessPiece createBlueTriangle2(String typeName) {
		ChessPiece blueTriangle = new ChessBlueTriangle2(typeName, Color.blue, 30, 30, this);
		return blueTriangle;
	}
	
	public ChessPiece createBlueTriangle3(String typeName) {
		ChessPiece blueTriangle = new ChessBlueTriangle3(typeName, Color.blue, 30, 30, this);
		return blueTriangle;
	}
	
	public ChessPiece createBlueTriangle4(String typeName) {
		ChessPiece blueTriangle = new ChessBlueTriangle4(typeName, Color.blue, 30, 30, this);
		return blueTriangle;
	}
	
	public void createCyanCircle(String typeName) {
		ChessPiece cyanCircle = new ChessCyanCircle(typeName, Color.cyan, 30, 30, this);
		point[9][5].setPiece(cyanCircle, this);
	}
	
	public void createPinkCircle(String typeName) {
		ChessPiece pinkCircle = new ChessPinkCircle(typeName, Color.pink, 30, 30, this);
		point[11][5].setPiece(pinkCircle, this);
	}
	
	public void createBlackCircle(String typeName) {
		ChessPiece blackCircle = new ChessBlackCircle(typeName, Color.black, 30, 30, this);
		point[13][5].setPiece(blackCircle, this);
	}
	
	public void createGrayCircle(String typeName) {
		ChessPiece grayCircle = new ChessGrayCircle(typeName, Color.gray, 30, 30, this);
		point[15][5].setPiece(grayCircle, this);
	}
	
	public void createHorizontalFlipper(String typeName) {
		ChessPiece horizontalFlipper = new ChessHorizontalFlipper(typeName, Color.orange, 30, 30, this);
		point[13][8].setPiece(horizontalFlipper, this);
	}
	
	public void createLeftFlipper(String typeName) {
		ChessPiece leftFlipper = new ChessLeftFlipper(typeName, Color.orange, 30, 30, this);
		point[11][8].setPiece(leftFlipper, this);
	}
	
	public void createRightFlipper(String typeName) {
		ChessPiece rightFlipper = new ChessRightFlipper(typeName, Color.orange, 30, 30, this);
		point[9][8].setPiece(rightFlipper, this);
	}
	
	public void createYellowBall(String typeName) {
		ChessPiece yellowBall = new ChessYellowBall(typeName, Color.yellow, 30, 30, this);
		point[6][8].setPiece(yellowBall, this);
	}
	
	public void createMagentaBar(String typeName) {
		ChessPiece magentaBar1 = new ChessMagentaBar(typeName, Color.magenta, 90, 30, this);
		point[14][12].setPiece(magentaBar1, this);
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

	/** 鼠标按下事件 */
	public void mousePressed(MouseEvent e) {
		ChessPiece piece = null;
		Rectangle rect = null;
		if (e.getSource() == this)
			move = false;
		if (move == false) {
			if (e.getSource() instanceof ChessPiece) {
				piece = (ChessPiece) e.getSource();
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

		ChessPiece piece = null;
		if (e.getSource() instanceof ChessPiece) {
			piece = (ChessPiece) e.getSource();

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
		ChessPiece piece = null;
		move = false;
		Rectangle rect = null;
		if (e.getSource() instanceof ChessPiece) {
			piece = (ChessPiece) e.getSource();
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
						boolean ok = rule.movePieceRule(piece, startI, startJ, m, n);
						if (ok) {
							ChessPiece pieceRemoved = point[m][n].getPiece();
							point[m][n].reMovePiece(pieceRemoved, this);
							point[m][n].setPiece(piece, this);
							(point[startI][startJ]).setHasChess(false);
							// record.记录棋谱(piece, startI, startJ, m, n);
							validate();
							repaint();
						} else {
							piece.setLocation(startX, startY);
							(point[startI][startJ]).setHasChess(true);
						}
					}

				} else {

					boolean ok = rule.movePieceRule(piece, startI, startJ, m, n);
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
}
