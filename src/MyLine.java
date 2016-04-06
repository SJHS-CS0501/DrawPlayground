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
