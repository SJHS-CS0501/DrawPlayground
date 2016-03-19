import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * 
 */

/**
 * @author ryan
 *
 */
public class MyLine implements DrawingObject {
	
	private int sizeX, sizeY, originX, originY;
	private int lastX, lastY;
	private Rectangle bounds = new Rectangle();
	private Color color = Color.BLACK;
	
	/**
     * Create a new MyRectangle, all params initialized to zero.
     */
    public MyLine() {
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
    public MyLine( int oX, int oY, int eX, int eY ) {
        sizeX = eX;
        sizeY = eY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        System.out.println( "Made line: @" + oX + ", " + oY + "; " + eX + ", " + eY );
    }

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(color);
		g2d.drawLine(originX, originY, originX + sizeX, originY + sizeY);
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
        originX = p.x - sizeX/2;
        originY = p.y - sizeY/2;
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

	@Override
	public void setColor(Color c) {
		color = c;
		
	}

}
