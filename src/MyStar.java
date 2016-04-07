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
	int sizeX, sizeY, originX, originY;
	int lastX, lastY;
	int numPoints = 0;
	static final int NUMPOINTS = 5;
	int[] xArray;
	int[] yArray;
	double[] numArray = new double[numPoints];
	Rectangle bounds = new Rectangle();
	
	public MyStar() {
		sizeX = sizeY = originX = originY = 0;
        setBounds( bounds );
        numberPoints(NUMPOINTS);
	}
	
	public void numberPoints(int n) {
		numPoints = n;
		xArray = new int[numPoints * 2];
		yArray = new int[numPoints * 2];
	}
	
	

	@Override
	public void draw(Graphics g) {
		
		
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor( Color.BLACK );
        g2d.drawPolygon(xArray, yArray, xArray.length);
		
	}

	@Override
	public void start(Point p) {
		originX = p.x;
        originY = p.y;
        lastX = p.x;
        lastY = p.y;
		
	}

	@Override
	public void drag(Point p) {
		
		
		
		double foo = ((2 * Math.PI/numPoints));
		double otherFoo = (Math.PI/numPoints);
		sizeX = p.x - originX;
        sizeY = p.y - originY;
        setBounds( bounds );
		for(int c = 0, i = 0; c < xArray.length; i++, c += 2) {
			xArray[c] = (int)(originX + sizeX * Math.cos(foo * i));
			yArray[c] = (int)(originY + sizeY * Math.sin(foo * i));
			xArray[c + 1] = (int)(originX + (sizeX / 2) * Math.cos(otherFoo + foo * i));
			yArray[c + 1] = (int)(originY + (sizeY / 2) * Math.sin(otherFoo + foo * i));
		}
		
		
	}

	@Override
	public void move(Point p) {
		originX = p.x;
        originY = p.y;
        setBounds( bounds );
		
	}

	@Override
	public void setBounds(Rectangle b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		return bounds.contains(p);
	}



}
