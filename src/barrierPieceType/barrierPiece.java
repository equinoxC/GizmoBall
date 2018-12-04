package barrierPieceType;

import javax.swing.*;

import entity.Barrier;
import layout.GamePane;

import java.awt.*;


public class barrierPiece extends JLabel {
	String name;
	Color foreColor;
	String color = null;
	GamePane board = null;
	int width, height;

	public barrierPiece(String name, Color fc, int width, int height, GamePane board) {
		this.name = name;
		this.board = board;
		this.width = width;
		this.height = height;
		foreColor = fc;
		setSize(width, height);
		addMouseMotionListener(board);
		addMouseListener(board);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return foreColor;
	}

	public void setType(String type) {
		color = type;
	}

}
