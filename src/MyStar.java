import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class MyStar implements DrawingObject{
	
	int points = 5;
	int lastX, lastY;
	double offset = Math.PI/points;
	double angle = 2*Math.PI/points;
	int[] xPoints = new int[2*points];
	int[] yPoints = new int[2*points];
	int sizeX, sizeY, originX, originY;
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
        
        System.out.println( "Made star: @" + oX + ", " + oY + "; " + sX + " x " + sY );
    }
    
    /**
     * This will let the user choose how many points their star is
     */
    public void setNumPoints() {
    	
    }
    
    /**
     * Actually drawing the shape
     */
    public void draw( Graphics g ) {
    	
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor( Color.BLACK );
        
        g2d.drawPolygon(xPoints, yPoints, xPoints.length);
        
        System.out.println( "Redrawing star @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
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
        
        for(int i = 0, j = 0; j < xPoints.length; i++, j += 2) {
        
        //Outer points
        xPoints[j] = (int)(originX + sizeX * Math.cos(angle * i));
        yPoints[j] = (int)(originY + sizeY * Math.sin(angle * i));
        
        //Inner points
        xPoints[j + 1] = (int)(originX + (sizeX/2) * Math.cos(offset + angle * i));
        yPoints[j + 1] = (int)(originY + (sizeY/2) * Math.sin(offset + angle * i));
        }
        
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
    public void setColor() {
    	
    }
    
    /**
     * Called to get the color of a shape
     */
    public void getColor() {
    	
    }
}
