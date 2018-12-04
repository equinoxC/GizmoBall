package barrierPieceType;

import java.awt.Color;
import java.awt.Graphics;

import layout.GamePane;

public class barrierHorizontalFlipper extends barrierPiece {
	
	public barrierHorizontalFlipper(String name, Color fc, int width, int height, GamePane board) {
		super(name, fc, width, height, board);
	}

	public void paint(Graphics g) {
		g.setColor(Color.orange);
		int[] xc = {3, 3, 27,27};
	     int[] yc = {11, 19, 19, 11};
	     g.fillOval (0, 11, 7, 7);
	     g.fillPolygon(xc, yc, 4);
	     g.fillOval(22, 11, 7, 7);
	}
}
