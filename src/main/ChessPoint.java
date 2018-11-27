package main;

import chessPieceType.ChessPiece;
import panel.ChessBoard;

public class ChessPoint {
	/** 棋子坐标 */
	public int x, y;

	/** 该坐标是否有子 */
	boolean hasChess;

	/** 改坐标的棋子 */
	ChessPiece piece = null;

	/** 坐标所属棋盘 */
	ChessBoard board = null;

	public ChessPoint(int x, int y, boolean bool) {
		this.x = x;
		this.y = y;
		hasChess = bool;
	}

	public boolean isPiece() {
		return hasChess;
	}

	public void setHasChess(boolean bool) {
		hasChess = bool;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// 设置该点棋子
	public void setPiece(ChessPiece piece, ChessBoard board) {
		this.board = board;
		this.piece = piece;
		board.add(piece);
		int w = (board.unitWidth);
		int h = (board.unitHeight);
		//piece.setBounds(x - w / 2, y - h / 2, w, h);// 棋子位置，宽度，高度
		piece.setBounds(x, y, w, h);// 棋子位置，宽度，高度
		hasChess = true;
		board.validate();
	}

	public ChessPiece getPiece() {
		return piece;
	}

	public void reMovePiece(ChessPiece piece, ChessBoard board) {
		this.board = board;
		this.piece = piece;
		board.remove(piece);
		board.validate();
		hasChess = false;
	}
	
	public int turntoX(){ 
		return x*30+15;  //返回数组上x对应屏幕的x坐标
	}
	
	public int turntoY(){
		return y*30+10;   //返回数组上y对应屏幕的y坐标
	}
	
	public static int turntoX(int x){
		return x*30+15;  //返回数组上x对应屏幕的x坐标,供其它类传参调用
	}
	
	public static int turntoY(int y){
		return y*30+10; //返回数组上y对应屏幕的y坐标,供其它类传参调用
	}
}
