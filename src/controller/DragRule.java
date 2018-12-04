package controller;

import barrierPieceType.barrierPiece;
import layout.GamePane;
import entity.Barrier;

public class DragRule {
	GamePane board = null;
	barrierPiece piece = null;
	Barrier point[][];
	int startI, startJ, endI, endJ;

	public DragRule(GamePane board, Barrier point[][]) {
		this.board = board;
		this.point = point;
	}

	public boolean movePieceRule(barrierPiece piece, int startI, int startJ, int endI, int endJ) {
		this.piece = piece;
		this.startI = startI;
		this.startJ = startJ;
		this.endI = endI;
		this.endJ = endJ;
		boolean canMove = false; // the element can be moved or not
		if (startI == endI) {
			canMove = true;
		} else if (startJ == endJ) {
			canMove = true;
		} else {
			canMove = true;
		}
		return canMove;

	}
}
