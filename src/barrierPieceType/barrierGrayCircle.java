package barrierPieceType;

import java.awt.Color;
import java.awt.Graphics;

import layout.GamePane;

public class barrierGrayCircle extends barrierPiece {
	
	public barrierGrayCircle(String name, Color fc, int width, int height, GamePane board) {
		super(name, fc, width, height, board);
	}

	public void paint(Graphics g) {
		g.setColor(Color.gray);
		g.fillOval(0, 0, width, height);
	}
}
