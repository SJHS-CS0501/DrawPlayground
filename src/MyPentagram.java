import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * 
 */

/**
 * A five pointed star DrawingObject
 * @author Ryan Luchs
 */
public class MyPentagram implements DrawingObject {

	// critical vars for a star
    int originX, originY;
    // the radii for the outer and inner circles 
    int size[] = new int[2];
    // future use
    int lastX, lastY;
    // bounding box (needed for move)
    Rectangle bounds = new Rectangle();
    // color of shape
    Color color = Color.BLACK;
    // the number of points
    int nPoints = 10;
    // the coordinates (x, y) of each point on the star
    int[] pointsX = new int[nPoints];
    int[] pointsY = new int[nPoints];
	
    /**
     * Create a new MyRectangle, all params initialized to zero.
     */
    public MyPentagram() {
        // NOP
        size[0] = size[1] = originX = originY = 0;
        setBounds( bounds );
    }
    
    /**
     * Create a new MyRectangle with params initialized for origin and size.
     * 
     * @param oX x-coordinate of the origin (left side)
     * @param oY y-coordinate of the origin (top)
     * @param sX length
     * @param sY height
     */
    public MyPentagram( int oX, int oY, int sX, int sY ) {
        size[0] = (sX + sY)/2;
        size[1] = size[0]/2;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        System.out.println( "Made oval: @" + oX + ", " + oY + "; " + size );
    }

    /**
     * draw method actually draws the object. Requires Graphics object.
     * 
     * @param g The graphics
     */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(color);
		
		for(double d = 0.0; d < nPoints; d++) {
	        int i = (int) d;
	        double x = Math.cos(d*((2*Math.PI)/nPoints))*size[i % 2];
	        double y = Math.sin(d*((2*Math.PI)/nPoints))*size[i % 2];

	        pointsX[i] = (int) x+originX;
	        pointsY[i] = (int) y+originY;
	    }
		
		g2d.drawPolygon(pointsX, pointsY, nPoints);;
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
        size[0] = ((p.x - originX) + (p.y - originY))/2;
        size[1] = size[0]/2;
        setBounds( bounds );
    }
    
    /**
     * Called repeatedly while moving an object (usually in a mouseDragged()
     * MouseMotionListener).
     * 
     * @param p The point
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
     * @param b The bounding box
     */
    public void setBounds( Rectangle b ) {
        b.setBounds( originX - size[0]/2, originY - size[0]/2, size[0], size[0] );
    }
    
    /**
     * Returns true if the point p is in the bounding box for this object. Might
     * be used to select and/or move an object.
     * 
     * @param p The point
     * @return True if p is within the bounding box
     */
    public boolean contains( Point p ) {
        return bounds.contains(p);
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
