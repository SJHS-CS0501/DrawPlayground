import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.io.Serializable;

import javafx.scene.shape.Circle;

/**
 * 
 */

/**
 * @author Ryley Danieslon
 *
 */
public class MyLine implements DrawingObject, Serializable {

	
	 // critical vars for a rectangle
    int sizeX, sizeY, originX, originY;
    // future use
    int lastX, lastY;
    // bounding box (needed for move)
    Point on;
    Point sz;
    Rectangle bounds = new Rectangle();
    Color c;
    
    public MyLine(){
    	
    	 // NOP
        sizeX = sizeY = originX = originY = 0;
        setBounds( bounds );
    	
    }
    
    public MyLine(int sX, int sY, int oX, int oY){
    	 sizeX = sX;
         sizeY = sY;
         originX = oX;
         originY = oY;
         setBounds( bounds );
    	
    }
    
    
	

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		 Graphics2D g2d = (Graphics2D)g;
	        
		 if(c != null){
		        g2d.setColor( c );
			 }else{
				 g2d.setColor( Color.BLACK );
			 }
	        //g2d.clearRect( originX, originY, sizeX, sizeY );  // this is cool to make a background-filled rectangle!
	        g2d.drawLine( originX, originY, sizeX, sizeY );
	        
	        System.out.println( "Redrawing line @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
	        //this.setSize( this.getPreferredSize() );
		
	}

	@Override
	public void start(Point p) {
		// TODO Auto-generated method stub
		
		// originX = sizeX = p.x;
	    // originY = sizeY = p.y;
	     lastX = p.x;
	     lastY = p.y;
		
	}

	@Override
	public void drag(Point p) {
		// TODO Auto-generated method stub
		 sizeX = p.x ;
	     sizeY = p.y ;
	}

	@Override
	public void move(Point p) {
		// TODO Auto-generated method stub
		int lx = sizeX - originX;
		int ly = sizeY - originY;
		
		originX = p.x;
		originY = p.y;
		sizeX = originX +lx ;
		sizeY = originY +ly;
	}

	@Override
	public void setBounds(Rectangle b) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Distance formula that determines whether a point is on a line
	 * @param a
	 * @param b
	 * @return int
	 */
	public int distance(Point a, Point b){
		int i;
		
		i = (int)Math.sqrt((a.x - b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
		
		return i;
	}
	
	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		on =new Point(originX,originY);
		sz =new Point(sizeX, sizeY);
		//double results = Line2D.ptSegDist(originX, originY, sizeX, sizeY, p.x, p.y);
		if(distance(on, p)+distance(p,sz) <= distance(on,sz)+1 || distance(on, p)+distance(p,sz) <= distance(on,sz)-1){
		//if(1>=results){
			return true;
		}else{
			return false;
		}
	}

	//@Override
	//public void draw(Graphics g, Color c) {
		// TODO Auto-generated method stub
		
	//}

	@Override
	public void setColor(Color newC) {
		// TODO Auto-generated method stub
		c = newC;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return c;
	}

	@Override
	public void setFill(int fo) {
		// TODO Auto-generated method stub
		
	}
}
