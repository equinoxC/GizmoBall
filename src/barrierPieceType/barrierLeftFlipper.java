package barrierPieceType;

import java.awt.Color;
import java.awt.Graphics;

import layout.GamePane;

public class barrierLeftFlipper extends barrierPiece {
	
	public barrierLeftFlipper(String name, Color fc, int width, int height, GamePane board) {
		super(name, fc, width, height, board);
	}

	public void paint(Graphics g) {
		g.setColor(Color.orange);
	     int[] xc = {29,6,1,24};
	     int[] yc = {6,29,24,1};
	     g.fillOval(23, 0, 7, 7);
	     g.fillPolygon(xc, yc, 4);
	     g.fillOval(0, 23, 7, 7);
	}
}
