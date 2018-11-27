package chessPieceType;

import javax.swing.*;

import main.ChessPoint;
import panel.ChessBoard;

import java.awt.*;
import java.awt.event.*;

//单个棋子的绘制方法及相关变量设置反馈
public class ChessPiece extends JLabel {
	String name; // 棋子名字
	Color foreColor;// 前景色由棋子类别决定
	String color = null;
	ChessBoard board = null;
	int width, height;// 大小

	public ChessPiece(String name, Color fc, int width, int height, ChessBoard board) {
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

	public String 棋子类别() {
		return color;
	}
}
