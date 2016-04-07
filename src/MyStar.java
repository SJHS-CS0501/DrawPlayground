/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jack Protivnak
 */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MyStar implements DrawingObject {
    // critical vars for a rectangle
    int sizeX, sizeY, originX, originY;
    // future use
    int lastX, lastY;
    int points;
    double angle;
    // bounding box (needed for move)
    Rectangle bounds = new Rectangle();
    private int[] xPoints; private int[] yPoints;
    
    /**
     * Create a new MyRectangle, all params initialized to zero.
     */
    public MyStar() {
        // NOP
        sizeX = sizeY = originX = originY = 0;
        setBounds( bounds );
    }
    
    /**
     * Create a new MyRectangle with params initialized for origin and size.
     * 
     * @param oX
     * @param oY
     * @param sX
     * @param sY 
     */
    public MyStar( int oX, int oY, int sX, int sY ) {
        sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        System.out.println( "Made rectangle: @" + oX + ", " + oY + "; " + sX + " x " + sY );
    }
    
    /**
     * draw method actually draws the object. Requires Graphics object.
     * 
     * @param g 
     */
    public void draw( Graphics g ) {

        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor( Color.BLACK );
        //g2d.clearRect( originX, originY, sizeX, sizeY );  // this is cool to make a background-filled rectangle!
        setPoints(5);
        math();
        g2d.drawPolygon(xPoints, yPoints, points);
        
        System.out.println( "Redrawing rectangle @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
        //this.setSize( this.getPreferredSize() );
    }
    
    /**
     * Called to start drawing a new object when mouse is clicked.
     * 
     * @param p 
     */
    public void start( Point p ) {
        originX = p.x;
        originY = p.y;
        lastX = p.x;
        lastY = p.y;
    }
    
    /**
     * Called repeatedly while dragging an object to size (usually in a 
     * mouseDragged() MouseMotionListener).
     * 
     * @param p 
     */
    public void drag( Point p ) {
        sizeX = p.x - originX;
        sizeY = p.y - originY;
        setBounds( bounds );
    }
    
    /**
     * Called repeatedly while moving an object (usually in a mouseDragged()
     * MouseMotionListener).
     * 
     * @param p 
     */
    public void move( Point p ) {
        originX = p.x;
        originY = p.y;
        setBounds( bounds );
    }
    
    /**
     * Update the bounding box. The Rectangle argument is typically but not always
     * in this object. This is required for @method contains() to work.
     * 
     * @param b 
     */
    public void setBounds( Rectangle b ) {
        b.setBounds( originX, originY, sizeX, sizeY );
    }
    
    /**
     * Returns true if the point p is in the bounding box for this object. Might
     * be used to select and/or move an object.
     * 
     * @param p
     * @return 
     */
    public boolean contains( Point p ) {
        return bounds.contains(p);
    }
    
    public void setPoints( int p ) {
    	points  = p;
    	angle = 2 * (Math.PI / points);
    	xPoints = new int[2*points];
    	yPoints = new int[2*points];
    }
    
    public void math() {
    	for(int i = 0, j = 0; j < xPoints.length - 1; i++, j +=2 ) {
    		xPoints[j] = (int)(originX + sizeX * Math.cos(angle * (i)));
    		yPoints[j] = (int)(originY + sizeY * Math.sin(angle * (i)));
    		xPoints[j+1] = (int)(originX + (sizeX/2) * Math.cos((Math.PI/points) + angle * (i)));
    		yPoints[j+1] = (int)(originY + (sizeY/2) * Math.sin((Math.PI/points) + angle * (i)));
    	}
	}

}
