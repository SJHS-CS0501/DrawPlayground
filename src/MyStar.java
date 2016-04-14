import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * 
 */

/**
 * @author SJHSStudent
 *
 */
public class MyStar implements DrawingObject{
/*
 * x = cos(e.getX);
 * y = sin(e.getY);
 * write method to go through the points and feed them to draw polygon
 * remember to off set one circle - check
 * 0, 1* 365/5, 
 */
	// critical vars for a rectangle
    int sizeX, sizeY, originX, originY;
    // future use
    int lastX, lastY;
    // bounding box (needed for move)
    Rectangle bounds = new Rectangle();
    public int numPoints;
    int[] xPoints; 
	int[] yPoints;
    static final int NUMPOINTS = 9;
    
    
    
    /**
     * Create a new MyRectangle, all params initialized to zero.
     */
    public MyStar() {
        // NOP
        sizeX = sizeY = originX = originY = 0;
        setBounds( bounds );
        numberPoints(NUMPOINTS);
    }
    
    public void numberPoints( int n ){
		numPoints = n;
		xPoints = new int[numPoints * 2];
		yPoints = new int[numPoints * 2];
    	
    }
    
    
    /**
     * Create a new MyRectangle with params initialized for origin and size.
     * 
     * @param oX
     * @param oY
     * @param sX
     * @param sY 
     */
    public MyStar( int oX, int oY, int sX, int sY ) {
        sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        numberPoints(NUMPOINTS);
        
        System.out.println( "Made rectangle: @" + oX + ", " + oY + "; " + sX + " x " + sY );
    }
    
    /**
     * draw method actually draws the object. Requires Graphics object.
     * 
     * @param g 
     */
    public void draw( Graphics g ) {
    	
    	Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor( Color.BLACK );
        //g2d.clearRect( originX, originY, sizeX, sizeY );  // this is cool to make a background-filled rectangle!
        g2d.drawPolygon( xPoints, yPoints, xPoints.length );
        
        System.out.println( "Redrawing star @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
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
    	makeStar( p, numPoints );
    	
    }
    
    public void makeStar(Point p, int numPoints){
    	double angle = ((2 * Math.PI/numPoints));
    	double offset = (Math.PI/numPoints);
    	sizeX = p.x - originX;
        sizeY = p.y - originY;
        
    	for( int ctr = 0, i = 0; ctr < xPoints.length; i++, ctr += 2){
    		xPoints[ctr] = (int)(originX + sizeX * Math.cos(angle * i));
    		yPoints[ctr] = (int)(originY + sizeY * Math.sin(angle * i));
    		xPoints[ctr + 1] = (int)(originX + (sizeX / 2) * Math.cos(offset + angle * i));
    		yPoints[ctr + 1] = (int)(originY + (sizeY / 2) * Math.sin(offset + angle * i ));
    		
    	}
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
        makeStar(p, numPoints);
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
