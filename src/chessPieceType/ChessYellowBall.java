package chessPieceType;

import java.awt.Color;
import java.awt.Graphics;

import panel.ChessBoard;

public class ChessYellowBall extends ChessPiece{
	
	public ChessYellowBall(String name, Color fc, int width, int height, ChessBoard board) {
		super(name, fc, width, height, board);
	}

	public void paint(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(5, 5, 7, 7);
	}
}
