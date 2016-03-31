
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Interface class for any drawable object.
 * @author woytek
 * @author Ryan Luchs
 */
public interface DrawingObject {
    //private int originX, originY;
    
    /**
     * Draw the object.
     * @param g the graphics
     */
    public void draw( Graphics g );
    /**
     * Called to start drawing a new object.
     * @param p the point
     */
    public void start( Point p );
    /**
     * Called repeatedly while dragging a new object out to size (typically 
     * called from within a mouseDragged() ).
     * @param p the point
     */
    public void drag( Point p );
    /**
     * Called to move an object. Often called repeatedly inside a mouseDragged().
     * @param p the point
     */
    public void move( Point p );
    /**
     * Set the bounding rectangle.
     * @param b the point
     */
    public void setBounds( Rectangle b );
    /**
     * Determines if the point clicked is contained by the object.
     * @param p the point
     * @return true if within bounds
     */
    public boolean contains( Point p );
    /**
     * Sets the color that the object is drawn with
     * @param c the color
     */
    public void setColor(Color c);
    
}
