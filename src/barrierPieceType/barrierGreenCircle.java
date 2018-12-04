package barrierPieceType;

import java.awt.Color;
import java.awt.Graphics;

import layout.GamePane;

public class barrierGreenCircle extends barrierPiece {
	
	public barrierGreenCircle(String name, Color fc, int width, int height, GamePane board) {
		super(name, fc, width, height, board);
	}

	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(0, 0, width, height);
	}
}
