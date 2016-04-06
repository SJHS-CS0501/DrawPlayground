import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javafx.scene.shape.Circle;

/**
 * 
 */

/**
 * @author SJHSStudent
 *
 */
public class MyCircle implements DrawingObject{
	
	// critical vars for a rectangle
	int sizeX, sizeY, originX, originY;
	// future use
	int lastX, lastY;
	// bounding box (needed for move)
	Rectangle bounds = new Rectangle();

	 /**
     * Create a new MyRectangle, all params initialized to zero.
     */
    public MyCircle() {
        // NOP
        sizeX = sizeY = originX = originY = 0;
        setBounds( bounds );
    }
    
    public MyCircle( int oX, int oY, int sX, int sY ) {
        sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        System.out.println( "Made Circle: @" + oX + ", " + oY + "; " + sX + " x " + sY );
    }
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		/*
		public void drawCenteredCircle(Graphics2D g, int x, int y, int r) {
			  x = x-(r/2);
			  y = y-(r/2);
			  g.fillOval(x,y,r,r);
			}
			*/
		
		Graphics2D g2d = (Graphics2D)g;
	        
	        g2d.setColor( Color.BLACK );
	        //g2d.clearRect( originX, originY, sizeX, sizeY );  // this is cool to make a background-filled rectangle!
	        g2d.drawOval(originX, originY, sizeX, sizeY);
	        
	        System.out.println( "Redrawing circle @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
	        //this.setSize( this.getPreferredSize() );

	}

	@Override
	public void start(Point p) {
		// TODO Auto-generated method stub
		 originX = p.x;
	     originY = p.y;
	     lastX = p.x;
	     lastY = p.y;
	}

	@Override
	public void drag(Point p) {
		// TODO Auto-generated method stub
		sizeX = p.x - originX;
        sizeY = p.y - originY;
        //int r = (p.x - originX) / 2;
		//int rY = (p.y - originY) / 2;
	    //sizeX  = p.x - (r/2);
		//sizeY = p.y - (rY/2);
        setBounds( bounds );
	}

	@Override
	public void move(Point p) {
		// TODO Auto-generated method stub
		originX = p.x;
        originY = p.y;
        setBounds( bounds );
	}
	
	@Override
	public boolean contains( Point p ) {
		// TODO Auto-generated method stub
		return bounds.contains(p);
	}

	@Override
	/**
	 * 
	 */
	public void setBounds(Rectangle b) {
		// TODO Auto-generated method stub
		  b.setBounds( originX, originY, sizeX, sizeY );
	}

	/**
	 * @param args
	 */


}
