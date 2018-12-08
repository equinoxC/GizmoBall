package main;

import java.awt.*;
import java.awt.event.*;

class mCar extends Frame {
	Color redColor;
	int xl = 80, yl = 80, speed = 10, step = 5;

	/********* 注意这里 ***********/
	public mCar() {
		addKeyListener(new KeyAdapter() {
			/********* 注意这里 ***********/
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					System.out.println("\n Go Up");
					yl -= speed;/********* 注意这里 ***********/
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					System.out.println("\n Go Down");
					yl += speed;/********* 注意这里 ***********/
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					System.out.println("\n Go Left");
					xl -= speed;/********* 注意这里 ***********/
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					System.out.println("\n Go Right");
					xl += speed;/********* 注意这里 ***********/
				} else if (e.getKeyCode() == KeyEvent.VK_F1) {
					speed += step;/********* 注意这里 ***********/
					System.out.println("\n Speed Up");
				} else if (e.getKeyCode() == KeyEvent.VK_F2) {
					System.out.println("\n Speed Down");
					speed -= step;/********* 注意这里 ***********/
				} else
					System.out.println(e.getKeyChar());
				repaint();/********* 注意这里 ***********/
			}
		});
		setSize(400, 300);
		setVisible(true);
		setLocation(400, 200);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(xl, yl, 40, 40);/********* 注意这里 ***********/
	}
}

public class MyBall {
	public static void main(String[] args) {
		new mCar();
	}
}