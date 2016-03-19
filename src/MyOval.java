import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * An oval DrawingObject
 * @author Ryan Luchs
 */
public class MyOval implements DrawingObject{
	
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
    public MyOval() {
        // NOP
        sizeX = sizeY = originX = originY = 0;
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
    public MyOval( int oX, int oY, int sX, int sY ) {
        sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        System.out.println( "Made oval: @" + oX + ", " + oY + "; " + sX + " x " + sY );
    }

    /**
     * draw method actually draws the object. Requires Graphics object.
     * 
     * @param g The graphics
     */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(color);
		g2d.drawOval(originX, originY, sizeX, sizeY);
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
