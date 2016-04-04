import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javafx.scene.shape.Circle;

/**
 * 
 */

/**
 * @author SJHSStudent
 *
 */
public class MyStar implements DrawingObject {

	int[] xPoints;
	int[] yPoints;
	 // critical vars for a rectangle
    int sizeX, sizeY, originX, originY;
    // future use
    int lastX, lastY;
    // bounding box (needed for move)
    Rectangle bounds = new Rectangle();
    
    public MyStar(){
    	
    	 // NOP
        sizeX = sizeY = originX = originY = 0;
        setBounds( bounds );
    }
    
    public MyStar(int[] px, int[] py){
    	
    	xPoints =px;
    	yPoints =py;
    	
    }
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		 Graphics2D g2d = (Graphics2D)g;
	        
	        g2d.setColor( Color.BLACK );
	        //g2d.clearRect( originX, originY, sizeX, sizeY );  // this is cool to make a background-filled rectangle!
	        g2d.drawPolygon(xPoints, yPoints, 10);
	        
	        System.out.println( "Redrawing rectangle @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
	        //this.setSize( this.getPreferredSize() );
	}

	@Override
	public void start(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drag(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(Point p) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void setBounds(Rectangle b) {
		// TODO Auto-generated method stub
		
	}

		

	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		if(this.contains(p)){
			return true;
		}
		
		return false;
	}

}
