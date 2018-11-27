package chessPieceType;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import panel.ChessBoard;

public class ChessBlueTriangle3 extends ChessPiece{
	
	public ChessBlueTriangle3(String name, Color fc, int width, int height, ChessBoard board) {
		super(name, fc, width, height, board);
	}

	public void paint(Graphics g) {
		Point p1 = new Point(30, 0);
		Point p2 = new Point(30, 30);
		Point p3 = new Point(0, 30);
		int[] xs = { p1.x, p2.x, p3.x };
		int[] ys = { p1.y, p2.y, p3.y };
		Polygon triangle = new Polygon(xs, ys, 3);
		g.setColor(Color.blue);
		g.fillPolygon(triangle);
	}
}
