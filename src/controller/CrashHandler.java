package controller;

import GizmoBallInterface.CrashInterface;
import entity.BouncingBall;
import layout.GamePane;

public class CrashHandler implements CrashInterface {

	private BouncingBall ball;

	public CrashHandler() {
		ball = BouncingBall.getInstance();
	}

	private boolean isCrashedTragle(int ballx, int bally, int temp_x, int temp_y, int radius) {
		double la = Math.sqrt((ballx - temp_x) * (ballx - temp_x) + (bally - temp_y) * (bally - temp_y));
		double lb = Math.sqrt((ballx - temp_x - 30) * (ballx - temp_x - 30) + (bally - temp_y) * (bally - temp_y));
		double lc = Math.sqrt((ballx - temp_x) * (ballx - temp_x) + (bally - temp_y - 30) * (bally - temp_y - 30));
		double Pab = (la + lb + 30) / 2;
		double Sab = Math.sqrt(Pab * (Pab - la) * (Pab - lb) * (Pab - 30));
		double Pac = (la + lc + 30) / 2;
		double Sac = Math.sqrt(Pac * (Pac - la) * (Pac - lc) * (Pac - 30));
		double Pbc = (lb + lc + 30 * 1.414) / 2;
		double Sbc = Math.sqrt(Pbc * (Pbc - lb) * (Pbc - lc) * (Pbc - 30 * 1.414));
		double hab = 2 * Sab / 30;
		double hac = 2 * Sac / 30;
		double hbc = 2 * Sbc / (1.414 * 30);
		if (hab <= radius || hac <= radius || hbc <= radius)
			return true;
		return false;
	}

	private boolean isCrashedTragle1(int ballx, int bally, int temp_x, int temp_y, int radius) {
		double la = Math.sqrt((ballx - temp_x) * (ballx - temp_x) + (bally - temp_y) * (bally - temp_y));
		double lb = Math.sqrt((ballx - temp_x - 30) * (ballx - temp_x - 30) + (bally - temp_y) * (bally - temp_y));
		double lc = Math.sqrt((ballx - temp_x) * (ballx - temp_x) + (bally - temp_y - 30) * (bally - temp_y - 30));
		double Pab = (la + lb + 30) / 2;
		double Sab = Math.sqrt(Pab * (Pab - la) * (Pab - lb) * (Pab - 30));
		double Pac = (la + lc + 30) / 2;
		double Sac = Math.sqrt(Pac * (Pac - la) * (Pac - lc) * (Pac - 30));
		double Pbc = (lb + lc + 30 * 1.414) / 2;
		double Sbc = Math.sqrt(Pbc * (Pbc - lb) * (Pbc - lc) * (Pbc - 30 * 1.414));
		double hab = 2 * Sab / 30;
		double hac = 2 * Sac / 30;
		double hbc = 2 * Sbc / (1.414 * 30);
		if (hab <= radius || hac <= radius || hbc <= radius)
			return true;
		return false;
	}

	private boolean isCrashedTragle2(int ballx, int bally, int temp_x, int temp_y, int radius) {
		double la = Math.sqrt((ballx - temp_x - 30) * (ballx - temp_x - 30) + (bally - temp_y) * (bally - temp_y));
		double lb = Math.sqrt((ballx - temp_x) * (ballx - temp_x) + (bally - temp_y) * (bally - temp_y));
		double lc = Math
				.sqrt((ballx - temp_x - 30) * (ballx - temp_x - 30) + (bally - temp_y - 30) * (bally - temp_y - 30));
		double Pab = (la + lb + 30) / 2;
		double Sab = Math.sqrt(Pab * (Pab - la) * (Pab - lb) * (Pab - 30));
		double Pac = (la + lc + 30) / 2;
		double Sac = Math.sqrt(Pac * (Pac - la) * (Pac - lc) * (Pac - 30));
		double Pbc = (lb + lc + 30 * 1.414) / 2;
		double Sbc = Math.sqrt(Pbc * (Pbc - lb) * (Pbc - lc) * (Pbc - 30 * 1.414));
		double hab = 2 * Sab / 30;
		double hac = 2 * Sac / 30;
		double hbc = 2 * Sbc / (1.414 * 30);
		if (hab <= radius || hac <= radius || hbc <= radius)
			return true;
		return false;
	}

