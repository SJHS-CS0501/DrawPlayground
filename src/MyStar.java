import java.awt.*;
import javax.swing.*;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.awt.event.*;

/**
 * 
 */

/**
 * @author Ryan Smith
 *
 */
public class MyStar implements DrawingObject{
	/*
	 * (non-Javadoc)
	 * @see DrawingObject#draw(java.awt.Graphics)
	 * x = cos(e.get(X))
	 * y = sin(e.get(y))
	 * pi in java = Math.PI
	 */

	@Override
	public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor( Color.BLACK );
		
	}

	@Override
	public void start(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drag(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBounds(Rectangle b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		return false;
	}



}
