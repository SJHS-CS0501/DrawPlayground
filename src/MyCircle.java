import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;

/**
 * An oval DrawingObject
 * @author Ryan Luchs
 */
public class MyCircle implements DrawingObject, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6296278863647684274L;
	
	// critical vars for a rectangle
    int size, originX, originY;
    // future use
    int lastX, lastY;
    // bounding box (needed for move)
    Rectangle bounds = new Rectangle();
    // color of shape
    Color color = Color.BLACK;
	
    /**
     * Create a new MyRectangle, all params initialized to zero.
     */
    public MyCircle() {
        // NOP
        size = originX = originY = 0;
        setBounds( bounds );
    }
    
    /**
     * Create a new MyCircle with params initialized for origin and size.
     * 
     * @param oX x-coordinate of the origin (left side)
     * @param oY y-coordinate of the origin (top)
     * @param s the radius
     */
    public MyCircle( int oX, int oY, int s) {
        size = s;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        System.out.println( "Made oval: @" + oX + ", " + oY + "; " + s);
    }

    /**
     * draw method actually draws the object. Requires Graphics object.
     * 
     * @param g The graphics
     */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(color);
		
//		int nPoints = 120;
//    	int[] xPoints = new int[nPoints];
//    	int[] yPoints = new int[nPoints];
//    	
//    	for(double d = 0.0; d < nPoints; d++) {
//	        int i = (int) d;
//	        double x = Math.cos(d*((2*Math.PI)/nPoints))*(size/2);
//	        double y = Math.sin(d*((2*Math.PI)/nPoints))*(size/2);
//
//	        xPoints[i] = (int)(x+bounds.getCenterX());
//	        yPoints[i] = (int)(y+bounds.getCenterY());
//	    }
//    	
//    	g2d.drawPolygon(xPoints, yPoints, nPoints);
//		
//    	g2d.setColor(Color.PINK);
//    	g2d.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
    	
		g2d.drawOval(originX, originY, size, size);
	}

	/**
     * Called to start drawing a new object when mouse is clicked.
     * 
     * @param p The point
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
     * @param p The point
     */
    public void drag( Point p ) {
        size = ((p.x - originX) + (p.y - originY))/2;
        setBounds( bounds );
    }
    
    /**
     * Called repeatedly while moving an object (usually in a mouseDragged()
     * MouseMotionListener).
     * 
     * @param p The point
     */
    public void move( Point p ) {
        originX = p.x - size/2;
        originY = p.y - size/2;
        setBounds( bounds );
    }
    
    /**
     * Update the bounding box. The Rectangle argument is typically but not always
     * in this object. This is required for @method contains() to work.
     * 
     * @param b The bounding box
     */
    public void setBounds( Rectangle b ) {
        b.setBounds( originX, originY, size, size );
    }
    
    /**
     * Finds the distance between two points
     * @param x1 The x-coordinate of the first point
     * @param y1 The y-coordinate of the first point
     * @param x2 The x-coordinate of the second point
     * @param y2 The y-coordinate of the second point
     * @return The distance between the two points
     */
    private int dist(int x1, int y1, int x2, int y2) {
    	return (int) java.lang.Math.pow(java.lang.Math.pow((double)(x2 - x1), 2) + java.lang.Math.pow((double)(y2 - y1), 2), 0.5);
    }
    
    /**
     * Returns whether the line between points 1 and 2 contains point 3
     * @param x1 The x-coordinate of the first point
     * @param y1 The y-coordinate of the first point
     * @param x2 The x-coordinate of the second point
     * @param y2 The y-coordinate of the second point
     * @param x3 The x-coordinate of the third point
     * @param y3 The y-coordinate of the third point
     * @return true if the line contains the third point
     */
    private boolean within(int x1, int y1, int x2, int y2, int x3, int y3) {
    	int TOLERANCE = 10;
    	int lineDist = dist(x1, y1, x2, y2);
    	int mouseDist = dist(x1, y1, x3, y3) + dist(x3, y3, x2, y2);
		return lineDist + TOLERANCE > mouseDist && lineDist - TOLERANCE < mouseDist;
    }
    
    /**
     * Returns true if the point p is in the bounding box for this object. Might
     * be used to select and/or move an object.
     * 
     * @param p The point
     * @return True if p is within the bounding box
     */
    public boolean contains( Point p ) {
    	
    	int nPoints = 120;
    	int[] xPoints = new int[nPoints];
    	int[] yPoints = new int[nPoints];
    	
    	for(double d = 0.0; d < nPoints; d++) {
	        int i = (int) d;
	        double x = Math.cos(d*((2*Math.PI)/nPoints))*(size/2);
	        double y = Math.sin(d*((2*Math.PI)/nPoints))*(size/2);

	        xPoints[i] = (int)(x+bounds.getCenterX());
	        yPoints[i] = (int)(y+bounds.getCenterY());
	    }
    	
    	for(int i = 1; i < nPoints; i++) {
    		if(within(xPoints[i - 1], yPoints[i - 1], xPoints[i], yPoints[i], p.x, p.y)) {
    			return true;
    		}
    	}
    	
    	if(within(xPoints[nPoints - 1], yPoints[nPoints - 1], xPoints[0], yPoints[0], p.x, p.y)) {
    		return true;
    	}
    	
    	return false;
    }

    /**
	 * Set the color used when drawing the shape
	 * 
	 * @param c The color
	 */
	public void setColor(Color c) {
		color = c;	
	}

}
