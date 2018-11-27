package main;

import javax.swing.*;

import chessPieceType.ChessPiece;
import panel.ChessBoard;

import java.awt.*;
import java.awt.event.*;

public class Rule {
	ChessBoard board = null;
	ChessPiece piece = null;
	ChessPoint point[][];
	int startI, startJ, endI, endJ;

	public Rule(ChessBoard board, ChessPoint point[][]) {
		this.board = board;
		this.point = point;
	}

	public boolean movePieceRule(ChessPiece piece, int startI, int startJ, int endI, int endJ) {
		this.piece = piece;
		this.startI = startI;
		this.startJ = startJ;
		this.endI = endI;
		this.endJ = endJ;
		int minI = Math.min(startI, endI);
		int maxI = Math.max(startI, endI);
		int minJ = Math.min(startJ, endJ);
		int maxJ = Math.max(startJ, endJ);
		boolean canMove = false; // the element can be moved or not
		if (startI == endI) {
			int j = 0;
			for (j = minJ + 1; j <= maxJ - 1; j++) {
				if (point[startI][j].isPiece()) {
					canMove = false;
					break;
				}
			}
			if (j == maxJ) {
				canMove = true;
			}
		} else if (startJ == endJ) {
			int i = 0;
			for (i = minI + 1; i <= maxI - 1; i++) {
				if (point[i][startJ].isPiece()) {
					canMove = false;
					break;
				}
			}
			if (i == maxI) {
				canMove = true;
			}
		} else {
			canMove = false;
		}
		
		return canMove;

	}
}