	private boolean isCrashedTragle3(int ballx, int bally, int temp_x, int temp_y, int radius) {
		double la = Math
				.sqrt((ballx - temp_x - 30) * (ballx - temp_x - 30) + (bally - temp_y - 30) * (bally - temp_y - 30));
		double lb = Math.sqrt((ballx - temp_x) * (ballx - temp_x) + (bally - temp_y - 30) * (bally - temp_y - 30));
		double lc = Math.sqrt((ballx - temp_x - 30) * (ballx - temp_x - 30) + (bally - temp_y) * (bally - temp_y));
		double Pab = (la + lb + 30) / 2;
		double Sab = Math.sqrt(Pab * (Pab - la) * (Pab - lb) * (Pab - 30));
		double Pac = (la + lc + 30) / 2;
		double Sac = Math.sqrt(Pac * (Pac - la) * (Pac - lc) * (Pac - 30));
		double Pbc = (lb + lc + 30 * 1.414) / 2;
		double Sbc = Math.sqrt(Pbc * (Pbc - lb) * (Pbc - lc) * (Pbc - 30 * 1.414));
		double hab = 2 * Sab / 30;
		double hac = 2 * Sac / 30;
		double hbc = 2 * Sbc / (1.414 * 30);
		if (hab <= radius || hac <= radius || hbc <= radius)
			return true;
		return false;
	}

	private boolean isCrashedTragle4(int ballx, int bally, int temp_x, int temp_y, int radius) {
		double la = Math.sqrt((ballx - temp_x) * (ballx - temp_x) + (bally - temp_y - 30) * (bally - temp_y - 30));
		double lb = Math.sqrt((ballx - temp_x) * (ballx - temp_x) + (bally - temp_y) * (bally - temp_y));
		double lc = Math
				.sqrt((ballx - temp_x - 30) * (ballx - temp_x - 30) + (bally - temp_y - 30) * (bally - temp_y - 30));
		double Pab = (la + lb + 30) / 2;
		double Sab = Math.sqrt(Pab * (Pab - la) * (Pab - lb) * (Pab - 30));
		double Pac = (la + lc + 30) / 2;
		double Sac = Math.sqrt(Pac * (Pac - la) * (Pac - lc) * (Pac - 30));
		double Pbc = (lb + lc + 30 * 1.414) / 2;
		double Sbc = Math.sqrt(Pbc * (Pbc - lb) * (Pbc - lc) * (Pbc - 30 * 1.414));
		double hab = 2 * Sab / 30;
		double hac = 2 * Sac / 30;
		double hbc = 2 * Sbc / (1.414 * 30);
		if (hab <= radius || hac <= radius || hbc <= radius)
			return true;
		return false;
	}

	private boolean isCrashedCircle(int ballx, int bally, int temp_x, int temp_y, int radius) {
		if ((ballx - temp_x - 15) * (ballx - temp_x - 15)
				+ (bally - temp_y - 15) * (bally - temp_y - 15) <= (radius + 15) * (radius + 15))
			return true;
		return false;
	}

	private boolean isCrashedAbsorbedBar(int ballx, int bally, int temp_x, int temp_y, int radius) {
		

		return false;
	}
	
	private boolean isCrashedHorizontalFlipper(int ballx, int bally, int temp_x, int temp_y, int radius) {
		if((ballx+radius>=temp_x)&&(bally+radius<=temp_y)&&(bally+radius>=temp_y+11)&&(bally+radius<=temp_y+19))
			return true;
		return false;
	}
	
	private boolean isCrashedRightFlipper(int ballx, int bally, int temp_x, int temp_y, int radius) {
		if((ballx+radius>=temp_x)&&(bally+radius<=temp_y)&&(bally+radius>=temp_y+11)&&(bally+radius<=temp_y+19)&&((bally<=ballx-5)||(bally>=ballx+5)))
			return true;
		return false;
	}
	
	private boolean isCrashedLeftFlipper(int ballx, int bally, int temp_x, int temp_y, int radius) {
		if((ballx+radius>=temp_x)&&(bally+radius<=temp_y)&&(bally+radius>=temp_y+11)&&(bally+radius<=temp_y+19)&&((bally<=-ballx+23)||(bally>=-ballx+33)))
			return true;
		return false;
	}
	
	private boolean isCrashedHorizontalFlipperUp(int ballx, int bally, int temp_x, int temp_y, int radius) {
		if((ballx+radius>=temp_x)&&(bally+radius<=temp_y)&&(bally+radius>=temp_y+1)&&(bally+radius<=temp_y+9))
			return true;
		return false;
	}
	

