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
	        
	        System.out.println( "Redrawing star @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);

	        //this.setSize( this.getPreferredSize() );
	}

	@Override
	public void start(Point p) {
		// TODO Auto-generated method stub
		int x = p.x;
		int y = p.y;
		
		
		 xPoints = new int[] {x, x, x,x,x,x, x, x, x, x};
		 yPoints = new int[] {y, y, y, y, y, y, y, y, y, y };

	}

	@Override
	public void drag(Point p) {
		// TODO Auto-generated method stub
		int x = p.x;
		int y = p.y;
		

		for(int i = 0; i< xPoints.length; i++){
		
			xPoints[i]  ;
		
		}
		
			
		xPoints = new int[] {x, x+12, x+54,x+18,x+28,x, x-28, x-18, x-54, x-12};
		yPoints = new int[] {y, y+36, y+36, y+54, y+96, y+72, y+96, y+54, y+36, y+36 };
		//}

		/*
		int x =p.x;
		int y =p.y;
		
		xPoints = new int[] {x, x+12, x+54,x+18,x+28,x, x-28, x-18, x-54, x-12};
		yPoints = new int[]{y, y+36, y+36, y+54, y+96, y+72, y+96, y+54, y+36, y+36 };
		*/
		
		
		
			
			//xPoints = new int[] {x,(x+12),(x+54),(x+18),(x+28),(x),(x-28),(x-18),(x-54),(x-12)};
			//yPoints = new int[]{(y),(y+36),(y+36),(y+54),(y+96),(y+72),(y+96),(y+54),(y+36),(y+36) };
		
		
	}

	@Override
	public void move(Point p) {
		// TODO Auto-generated method stub
		
		int x = p.x;
		int y = p.y;
		
		xPoints = new int[] {x,(x+12),(x+54),(x+18),(x+28),(x),(x-28),(x-18),(x-54),(x-12)};
		yPoints = new int[]{(y),(y+36),(y+36),(y+54),(y+96),(y+72),(y+96),(y+54),(y+36),(y+36) };
		
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
