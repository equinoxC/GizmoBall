package barrierPieceType;

import java.awt.Color;
import java.awt.Graphics;

import layout.GamePane;

public class barrierMagentaBar extends barrierPiece {
	
	public barrierMagentaBar(String name, Color fc, int width, int height, GamePane board) {
		super(name, fc, width, height, board);
	}

	public void paint(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect(0, 0, 30, 30);
	}
}
