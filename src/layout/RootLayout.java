package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
import barrierPieceType.barrierBlueTriangle;
import barrierPieceType.barrierBlueTriangle2;
import barrierPieceType.barrierBlueTriangle3;
import barrierPieceType.barrierBlueTriangle4;
import barrierPieceType.barrierPiece;
import controller.AnimationWindow;

/**
 * Overview: An ApplicationWindow is a top level program window that contains a
 * toolbar and an animation window.
 */
public class RootLayout extends JFrame {

	private static final long serialVersionUID = 3257563992905298229L;

	protected AnimationWindow animationWindow;
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

	barrierPiece temp = null;

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

		temp = new barrierPiece("temp",Color.blue,30,30,gamePanel);
		
		// Create the toolbar.
		JToolBar toolBar = new JToolBar();
		addButtons(toolBar);

		// Create the animation area used for output.
		//animationWindow = new AnimationWindow();
		// Put it in a scrollPane, (this makes a border)
		//gamePanel = new GamePane(animationWindow);
		gamePanel = new GamePane(30, 30, 18, 18);
		//gamePanel.add(animationWindow);
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
				Graphics g = gamePanel.getGraphics();
				gamePanel.createGreenCircle("greenCircle");
			}
		});
		cb_green.setActionCommand("Circle");

		Icon sbbs_red = new SquareButtonIcon(Color.red);
		sb_red = new JButton(sbbs_red);
		sb_red.setPreferredSize(new Dimension(30, 30));
		sb_red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = gamePanel.getGraphics();
				gamePanel.createRedRectangular("redRectangular");
			}
		});
		sb_red.setActionCommand("Square");

		Icon tbbs_blue = new TriangleButtonIcon(Color.blue);
		tb_blue = new JButton(tbbs_blue);
		tb_blue.setPreferredSize(new Dimension(30, 30));
		tb_blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = gamePanel.getGraphics();
				temp = gamePanel.createBlueTriangle("blueTriangle");
				System.out.println("temp=" + temp.getName());
			}
		});
		tb_blue.setActionCommand("Triangle");

		Icon cbbs_cyan = new CircleButtonIcon(Color.cyan);
		cb_cyan = new JButton(cbbs_cyan);
		cb_cyan.setPreferredSize(new Dimension(30, 30));
		cb_cyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = gamePanel.getGraphics();
				gamePanel.createCyanCircle("cyanCircle");
			}
		});
		cb_cyan.setActionCommand("Circle");

		Icon cbbs_pink = new CircleButtonIcon(Color.pink);
		cb_pink = new JButton(cbbs_pink);
		cb_pink.setPreferredSize(new Dimension(30, 30));
		cb_pink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = gamePanel.getGraphics();
				gamePanel.createPinkCircle("pinkCircle");
			}
		});
		cb_pink.setActionCommand("Circle");

		Icon cbbs_black = new CircleButtonIcon(Color.black);
		cb_black = new JButton(cbbs_black);
		cb_black.setPreferredSize(new Dimension(30, 30));
		cb_black.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = gamePanel.getGraphics();
				gamePanel.createBlackCircle("blackCircle");
			}
		});
		cb_black.setActionCommand("Circle");

		Icon cbbs_gray = new CircleButtonIcon(Color.gray);
		cb_gray = new JButton(cbbs_gray);
		cb_gray.setPreferredSize(new Dimension(30, 30));
		cb_gray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = gamePanel.getGraphics();
				gamePanel.createGrayCircle("grayCircle");
			}
		});
		cb_gray.setActionCommand("Circle");

		Icon fhbs = new FlipperHorizontalIcon(Color.gray);
		fhg = new JButton(fhbs);
		fhg.setPreferredSize(new Dimension(30, 30));
		fhg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = gamePanel.getGraphics();
				gamePanel.createHorizontalFlipper("horizontalFlipper");
			}
		});
		fhg.setActionCommand("HorizontalFlipper");

		Icon frbs = new FlipperRightIcon(Color.gray);
		frg = new JButton(frbs);
		frg.setPreferredSize(new Dimension(30, 30));
		frg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = gamePanel.getGraphics();
				gamePanel.createRightFlipper("rightFlipper");
			}
		});
		frg.setActionCommand("RightFlipper");

		Icon flbs = new FlipperLeftIcon(Color.gray);
		flg = new JButton(flbs);
		flg.setPreferredSize(new Dimension(30, 30));
		flg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = gamePanel.getGraphics();
				gamePanel.createLeftFlipper("leftFlipper");
			}
		});
		flg.setActionCommand("LeftFlipper");

		Icon bbbs_yellow = new BallButtonIcon(Color.yellow);
		bb_yellow = new JButton(bbbs_yellow);
		bb_yellow.setPreferredSize(new Dimension(30, 30));
		bb_yellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = gamePanel.getGraphics();
				gamePanel.createYellowBall("yellowBall");
			}
		});
		bb_yellow.setActionCommand("Ball");

		Icon abbs_magenta = new AbsorbButtonIcon(Color.magenta);
		ab_magenta = new JButton(abbs_magenta);
		ab_magenta.setPreferredSize(new Dimension(68, 30));
		ab_magenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = gamePanel.getGraphics();
				gamePanel.createMagentaBar("magentaBar");
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
		// lg.addActionListener(this.listener);
		lg.setActionCommand("GizmoLink");

		Icon dbbs = new DeleteIcon(Color.gray);
		dg = new JButton(dbbs);
		dg.setPreferredSize(new Dimension(30, 30));
		ab_magenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = gamePanel.getGraphics();
				//
			}
		});
		dg.setActionCommand("Delete");

		Icon rgbs = new RotateIcon(Color.gray);
		rg = new JButton(rgbs);
		rg.setPreferredSize(new Dimension(30, 30));
		rg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = gamePanel.getGraphics();
				if (temp != null && (temp.getName().equals("blueTriangle") || 
						temp.getName().equals("blueTriangle2") || 
						temp.getName().equals("blueTriangle3") ||
						temp.getName().equals("blueTriangle4"))) {
					int a = gamePanel.getStartI();
					int b = gamePanel.getStartJ();
					int m = gamePanel.getEndI();
					int n = gamePanel.getEndJ();
					System.out.println("a="+a);
					System.out.println("b="+b);
					System.out.println("m="+m);
					System.out.println("n="+n);
					barrierPiece pieceRemoved = gamePanel.getPoint(m, n).getPiece();
					gamePanel.getPoint(m, n).reMovePiece(pieceRemoved, gamePanel);
					type++;
					if(type%4 == 1) {
						temp = new barrierBlueTriangle2("blueTriangle2", Color.blue, 30, 30, gamePanel);
					} else if(type%4 == 2) {
						temp = new barrierBlueTriangle3("blueTriangle3", Color.blue, 30, 30, gamePanel);
					} else if(type%4 == 3) {
						temp = new barrierBlueTriangle4("blueTriangle4", Color.blue, 30, 30, gamePanel);
					} else if(type%4 == 0) {
						temp = new barrierBlueTriangle("blueTriangle", Color.blue, 30, 30, gamePanel);
					}
					gamePanel.getPoint(m, n).setPiece(temp, gamePanel);
					if(a!=m || b!=n) {
						(gamePanel.getPoint(a, b)).setHasChess(false);
					}
					a = m;
					b = n;
					validate();
					repaint();
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
				//animationWindow.setMode(true);
				gamePanel.setMode(true);
			}
		});
		toolBar.add(button);

		button = new JButton("Stop");
		button.setToolTipText("Stop the animation");
		// when this button is pushed it calls animationWindow.setMode(false)
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//animationWindow.setMode(false);
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
				//
			}
		});
		toolBar.add(button);

		button = new JButton("Load");
		button.setToolTipText("Load the animation from local file system");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		toolBar.add(button);

	}

}