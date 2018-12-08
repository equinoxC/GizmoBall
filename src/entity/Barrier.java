package entity;

import barrierPieceType.barrierPiece;
import layout.GamePane;

import javax.xml.bind.annotation.XmlElement;

public class Barrier {

	public int x, y;

	public String name;

	boolean hasBarrier;

	barrierPiece piece = null;


	GamePane board = null;

	public Barrier(int x, int y, boolean bool) {
		this.x = x;
		this.y = y;
		hasBarrier = bool;
	}

	public boolean isPiece() {
		return hasBarrier;
	}

	public void setHasChess(boolean bool) {
		hasBarrier = bool;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getName(){return name;}

	public void setPiece(barrierPiece piece, GamePane board) {
		this.board = board;
		this.piece = piece;
		board.add(piece);
		int w = (board.unitWidth);
		int h = (board.unitHeight);
		//piece.setBounds(x - w / 2, y - h / 2, w, h);
		piece.setBounds(x, y, w, h);
		hasBarrier = true;
		board.validate();
	}

	public barrierPiece getPiece() {
		return piece;
	}

	public void reMovePiece(barrierPiece piece, GamePane board) {
		this.board = board;
		this.piece = piece;
		board.remove(piece);
		board.validate();
		hasBarrier = false;
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
