package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import buttonIcon.AbsorbButtonIcon;
import buttonIcon.BallButtonIcon;
import buttonIcon.CircleButtonIcon;
import buttonIcon.DeleteIcon;
import buttonIcon.DirectionIcon;
import buttonIcon.FlipperHorizontalIcon;
import buttonIcon.FlipperLeftIcon;
import buttonIcon.FlipperRightIcon;
import buttonIcon.GizmoIcon;
import buttonIcon.KeyDownIcon;
import buttonIcon.KeyUpIcon;
import buttonIcon.RotateIcon;
import buttonIcon.SquareButtonIcon;
import buttonIcon.TriangleButtonIcon;
import controller.IOHandler;
import entity.Barrier;
import entity.BarrierWrapper;
import barrierPieceType.barrierBlueTriangle;
import barrierPieceType.barrierBlueTriangle2;
import barrierPieceType.barrierBlueTriangle3;
import barrierPieceType.barrierBlueTriangle4;
import barrierPieceType.barrierHorizontalFlipper;
import barrierPieceType.barrierHorizontalFlipperUp;
import barrierPieceType.barrierLeftFlipper;
import barrierPieceType.barrierPiece;
import barrierPieceType.barrierRightFlipper;

/**
 * Overview: An ApplicationWindow is a top level program window that contains a
 * toolbar and an animation window.
 */
public class RootLayout extends JFrame implements KeyListener {

	private static final long serialVersionUID = 3257563992905298229L;

	private JPanel buttonPanel;
	private GamePane gamePanel;
	JButton cb_green = null;
	JButton sb_red = null;
	JButton tb_blue = null;
	JButton cb_cyan = null;
	JButton cb_pink = null;
	JButton cb_black = null;
	JButton cb_gray = null;
	JButton fhg = null;
	JButton frg = null;
	JButton flg = null;
	JButton bb_yellow = null;
	JButton ab_magenta = null;
	JButton lk_down = null;
	JButton lk_up = null;
	JButton lg = null;
	JButton dg = null;
	JButton rg = null;
	JButton drg = null;

	Barrier barrier = null;
	IOHandler ioHandler = null;

	int type = 0;

	/**
	 * @effects Initializes the application window so that it contains a toolbar and
	 *          an animation window.
	 */
	public RootLayout() {

		// Title bar
		super("Swing Demonstration Program");

		// respond to the window system asking us to quit
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// Create the toolbar.
		JToolBar toolBar = new JToolBar();
		addButtons(toolBar);

		// Create the animation area used for output.
		// animationWindow = new AnimationWindow();
		// Put it in a scrollPane, (this makes a border)
		// gamePanel = new GamePane(animationWindow);
		gamePanel = new GamePane(30, 30, 18, 18);
		// gamePanel.add(animationWindow);
		// Lay out the content pane.
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.setPreferredSize(new Dimension(655, 585));
		contentPane.add(toolBar, BorderLayout.NORTH);
		contentPane.add(gamePanel, BorderLayout.CENTER);

		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(100, 400));

