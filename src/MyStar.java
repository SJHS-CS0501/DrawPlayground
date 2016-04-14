/**
 * This class is designed to enable a user to
 * create a star.
 * @author Jack Protivnak
 */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MyStar implements DrawingObject {
    int sizeX, sizeY, originX, originY;
    // future use
    int lastX, lastY;
    public static int points;
    double angle;
    Color color;
    boolean fill;
    Polygon poly;
    // bounding box (needed for move)
    Rectangle bounds = new Rectangle();
    private int[] xPoints; private int[] yPoints;
    
    /**
     * Create a new MyStar, all params initialized to zero.
     */
    public MyStar(boolean b) {
        // NOP
        sizeX = sizeY = originX = originY = 0;
        poly = new Polygon();
        setPoints(5);
        setBounds( bounds );
        fill = b;
    }
    
    /**
     * Create a new MyStar with params initialized for origin and size.
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
        setPoints(5);
        setBounds( bounds );
        
        System.out.println( "Made star: @" + oX + ", " + oY + "; " + sX + " x " + sY );
    }
    
    /**
     * draw method actually draws the object. Requires Graphics object.
     * @param g 
     */
    public void draw( Graphics g ) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(getColor());      
        if(fill) {
        	g2d.fillPolygon(xPoints, yPoints, xPoints.length);
        }
        else{
        	g2d.drawPolygon(xPoints, yPoints, xPoints.length);
        }
        System.out.println( "Redrawing star @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
        //this.setSize( this.getPreferredSize() );
    }
    
    /**
     * Called to start drawing a new object when mouse is clicked.
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
     * @param p 
     */
    public void drag( Point p ) {
        sizeX = p.x - originX;
        sizeY = p.y - originY;
        math();
        setBounds( bounds );
    }
    
    /**
     * Called repeatedly while moving an object (usually in a mouseDragged()
     * MouseMotionListener).
     * @param p 
     */
    public void move( Point p ) {
        originX = p.x;
        originY = p.y;
        math();
        setBounds( bounds );
    }
    
    /**
     * Update the bounding box. The Rectangle argument is typically but not always
     * in this object. This is required for @method contains() to work.
     * @param b 
     */
    public void setBounds( Rectangle b ) {
        b = poly.getBounds();
    }
    
    /**
     * Returns true if the point p is in the bounding box for this object. Might
     * be used to select and/or move an object.
     * @param p
     * @return 
     */
    public boolean contains( Point p ) {
        return poly.contains(p);
    }
    
    /**
     * Sets values used in the math equations for the different points in the star.
     * @param p
     */
    public void setPoints( int p ) {
    	points  = p;
    	angle = 2 * Math.PI / points;
    	xPoints = new int[2 * points];
    	yPoints = new int[2 * points];
    }
    
    /**
     * Returns color of object.
     */
    public Color getColor() {
    	return color;
    }
    
    /**
     * Sets color
     * @param c
     */
    public void setColor(Color c) {
    	color = c;
    }
    
    /**
     * Uses a for loop to determine the points for the star.
     */
    public void math() {
    	poly.reset();
    	for(int i = 0, j = 0; j < xPoints.length; i++, j +=2 ) {
    		xPoints[j] = (int)(originX + sizeX * Math.cos(angle * (i)));
    		yPoints[j] = (int)(originY + sizeY * Math.sin(angle * (i)));
    		xPoints[j+1] = (int)(originX + (sizeX/2) * Math.cos((Math.PI/points) + angle * (i)));
    		yPoints[j+1] = (int)(originY + (sizeY/2) * Math.sin((Math.PI/points) + angle * (i)));
    	}
    	poly.xpoints = xPoints;
    	poly.ypoints = yPoints;
    	poly.npoints = points;
	}
}