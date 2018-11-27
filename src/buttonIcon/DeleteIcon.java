package buttonIcon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;

public class DeleteIcon implements Icon {
	
	Color color;
	public DeleteIcon(Color c){
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
	    System.out.println(c.getWidth());
	    int pad = 5;
	     g.setColor(Color.red);
	     System.out.println(x);
	     System.out.println(y);
	     g.drawLine(pad, pad, c.getWidth()-pad, c.getHeight()-pad);
	     g.drawLine(c.getWidth()-pad, pad, pad, c.getHeight()-pad);
	}

}
