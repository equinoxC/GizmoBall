package buttonIcon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;

public class FlipperHorizontalIcon implements Icon {

	Color color;
	int[] xc;
	int[] yc;
	public FlipperHorizontalIcon(Color c){
		color = c;
		
		
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	     g.setColor(Color.orange);
	     int[] xc = {8, 8, 19,19};
	     int[] yc = {11, 19, 19, 11};
	     g.fillOval (6, 11, getIconWidth(), getIconHeight());
	     g.fillPolygon(xc, yc, 4);
	     g.fillOval(17, 11, getIconWidth(), getIconWidth());
	     
	}
	


}