	@Override
	public String isCrashed() {
		int x = ball.getX(), y = ball.getY();
		int radius = ball.getRadius();
		GamePane win = ball.getWin();
		if (x != 0 && y != 0 && win.getPoint(x, y).isPiece()) {
			int cell_x = win.getPoint(x, y).getX();
			int cell_y = win.getPoint(x, y).getY();
			int ball_x = x + radius;
			int ball_y = y + radius;
			if (win.getPoint(x, y).getPiece().getName() == "redRectangular")
				return "redRectangular";
			else if ((win.getPoint(x, y).getPiece().getName() == "blueTriangle"
					&& isCrashedTragle(ball_x, ball_y, cell_x, cell_y, radius))
					|| (win.getPoint(x, y).getPiece().getName() == "blueTriangle2"
							&& isCrashedTragle2(ball_x, ball_y, cell_x, cell_y, radius))
					|| (win.getPoint(x, y).getPiece().getName() == "blueTriangle3"
							&& isCrashedTragle3(ball_x, ball_y, cell_x, cell_y, radius))
					|| (win.getPoint(x, y).getPiece().getName() == "blueTriangle4"
							&& isCrashedTragle4(ball_x, ball_y, cell_x, cell_y, radius))) {
				return win.getPoint(x, y).getPiece().getName();
			} else if ((win.getPoint(x, y).getPiece().getName() == "cyanCircle"
					|| win.getPoint(x, y).getPiece().getName() == "pinkCircle"
					|| win.getPoint(x, y).getPiece().getName() == "blackCircle"
					|| win.getPoint(x, y).getPiece().getName() == "grayCircle"
					|| win.getPoint(x, y).getPiece().getName() == "greenCircle")
					&& isCrashedCircle(ball_x, ball_y, cell_x, cell_y, radius)) {
				return win.getPoint(x, y).getPiece().getName();
			} else if ((win.getPoint(x, y).getPiece().getName() == "horizontalFlipper")
					&& isCrashedHorizontalFlipper(ball_x, ball_y, cell_x, cell_y, radius)) {
				return win.getPoint(x, y).getPiece().getName();
			} else if ((win.getPoint(x, y).getPiece().getName() == "leftFlipper")
					&& isCrashedLeftFlipper(ball_x, ball_y, cell_x, cell_y, radius)) {
				return win.getPoint(x, y).getPiece().getName();
			} else if ((win.getPoint(x, y).getPiece().getName() == "rightFlipper")
					&& isCrashedRightFlipper(ball_x, ball_y, cell_x, cell_y, radius)) {
				return win.getPoint(x, y).getPiece().getName();
			} else if ((win.getPoint(x, y).getPiece().getName() == "horizontalFlipperUpRight")
					|| (win.getPoint(x, y).getPiece().getName() == "horizontalFlipperUpLeft")
					&& isCrashedHorizontalFlipperUp(ball_x, ball_y, cell_x, cell_y, radius)) {
				return win.getPoint(x, y).getPiece().getName();
			} else if ((win.getPoint(x, y).getPiece().getName() == "magentaBar")
					&& isCrashedAbsorbedBar(ball_x, ball_y, cell_x, cell_y, radius)) {
				return win.getPoint(x, y).getPiece().getName();
			} 
		}
		return null;
	}

	@Override
	public void handleCrashed(String barrierName) {
		// ball.setVx(ball.getVx()*-1);
		// ball.setVy(ball.getVy()*-1);
		if (barrierName == "redRectangular") {

		} else if (barrierName == "blueTriangle") {

		} else if (barrierName == "blueTriangle2") {

		} else if (barrierName == "blueTriangle3") {

		} else if (barrierName == "blueTriangle4") {

		} else if (barrierName == "cyanCircle") {

		} else if (barrierName == "blackCircle") {

		} else if (barrierName == "pinkCircle") {

		} else if (barrierName == "grayCircle") {

		} else if (barrierName == "greenCircle") {

		} else if (barrierName == "magentaBar") {

		} else if (barrierName == "horizontalFlipper") {

		} else if (barrierName == "leftFlipper") {

		} else if (barrierName == "rightFlipper") {

		} else if (barrierName == "horizontalFlipperUpRight") {

		} else if (barrierName == "horizontalFlipperUpLeft") {

		} else {
			System.out.println("cannot find the barrier");
		}
	}
}
