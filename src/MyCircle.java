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
public class MyCircle implements DrawingObject{
	int sizeX, sizeY, originX, originY;
	int lastX, lastY;
	Rectangle bounds = new Rectangle();
	Color c;
	public MyCircle() {
		sizeX = sizeY = originX = originY = 0;
		setBounds(bounds);
		c = Color.BLACK;
		
		System.out.println("Made circle @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
	}

	@Override
	public void draw(Graphics g) {
		
		
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.drawOval(originX, originY, sizeX, sizeY);
        
        g2d.setColor( c );
        
        System.out.println( "Redrawing circle @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
		
	}

	@Override
	public void start(Point p) {
		// TODO Auto-generated method stub
		originX = p.x;
        originY = p.y;
        lastX = p.x;
        lastY = p.y;
		
	}

	@Override
	public void drag(Point p) {
		// TODO Auto-generated method stub
		sizeX = p.x - originX;
        sizeY = p.y - originY;
        setBounds( bounds );
		
	}

	@Override
	public void move(Point p) {
		// TODO Auto-generated method stub
		originX = p.x;
        originY = p.y;
        setBounds( bounds );
		
	}


	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		return bounds.contains(p);
	}

	@Override
	public void setBounds(Rectangle b) {
		// TODO Auto-generated method stub
		b.setBounds( originX, originY, sizeX, sizeY );
		
	}

	@Override
	public void setColor(Color c) {
		// TODO Auto-generated method stub
		this.c = c;
	}





}
