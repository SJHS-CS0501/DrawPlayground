/**
 *
 * @author Ryan Luchs
 */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MyOval implements DrawingObject{
	
	int sizeX, sizeY, originX, originY;
	int lastX, lastY;
	Rectangle bounds = new Rectangle();
	
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
     * @param oX
     * @param oY
     * @param sX
     * @param sY 
     */
    public MyOval( int oX, int oY, int sX, int sY ) {
        sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        System.out.println( "Made oval: @" + oX + ", " + oY + "; " + sX + " x " + sY );
    }

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawOval(originX, originY, sizeX, sizeY);
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

}
