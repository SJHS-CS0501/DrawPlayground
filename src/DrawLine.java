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
public class DrawLine implements DrawingObject {

    int sizeX, sizeY, originX, originY;
    int lastX, lastY;

    Rectangle bounds = new Rectangle();
    
    /**
     * Create a new MyRectangle, all params initialized to zero.
     */
    public DrawLine() {
        // NOP
        sizeX = sizeY = originX = originY = 0;
        setBounds( bounds );
    }
    
    public DrawLine( int oX, int oY, int sX, int sY ) {
        sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        System.out.println( "Made line: @" + oX + ", " + oY + "; " + sX + " x " + sY );
    }
    
    public void draw( Graphics g ) {

        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor( Color.BLACK );
        //g2d.clearRect( originX, originY, sizeX, sizeY );  // this is cool to make a background-filled rectangle!
        g2d.drawLine( originX, originY, sizeX, sizeY );
        
        System.out.println( "Redrawing line @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
        //this.setSize( this.getPreferredSize() );
    }
    
    public void start( Point p ) {
        originX = p.x;
        originY = p.y;
        lastX = p.x;
        lastY = p.y;
    }
    
    public void drag( Point p ) {
        sizeX = p.x; 
        sizeY = p.y;
        setBounds( bounds );
    }
    
    public void move( Point p ) {
        originX = p.x;
        originY = p.y;
        setBounds( bounds );
    }
    
    public void setBounds( Rectangle b ) {
        b.setBounds( originX, originY, sizeX, sizeY );
    }

	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		return false;
	}
}
