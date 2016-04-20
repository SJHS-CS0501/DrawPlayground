import java.awt.*;
import java.io.*;

public class MyCircle implements DrawingObject, Serializable {
	int sizeX, sizeY, originX, originY;
	int lastX, lastY;
	Rectangle bounds = new Rectangle();
	Color color;

    public MyCircle() {
     
        sizeX = sizeY = originX = originY = 0;
        setBounds( bounds );
    }
    
    /**
     * Bounds for rectangle surrounding circle
     * @param oX
     * @param oY
     * @param sX
     * @param sY
     */
    public MyCircle( int oX, int oY, int sX, int sY ) {
        sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        System.out.println( "Made Circle: @" + oX + ", " + oY + "; " + sX + " x " + sY );
    }
    
    /**
     * Actually drawing the shape
     */
    public void draw( Graphics g ) {

        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor( getColor() );
        
        g2d.drawOval( originX, originY, sizeX, sizeY );
        
        System.out.println( "Redrawing circle @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
        //this.setSize( this.getPreferredSize() );
    }
    
    public void start( Point p ) {
        originX = p.x;
        originY = p.y;
        lastX = p.x;
        lastY = p.y;
    }
    
    /**
     * When user selects and moves circle
     */
    public void drag( Point p ) {
        sizeX = p.x - originX;
        sizeY = p.y - originY;
        setBounds( bounds );
    }
    
    /**
     * Translation of circle
     */
    public void move( Point p ) {
        originX = p.x;
        originY = p.y;
        setBounds( bounds );
    }
    
    public void setBounds( Rectangle b ) {
        b.setBounds( originX, originY, sizeX, sizeY );
    }
    
    /**
     * If point is contained then it will be selected
     */
    public boolean contains( Point p ) {
        return bounds.contains(p);
    }
    
    /**
     * Called to set the color of a shape
     */
    public void setColor(Color c) {
    	color = c;
    }
    
    /**
     * Called to get the color of a shape
     */
    public Color getColor() {
    	return color;
    }
}
