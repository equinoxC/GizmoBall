package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
 
public class huatu extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    int a;
    JButton bt1 = null;
    JButton bt2 = null;
    int width = -1;
    int height = -1;
 
    public huatu ()
    {
        bt1 = new JButton ("画圆");
        bt2 = new JButton ("画方");
        bt1.addActionListener (this);
        bt2.addActionListener (this);
        this.setLayout (new FlowLayout ());
        this.add (bt1);
        this.add (bt2);
        this.setSize (300, 300);
        this.setLocationRelativeTo (null);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setVisible (true);
    }
 
    public static void main ( String[] args )
    {
        new huatu ();
    }
 
    public void paint ( Graphics g )
    {
        super.paint (g);
        g.drawOval (100, 100, width, height);
        g.drawRect (10, 50, width / 2, height / 2);
        g.dispose ();
    }
 
    public void actionPerformed ( ActionEvent e )
    {
        if (e.getSource () == bt1)
        {
            width = width > 200 ? 5 : ( width += 5 );
            height = height > 200 ? 5 : ( height += 5 );
            repaint ();
        }
        else if (e.getSource () == bt2)
        {
            width = width < 5 ? 200 : ( width -= 5 );
            height = height < 5 ? 200 : ( height -= 5 );
            repaint ();
        }
    }
}