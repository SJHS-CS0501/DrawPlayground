import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * A line DrawingObject
 * @author Ryan Luchs
 */
public class MyLine implements DrawingObject {
	
	// critical vars for a rectangle
    int sizeX, sizeY, originX, originY;
    // future use
    int lastX, lastY;
    // bounding box (needed for move)
    Rectangle bounds = new Rectangle();
    // color of shape
    Color color = Color.BLACK;
	
	/**
     * Create a new MyRectangle, all params initialized to zero.
     */
    public MyLine() {
        // NOP
        sizeX = sizeY = originX = originY = 0;
        setBounds( bounds );
    }
    
    /**
     * Create a new MyLine with params initialized for origin and size.
     * 
     * @param oX x-coordinate of the origin
     * @param oY y-coordinate of the origin
     * @param eX x-coordinate of the endpoint
     * @param eY y coordinate of the endpoint
     */
    public MyLine( int oX, int oY, int eX, int eY ) {
        sizeX = eX;
        sizeY = eY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        System.out.println( "Made line: @" + oX + ", " + oY + "; " + eX + ", " + eY );
    }

    /**
     * draw method actually draws the object. Requires Graphics object.
     * 
     * @param g The graphics
     */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(color);
		g2d.drawLine(originX, originY, originX + sizeX, originY + sizeY);
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
        sizeX = p.x - originX;
        sizeY = p.y - originY;
        setBounds( bounds );
    }
    
    /**
     * Called repeatedly while moving an object (usually in a mouseDragged()
     * MouseMotionListener).
     * 
     * @param p The point
     */
    public void move( Point p ) {
        originX = p.x - sizeX/2;
        originY = p.y - sizeY/2;
        setBounds( bounds );
    }
    
    /**
     * Update the bounding box. The Rectangle argument is typically but not always
     * in this object. This is required for @method contains() to work.
     * 
     * @param b The bounding box
     */
    public void setBounds( Rectangle b ) {
        b.setBounds( originX, originY, sizeX, sizeY );
    }
    
    private double pow(double a, double b) {
    	return java.lang.Math.pow(a, b);
    }
    
    private int dist(int x1, int y1, int x2, int y2) {
    	return (int) pow(pow((double)(x2 - x1), 2) + pow((double)(y2 - y1), 2), 0.5);
    }
    
    /**
     * Returns true if the point p is in the bounding box for this object. Might
     * be used to select and/or move an object.
     * 
     * @param p The point
     * @return True if p is within the bounding box
     */
    public boolean contains( Point p ) {
    	int TOLERANCE = 10;
    	int lineDist = dist(originX, originY, originX + sizeX, originY + sizeY);
    	int mouseDist = dist(originX, originY, p.x, p.y) + dist(p.x, p.y, originX + sizeX, originY + sizeY);
		return lineDist + TOLERANCE > mouseDist && lineDist - TOLERANCE < mouseDist;
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
