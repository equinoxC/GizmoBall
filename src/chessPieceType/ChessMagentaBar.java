package chessPieceType;

import java.awt.Color;
import java.awt.Graphics;

import panel.ChessBoard;

public class ChessMagentaBar extends ChessPiece{
	
	public ChessMagentaBar(String name, Color fc, int width, int height, ChessBoard board) {
		super(name, fc, width, height, board);
	}

	public void paint(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect(0, 0, 30, 30);
	}
}
