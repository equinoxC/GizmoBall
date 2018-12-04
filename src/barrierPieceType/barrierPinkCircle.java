package barrierPieceType;

import java.awt.Color;
import java.awt.Graphics;

import layout.GamePane;

public class barrierPinkCircle extends barrierPiece {
	
	public barrierPinkCircle(String name, Color fc, int width, int height, GamePane board) {
		super(name, fc, width, height, board);
	}

	public void paint(Graphics g) {
		g.setColor(Color.pink);
		g.fillOval(0, 0, width, height);
	}
}
