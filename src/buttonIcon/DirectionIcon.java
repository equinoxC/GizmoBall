package buttonIcon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;

public class DirectionIcon implements Icon {
	
	Color color;
	public DirectionIcon(Color c){
		color = c;
		
		
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 18;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 17;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	    
	     g.setColor(Color.black);
	     g.drawLine(5, 15, 25, 15);
	     g.drawLine(15, 5, 15, 25);
	     g.drawLine(5, 15, 9, 12);
	     g.drawLine(5, 15, 9, 18);
	     g.drawLine(25, 15, 21, 12);
	     g.drawLine(25, 15, 21, 18);
	     g.drawLine(15, 5, 12, 9);
	     g.drawLine(15, 5, 18, 9);
	     g.drawLine(15, 25, 12, 21);
	     g.drawLine(15, 25, 18, 21);
	}

}
