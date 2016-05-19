import java.awt.*;

// this is the spiffest little interface implemented in every single shape (for the methods and such...it's still cool!)

/**
 * Interface class for any drawable object.
 * @author woytek
 * @author Isabelle Schroeder
 */
public interface DrawingObject {
    //private int originX, originY;
    
    /**
     * Draw the object.
     * @param g 
     */
    public void draw( Graphics g );
    
    
    /**
     * Called to start drawing a new object.
     * @param p 
     */
    public void start( Point p );
    
    
    /**
     * Called repeatedly while dragging a new object out to size (typically 
     * called from within a mouseDragged() ).
     * @param p 
     */
    public void drag( Point p );
    
    
    /**
     * Called to move an object. Often called repeatedly inside a mouseDragged().
     * @param p 
     */
    public void move( Point p );
    
    
    /**
     * Set the bounding rectangle.
     * @param b 
     */
    public void setBounds( Rectangle b );
    
    
    /**
     * Determines if the point clicked is contained by the object.
     * @param p
     * @return 
     */
    public boolean contains( Point p );

    /**
     * gets color
     * @return
     */
    public Color getColor();
    
    /**
     *  sets color
     * @param c
     */
    public void setColor( Color c);
}