		Icon cbbs_green = new CircleButtonIcon(Color.green);
		cb_green = new JButton(cbbs_green);
		cb_green.setPreferredSize(new Dimension(30, 30));
		cb_green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barrier = gamePanel.createGreenCircle("greenCircle", 3, 5);
			}
		});
		cb_green.setActionCommand("Circle");

		Icon sbbs_red = new SquareButtonIcon(Color.red);
		sb_red = new JButton(sbbs_red);
		sb_red.setPreferredSize(new Dimension(30, 30));
		sb_red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barrier = gamePanel.createRedRectangular("redRectangular", 5, 5);
			}
		});
		sb_red.setActionCommand("Square");

		Icon tbbs_blue = new TriangleButtonIcon(Color.blue);
		tb_blue = new JButton(tbbs_blue);
		tb_blue.setPreferredSize(new Dimension(30, 30));
		tb_blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barrier = gamePanel.createBlueTriangle("blueTriangle", 7, 5);
				gamePanel.setStartI(0);
				gamePanel.setStartJ(0);
				gamePanel.setEndI(0);
				gamePanel.setEndJ(0);
				type = 0;
			}
		});
		tb_blue.setActionCommand("Triangle");

		Icon cbbs_cyan = new CircleButtonIcon(Color.cyan);
		cb_cyan = new JButton(cbbs_cyan);
		cb_cyan.setPreferredSize(new Dimension(30, 30));
		cb_cyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barrier = gamePanel.createCyanCircle("cyanCircle", 9, 5);
			}
		});
		cb_cyan.setActionCommand("Circle");

		Icon cbbs_pink = new CircleButtonIcon(Color.pink);
		cb_pink = new JButton(cbbs_pink);
		cb_pink.setPreferredSize(new Dimension(30, 30));
		cb_pink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barrier = gamePanel.createPinkCircle("pinkCircle", 11, 5);
			}
		});
		cb_pink.setActionCommand("Circle");

		Icon cbbs_black = new CircleButtonIcon(Color.black);
		cb_black = new JButton(cbbs_black);
		cb_black.setPreferredSize(new Dimension(30, 30));
		cb_black.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barrier = gamePanel.createBlackCircle("blackCircle", 13, 5);
			}
		});
		cb_black.setActionCommand("Circle");

		Icon cbbs_gray = new CircleButtonIcon(Color.gray);
		cb_gray = new JButton(cbbs_gray);
		cb_gray.setPreferredSize(new Dimension(30, 30));
		cb_gray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barrier = gamePanel.createGrayCircle("grayCircle", 15, 5);
			}
		});
		cb_gray.setActionCommand("Circle");

		Icon fhbs = new FlipperHorizontalIcon(Color.gray);
		fhg = new JButton(fhbs);
		fhg.setPreferredSize(new Dimension(30, 30));
		fhg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barrier = gamePanel.createHorizontalFlipper("horizontalFlipper", 13, 8);
			}
		});
		fhg.setActionCommand("HorizontalFlipper");

		Icon frbs = new FlipperRightIcon(Color.gray);
		frg = new JButton(frbs);
		frg.setPreferredSize(new Dimension(30, 30));
		frg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barrier = gamePanel.createRightFlipper("rightFlipper", 11, 8);
			}
		});
		frg.setActionCommand("RightFlipper");

		Icon flbs = new FlipperLeftIcon(Color.gray);
		flg = new JButton(flbs);
		flg.setPreferredSize(new Dimension(30, 30));
		flg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barrier = gamePanel.createLeftFlipper("leftFlipper", 9, 8);
			}
		});
		flg.setActionCommand("LeftFlipper");

		Icon bbbs_yellow = new BallButtonIcon(Color.yellow);
		bb_yellow = new JButton(bbbs_yellow);
		bb_yellow.setPreferredSize(new Dimension(30, 30));
		bb_yellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barrier = gamePanel.createYellowBall("yellowBall", 6, 8);
			}
		});
		bb_yellow.setActionCommand("Ball");

		Icon abbs_magenta = new AbsorbButtonIcon(Color.magenta);
		ab_magenta = new JButton(abbs_magenta);
		ab_magenta.setPreferredSize(new Dimension(68, 30));
		ab_magenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barrier = gamePanel.createMagentaBar("magentaBar", 14, 12);
			}
		});
		ab_magenta.setActionCommand("Absorber");

		Icon lkbs_down = new KeyDownIcon(Color.gray);
		lk_down = new JButton(lkbs_down);
		lk_down.setPreferredSize(new Dimension(68, 30));
		// lk.addActionListener(this.listener);
		lk_down.setActionCommand("Key_Down");

		Icon lkbs_up = new KeyUpIcon(Color.gray);
		lk_up = new JButton(lkbs_up);
		lk_up.setPreferredSize(new Dimension(68, 30));
		// lk.addActionListener(this.listener);
		lk_up.setActionCommand("Key_Up");

		Icon glbs = new GizmoIcon(Color.gray);
		lg = new JButton(glbs);
		lg.setPreferredSize(new Dimension(68, 30));
		lg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamePanel.setMode(true);
			}
		});
		lg.setActionCommand("GizmoLink");

		Icon dbbs = new DeleteIcon(Color.gray);
		dg = new JButton(dbbs);
		dg.setPreferredSize(new Dimension(30, 30));
		dg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = gamePanel.getGraphics();
				int a = gamePanel.getStartI();
				int b = gamePanel.getStartJ();
				int m = gamePanel.getEndI();
				int n = gamePanel.getEndJ();
				System.out.println("a=" + a);
				System.out.println("b=" + b);
				System.out.println("m=" + m);
				System.out.println("n=" + n);
				int x = barrier.getX();
				int y = barrier.getY();
				System.out.println("x=" + x);
				System.out.println("y=" + y);
				if (barrier != null && a == 0 && b == 0 && m == 0 && n == 0) {
					g.setColor(Color.black);
					g.drawRect(x, y, 30, 30);
					barrierPiece pieceRemoved = gamePanel.getPoint(x / 30, y / 30).getPiece();
					gamePanel.getPoint(x / 30, y / 30).reMovePiece(pieceRemoved, gamePanel);
					(gamePanel.getPoint(x / 30, y / 30)).setHasChess(false);
					validate();
					repaint();
				} else if (barrier != null && a != 0 && b != 0 && m != 0 && n != 0) {
					g.setColor(Color.black);
					g.drawRect(x, y, 30, 30);
					barrierPiece pieceRemoved = gamePanel.getPoint(m, n).getPiece();
					gamePanel.getPoint(m, n).reMovePiece(pieceRemoved, gamePanel);
					if (a != m || b != n) {
						(gamePanel.getPoint(a, b)).setHasChess(false);
					}
					a = m;
					b = n;
					validate();
					repaint();
				}
			}
		});
		dg.setActionCommand("Delete");

		Icon rgbs = new RotateIcon(Color.gray);
		rg = new JButton(rgbs);
		rg.setPreferredSize(new Dimension(30, 30));
		rg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (barrier != null && (barrier.getPiece().getName().equals("blueTriangle")
						|| barrier.getPiece().getName().equals("blueTriangle2")
						|| barrier.getPiece().getName().equals("blueTriangle3")
						|| barrier.getPiece().getName().equals("blueTriangle4"))) {
					int a = gamePanel.getStartI();
					int b = gamePanel.getStartJ();
					int m = gamePanel.getEndI();
					int n = gamePanel.getEndJ();
					System.out.println("a=" + a);
					System.out.println("b=" + b);
					System.out.println("m=" + m);
					System.out.println("n=" + n);
					int x = barrier.getX();
					int y = barrier.getY();
					System.out.println("getStartI()=" + gamePanel.getStartI());
					System.out.println("getStartJ()=" + gamePanel.getStartJ());
					System.out.println("getEndI()=" + gamePanel.getEndI());
					System.out.println("getEndJ()=" + gamePanel.getEndJ());
					if (barrier != null && gamePanel.getStartI() == 0 && gamePanel.getStartJ() == 0
							&& gamePanel.getEndI() == 0 && gamePanel.getEndJ() == 0) {
						barrierPiece pieceRemoved = gamePanel.getPoint(x / 30, y / 30).getPiece();
						gamePanel.getPoint(x / 30, y / 30).reMovePiece(pieceRemoved, gamePanel);
						type++;
						barrierPiece temp = null;
						if (type % 4 == 1) {
							temp = new barrierBlueTriangle2("blueTriangle2", Color.blue, 30, 30, gamePanel);
							barrier.setPiece(temp);
						} else if (type % 4 == 2) {
							temp = new barrierBlueTriangle3("blueTriangle3", Color.blue, 30, 30, gamePanel);
							barrier.setPiece(temp);
						} else if (type % 4 == 3) {
							temp = new barrierBlueTriangle4("blueTriangle4", Color.blue, 30, 30, gamePanel);
							barrier.setPiece(temp);
						} else if (type % 4 == 0) {
							temp = new barrierBlueTriangle("blueTriangle", Color.blue, 30, 30, gamePanel);
							barrier.setPiece(temp);
						}
						gamePanel.getPoint(x / 30, y / 30).setPiece(temp, gamePanel);
						validate();
						repaint();
					} else if (barrier != null && gamePanel.getStartI() != 0 && gamePanel.getStartJ() != 0
							&& gamePanel.getEndI() != 0 && n != 0) {
						barrierPiece pieceRemoved = gamePanel.getPoint(m, n).getPiece();
						gamePanel.getPoint(m, n).reMovePiece(pieceRemoved, gamePanel);
						type++;
						barrierPiece temp = null;
						if (type % 4 == 1) {
							temp = new barrierBlueTriangle2("blueTriangle2", Color.blue, 30, 30, gamePanel);
							barrier.setPiece(temp);
						} else if (type % 4 == 2) {
							temp = new barrierBlueTriangle3("blueTriangle3", Color.blue, 30, 30, gamePanel);
							barrier.setPiece(temp);
						} else if (type % 4 == 3) {
							temp = new barrierBlueTriangle4("blueTriangle4", Color.blue, 30, 30, gamePanel);
							barrier.setPiece(temp);
						} else if (type % 4 == 0) {
							temp = new barrierBlueTriangle("blueTriangle", Color.blue, 30, 30, gamePanel);
							barrier.setPiece(temp);
						}
						gamePanel.getPoint(m, n).setPiece(temp, gamePanel);
						if (a != m || b != n) {
							(gamePanel.getPoint(a, b)).setHasChess(false);
						}
						a = m;
						b = n;
						validate();
						repaint();
					}
				}
			}
		});
		rg.setActionCommand("Rotate");

		Icon dgbs = new DirectionIcon(Color.gray);
		drg = new JButton(dgbs);
		drg.setPreferredSize(new Dimension(30, 30));
		// rg.addActionListener(this.listener);
		drg.setActionCommand("Direction");

		buttonPanel.add(cb_green);
		buttonPanel.add(sb_red);
		buttonPanel.add(tb_blue);
		buttonPanel.add(cb_cyan);
		buttonPanel.add(cb_pink);
		buttonPanel.add(cb_black);
		buttonPanel.add(cb_gray);
		buttonPanel.add(fhg);
		buttonPanel.add(frg);
		buttonPanel.add(flg);
		buttonPanel.add(bb_yellow);
		buttonPanel.add(ab_magenta);
		buttonPanel.add(lk_down);
		buttonPanel.add(lk_up);
		buttonPanel.add(lg);
		buttonPanel.add(dg);
		buttonPanel.add(rg);
		buttonPanel.add(drg);

		contentPane.add(buttonPanel, BorderLayout.EAST);
		setContentPane(contentPane);

		setFocusable(true);

		gamePanel.addKeyListener(this);
	}

	/**
	 * @modifies toolBar
	 * @effects adds Run, Stop and Quit buttons to toolBar
	 * @param toolBar
	 *            toolbar to add buttons to.
	 */
	protected void addButtons(JToolBar toolBar) {

		JButton button = null;

		button = new JButton("Run");
		button.setToolTipText("Start the animation");
		// when this button is pushed it calls animationWindow.setMode(true)
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamePanel.setMode(true);
			}
		});
		toolBar.add(button);

		button = new JButton("Stop");
		button.setToolTipText("Stop the animation");
		// when this button is pushed it calls animationWindow.setMode(false)
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamePanel.setMode(false);
			}
		});
		toolBar.add(button);

		button = new JButton("Quit");
		button.setToolTipText("Quit the program");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		toolBar.add(button);

		button = new JButton("Save");
		button.setToolTipText("Save the animation to local file system");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ioHandler = new IOHandler();
				ioHandler.saveFile();
			}
		});
		toolBar.add(button);

		button = new JButton("Load");
		button.setToolTipText("Load the animation from local file system");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ioHandler = new IOHandler();
				ArrayList<BarrierWrapper> loadBarrier = ioHandler.loadFile();
				System.out.println(loadBarrier.size());
				for (BarrierWrapper barrierWrapper : loadBarrier) {
					System.out.println(barrierWrapper.getName());
					if (barrierWrapper.getName() == "greenCircle") {
						gamePanel.createGreenCircle("greenCircle", barrierWrapper.getX(), barrierWrapper.getY());
					} else if (barrierWrapper.getName() == "redRectangular") {
						gamePanel.createRedRectangular("redRectangular", barrierWrapper.getX(), barrierWrapper.getY());
					} else if (barrierWrapper.getName() == "blueTriangle") {
						gamePanel.createBlueTriangle("blueTriangle", barrierWrapper.getX(), barrierWrapper.getY());
					} else if (barrierWrapper.getName() == "blueTriangle2") {
						gamePanel.createBlueTriangle2("blueTriangle2", barrierWrapper.getX(), barrierWrapper.getY());
					} else if (barrierWrapper.getName() == "blueTriangle3") {
						gamePanel.createBlueTriangle3("blueTriangle3", barrierWrapper.getX(), barrierWrapper.getY());
					} else if (barrierWrapper.getName() == "blueTriangle4") {
						gamePanel.createBlueTriangle4("blueTriangle4", barrierWrapper.getX(), barrierWrapper.getY());
					} else if (barrierWrapper.getName() == "cyanCircle") {
						gamePanel.createCyanCircle("cyanCircle", barrierWrapper.getX(), barrierWrapper.getY());
					} else if (barrierWrapper.getName() == "pinkCircle") {
						gamePanel.createPinkCircle("pinkCircle", barrierWrapper.getX(), barrierWrapper.getY());
					} else if (barrierWrapper.getName() == "blackCircle") {
						gamePanel.createBlackCircle("blackCircle", barrierWrapper.getX(), barrierWrapper.getY());
					} else if (barrierWrapper.getName() == "grayCircle") {
						gamePanel.createGrayCircle("grayCircle", barrierWrapper.getX(), barrierWrapper.getY());
					} else if (barrierWrapper.getName() == "horizontalFlipper") {
						gamePanel.createHorizontalFlipper("horizontalFlipper", barrierWrapper.getX(),
								barrierWrapper.getY());
					} else if (barrierWrapper.getName() == "rightFlipper") {
						gamePanel.createRightFlipper("rightFlipper", barrierWrapper.getX(), barrierWrapper.getY());
					} else if (barrierWrapper.getName() == "leftFlipper") {
						gamePanel.createLeftFlipper("leftFlipper", barrierWrapper.getX(), barrierWrapper.getY());
					} else if (barrierWrapper.getName() == "yellowBall") {
						gamePanel.createYellowBall("yellowBall", barrierWrapper.getX(), barrierWrapper.getY());
					} else if (barrierWrapper.getName() == "magentaBar") {
						gamePanel.createMagentaBar("magentaBar", barrierWrapper.getX(), barrierWrapper.getY());
					}
				}
			}
		});
		toolBar.add(button);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Barrier[][] barrier1 = gamePanel.getPoint();
		Barrier barrier2 = null;
		int x_axis = gamePanel.getX_axis();
		int y_axis = gamePanel.getY_axis();
		int flag = 0;
		int x = 0, y = 0;
		int i = 1, j = 1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			outer:
				for (i = 1; i <= x_axis; i++) {
					for (j = 1; j <= y_axis; j++) {
						barrier2 = barrier1[i][j];
						if (barrier2.isPiece() && barrier2.getPiece().getName() == "leftFlipper") {
							flag = 1;
							System.out.println("flag="+flag);
							break outer;
						}
					}
				}
			if (flag == 1) {
				x = i;
				y = j;
				System.out.println("x=" + x);
				System.out.println("y=" + y);
				barrierPiece pieceRemoved = gamePanel.getPoint(x, y).getPiece();
				gamePanel.getPoint(x, y).reMovePiece(pieceRemoved, gamePanel);
				barrierPiece temp = new barrierHorizontalFlipperUp("horizontalFlipperUpRight", Color.orange, 30, 30, gamePanel);
				barrier2.setPiece(temp);
				gamePanel.getPoint(x, y).setPiece(temp, gamePanel);
				validate();
				repaint();
			}
			System.out.println("Go Right\n");
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			outer:
				for (i = 1; i <= x_axis; i++) {
					for (j = 1; j <= y_axis; j++) {
						barrier2 = barrier1[i][j];
						if (barrier2.isPiece() && barrier2.getPiece().getName() == "rightFlipper") {
							flag = 2;
							System.out.println("flag="+flag);
							break outer;
						}
					}
				}
			if (flag == 2) {
				x = i;
				y = j;
				System.out.println("x=" + x);
				System.out.println("y=" + y);
				barrierPiece pieceRemoved = gamePanel.getPoint(x, y).getPiece();
				gamePanel.getPoint(x, y).reMovePiece(pieceRemoved, gamePanel);
				barrierPiece temp = new barrierHorizontalFlipperUp("horizontalFlipperUpLeft", Color.orange, 30, 30, gamePanel);
				barrier2.setPiece(temp);
				gamePanel.getPoint(x, y).setPiece(temp, gamePanel);
				validate();
				repaint();
			}
			System.out.println("Go Left\n");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		Barrier[][] barrier1 = gamePanel.getPoint();
		Barrier barrier2 = null;
		int x_axis = gamePanel.getX_axis();
		int y_axis = gamePanel.getY_axis();
		int flag = 0;
		int x = 0, y = 0;
		int i = 1, j = 1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			outer:
				for (i = 1; i <= x_axis; i++) {
					for (j = 1; j <= y_axis; j++) {
						barrier2 = barrier1[i][j];
						if (barrier2.isPiece() && barrier2.getPiece().getName() == "horizontalFlipperUpRight") {
							flag = 1;
							System.out.println("flag="+flag);
							break outer;
						}
					}
				}
			if (flag == 1) {
				x = i;
				y = j;
				System.out.println("x=" + x);
				System.out.println("y=" + y);
				barrierPiece pieceRemoved = gamePanel.getPoint(x, y).getPiece();
				gamePanel.getPoint(x, y).reMovePiece(pieceRemoved, gamePanel);
				barrierPiece temp = new barrierLeftFlipper("leftFlipper", Color.orange, 30, 30, gamePanel);
				barrier2.setPiece(temp);
				gamePanel.getPoint(x, y).setPiece(temp, gamePanel);
				validate();
				repaint();
			}
			System.out.println("Go Right\n");
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			outer:
				for (i = 1; i <= x_axis; i++) {
					for (j = 1; j <= y_axis; j++) {
						barrier2 = barrier1[i][j];
						if (barrier2.isPiece() && barrier2.getPiece().getName() == "horizontalFlipperUpLeft") {
							flag = 2;
							System.out.println("flag="+flag);
							break outer;
						}
					}
				}
			if (flag == 2) {
				x = i;
				y = j;
				System.out.println("x=" + x);
				System.out.println("y=" + y);
				barrierPiece pieceRemoved = gamePanel.getPoint(x, y).getPiece();
				gamePanel.getPoint(x, y).reMovePiece(pieceRemoved, gamePanel);
				barrierPiece temp = new barrierRightFlipper("rightFlipper", Color.orange, 30, 30, gamePanel);
				barrier2.setPiece(temp);
				gamePanel.getPoint(x, y).setPiece(temp, gamePanel);
				validate();
				repaint();
			}
			System.out.println("Go Left\n");
		}
	}
}