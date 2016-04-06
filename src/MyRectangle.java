import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MyRectangle implements DrawingObject {
	
    // critical variables for a rectangle
    static int sizeX, sizeY, originX, originY;
    // future use
    static int lastX, lastY;
    // bounding box (needed for move)
    Rectangle boundingBox = new Rectangle();
    static String color;
    
    /**
     * Create a new MyRectangle, all parameters initialized to zero.
     */
    public MyRectangle() {
        // NOP
        sizeX = sizeY = originX = originY = 0;
        setBounds( boundingBox );
    }
    
    /**
     * Create a new MyRectangle with parameters initialized for origin and size
     * 
     * @param oX
     * @param oY
     * @param sX
     * @param sY 
     */
    public MyRectangle( int sX, int sY, int oX, int oY ) {
        sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( boundingBox );
        
        System.out.println( "Made rectangle: @" + oX + ", " + oY + "; " + sX + " x " + sY );
    }
    
    /**
     * Draw method actually draws the object. Requires Graphics object.
     * 
     * @param g 
     */
    public void draw( Graphics g ) {

        Graphics2D graphics = (Graphics2D)g;
        
        graphics.setColor( Color.BLACK );
        //g2d.clearRect( originX, originY, sizeX, sizeY );  // this is cool to make a background-filled rectangle!
        graphics.drawRect( originX, originY, sizeX, sizeY );
        
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
        setBounds( boundingBox );
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
        setBounds( boundingBox );
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
        return boundingBox.contains(p);
    }

}
