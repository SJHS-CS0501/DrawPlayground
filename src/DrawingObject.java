 import java.awt.*;

/**
 * Interface class for any drawable object.
 * @author woytek
 */
public interface DrawingObject {
	//interface: blueprints but doesn't tell you how to do it
    
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
	 * Set the polygon bounding box
	 */
	public void setPolyBounds(Polygon p);
	    
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
     * Called to set the color of a shape
     */
    public void setColor(Color c);
    
    /**
     * Called to get the color of a shape
     * @return 
     */
    public Color getColor();
}
