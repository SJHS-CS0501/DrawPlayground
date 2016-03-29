/**
 * 
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import javafx.scene.shape.Circle;

/**
 * @author Ryley Danielson
 * For making a circle to be used in the main pannel
 *
 */
public class MyCircle implements DrawingObject{
	 // critical vars for a rectangle
    int widthX, heightY, originX, originY;
    // future use
    int lastX, lastY;
    // bounding box (needed for move)
    Rectangle bounds  = new Rectangle(5, 5, 4, 4);
   
    //Graphics g;
    
    /**
     * Construct circle
     */
    public MyCircle(){
    	// NOP
    	widthX = heightY = originX = originY = 0;
    	setBounds( bounds );
    }
    
    /**
     * Consruct circle
     * @param a
     * @param s
     * @param d
     * @param f
     */
    public MyCircle(int a, int s, int d, int f){
    	originX = a;
    	originY = s;
    	widthX = d;
    	heightY = f;
    	//draw(g);
    }
	
    /**
     * draw circle
     */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(Color.BLACK);
		//g.fillOval(originX, originY, widthX, heightY );
		
		g.drawOval(originX, originY, widthX, heightY );
		
		System.out.println( "Redrawing circle @" + originX + ", " + originY + "; " + widthX + " x " + heightY);
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
		// TODO Auto-generated method stub
		 originX = p.x;
	     originY = p.y;
	    // setBounds( bounds );
	}

	@Override
	public void move(Point p) {
		// TODO Auto-generated method stub
		originX = p.x;
        originY = p.y;
        setBounds( bounds );
	}

	@Override
	public void setBounds(Rectangle b) {
		// TODO Auto-generated method stub
		b.setBounds( originX, originY, widthX, heightY );
	}

	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		 return false;
	}



}
