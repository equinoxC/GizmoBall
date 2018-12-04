package barrierPieceType;

import java.awt.Color;
import java.awt.Graphics;

import layout.GamePane;

public class barrierRightFlipper extends barrierPiece {
	
	public barrierRightFlipper(String name, Color fc, int width, int height, GamePane board) {
		super(name, fc, width, height, board);
	}

	public void paint(Graphics g) {
		g.setColor(Color.orange);
	     int[] xc = {6,29,24,1};
	     int[] yc = {1,24,29,6};
	     g.fillOval (0, 0, 7, 7);
	     g.fillPolygon(xc, yc, 4);
	     g.fillOval(23, 23, 7, 7);
	}
}
