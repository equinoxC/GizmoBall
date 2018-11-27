package chessPieceType;

import java.awt.Color;
import java.awt.Graphics;

import panel.ChessBoard;

public class ChessGrayCircle extends ChessPiece{
	
	public ChessGrayCircle(String name, Color fc, int width, int height, ChessBoard board) {
		super(name, fc, width, height, board);
	}

	public void paint(Graphics g) {
		g.setColor(Color.gray);
		g.fillOval(0, 0, width, height);
	}
}
