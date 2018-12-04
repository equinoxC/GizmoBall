package barrierPieceType;

import java.awt.Color;
import java.awt.Graphics;

import layout.GamePane;

public class barrierCyanCircle extends barrierPiece {
	
	public barrierCyanCircle(String name, Color fc, int width, int height, GamePane board) {
		super(name, fc, width, height, board);
	}

	public void paint(Graphics g) {
		g.setColor(Color.cyan);
		g.fillOval(0, 0, width, height);
	}
}
