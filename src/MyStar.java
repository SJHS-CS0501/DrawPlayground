import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class MyStar implements DrawingObject{
	int sizeX, sizeY, originX, originY;
	int lastX, lastY;
	
	Rectangle bounds = new Rectangle();

    public MyStar() {
     
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
    public MyStar( int oX, int oY, int sX, int sY ) {
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
        
        g2d.setColor( Color.BLACK );
        //g2d.clearRect( originX, originY, sizeX, sizeY );  // this is cool to make a background-filled rectangle!
        g2d.drawRect( originX, originY, sizeX, sizeY );
        
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
}
