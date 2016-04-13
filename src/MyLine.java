import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class MyLine implements DrawingObject {
	int sizeX, sizeY, originX, originY;
	int lastX, lastY;
	
	Rectangle boundingBox = new Rectangle();

    public MyLine() {
     
        sizeX = sizeY = originX = originY = 0;
        setBounds( boundingBox );
    }
    
    /**
     * Bounds for rectangle surrounding line
     * @param oX
     * @param oY
     * @param sX
     * @param sY
     */
    public MyLine( int oX, int oY, int sX, int sY ) {
        sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( boundingBox );
        
        System.out.println( "Made Line: @" + oX + ", " + oY + "; " + sX + " x " + sY );
    }
    
    /**
     * Actually drawing the shape
     */
    public void draw( Graphics g ) {

        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor( Color.BLACK );
        
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
    
    /**
     * When user selects and moves line
     */
    public void drag( Point p ) {
        sizeX = p.x;
        sizeY = p.y;
        setBounds( boundingBox );
    }
    
    /**
     * Translation of line
     */
    public void move( Point p ) {
        originX = p.x;
        originY = p.y;
        setBounds( boundingBox );
    }
    
    public void setBounds( Rectangle b ) {
        b.setBounds( originX, originY, sizeX, sizeY );
    }
    
    /**
     * If point is contained then it will be selected
     */
    public boolean contains( Point p ) {
        return boundingBox.contains(p);
    }
    
    /**
     * Called to set the color of a shape
     */
    public void setColor() {
    	
    }
    
    /**
     * Called to get the color of a shape
     */
    public void getColor() {
    	
    }
}
