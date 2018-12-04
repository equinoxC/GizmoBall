package barrierPieceType;

import java.awt.Color;
import java.awt.Graphics;

import layout.GamePane;

public class barrierYellowBall extends barrierPiece {
	
	public barrierYellowBall(String name, Color fc, int width, int height, GamePane board) {
		super(name, fc, width, height, board);
	}

	public void paint(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(5, 5, 7, 7);
	}
}
