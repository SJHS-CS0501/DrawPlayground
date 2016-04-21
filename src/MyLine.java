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
	Color c;
	public MyLine() {
		sizeX = sizeY = originX = originY = 0;
		setBounds(bounds);
		c = Color.BLACK;
		
		System.out.println("Made line @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
	}
	
	public MyLine( int oX, int oY, int sX, int sY ) {
        sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        
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
		int xLngth = sizeX - originX;
		int yLngth = sizeY - originY;
		
		originX = p.x;
        originY = p.y;
        sizeX = originX + xLngth;
        sizeY = originY + yLngth;
        setBounds( bounds );
		
	}

	@Override
	public void setBounds(Rectangle b) {
		// TODO Auto-generated method stub
		b.setBounds( originX, originY, sizeX, sizeY );
		
	}
	
	public double distance(Point a, Point b) {
		int in = 0;
		in = (int)Math.sqrt(((a.x - b.x) * (a.x - b.x)) + ((a.y - b.y) * (a.y - b.y)));
		
		return in;
	}

	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		Point a = new Point(originX, originY);
		Point b = new Point(sizeX, sizeY);
		System.out.println(distance(a, p) + distance(p, b));
		System.out.println(distance(a, b));
		if(distance(a, p) + distance(p, b) >= distance(a, b) - 1 && distance(a, p) + distance(p, b) <= distance(a, b) + 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void setColor(Color c) {
		// TODO Auto-generated method stub
		this.c = c;
	}





}
