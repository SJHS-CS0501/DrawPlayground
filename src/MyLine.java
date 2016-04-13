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
public class MyLine implements DrawingObject{
	
	int sizeX, sizeY, originX, originY;
	int lastX, lastY;
	Rectangle bounds = new Rectangle();
	public MyLine() {
		sizeX = sizeY = originX = originY = 0;
		setBounds(bounds);
		
		System.out.println("Made line @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
	}

	@Override
	public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor( Color.BLACK );
        g2d.drawLine(originX, originY, sizeX, sizeY);
		
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
		sizeX = p.x - originX;
        sizeY = p.y - originY;
        setBounds( bounds );
		
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
		b.setBounds( originX, originY, sizeX, sizeY );
		
	}
	
	public int distance(Point a, Point b) {
		Math.sqrt(((a.x - b.x) * (a.x - b.x)) - ((a.y - b.y) * (a.y - b.y)));
		
		return lastX;
	}

	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		
		return bounds.contains(p);
	}



}
