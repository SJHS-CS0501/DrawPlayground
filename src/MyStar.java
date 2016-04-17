import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
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
    int points;
    Rectangle bounds = new Rectangle();
    Polygon star;
    Color c;
   
    
    public MyStar(int p){
    	points = p;
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
	        
		 if(c != null){
	        g2d.setColor( c );
		 }else{
			 g2d.setColor( Color.BLACK );
		 }
	        //g2d.clearRect( originX, originY, sizeX, sizeY );  // this is cool to make a background-filled rectangle!
	        g2d.drawPolygon(xPoints, yPoints, xPoints.length);
	        star = new Polygon(xPoints, yPoints, xPoints.length);
	        
	        System.out.println( "Redrawing star @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);

	        //this.setSize( this.getPreferredSize() );
	}

	@Override
	public void start(Point p) {
		// TODO Auto-generated method stub
		int x = p.x;
		int y = p.y;
		
		 originX = p.x;
	     originY = p.y;
	     lastX = p.x;
	     lastY = p.y;
		
		 
		
		//originX = x;
		//originY = y;

        xPoints = new int[(points)*2]; 
	    yPoints = new int[(points)*2];
		
		

	}

	@Override
	public void drag(Point p) {
		// TODO Auto-generated method stub
		
		sizeX = p.x - originX;
	    sizeY = p.y - originY;
	    
	    //Integer.parseInt(ToolPanel.po);
	    
	   // System.out.println(ToolPanel.po);
		
		genPoints((points));
			
		//xPoints = new int[] {x, x+12, x+54,x+18,x+28,x, x-28, x-18, x-54, x-12};
		//yPoints = new int[] {y, y+36, y+36, y+54, y+96, y+72, y+96, y+54, y+36, y+36 };
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
	
	
	public void genPoints(int points){
		
	    

		double angle = 2*Math.PI/points;
		double offset = Math.PI/points;
	    
		for(int i = 0, j = 0; j<xPoints.length; i++, j+=2){
			
			System.out.println(i +"redraw");
			
			
			//double l = (360/5) * (Math.PI/180);
			
			
			xPoints[j] = (int)(originX + sizeX * (Math.cos((angle)*(i))));// * //Math.cos(l)) ;
			yPoints[j] = (int)(originY + sizeY * (Math.sin((angle)*(i))));//* Math.sin(l));
			xPoints[j+1] = (int)(originX+ (sizeX/2) * (Math.cos(offset+(angle)*(i))));//(Math.cos(Math.PI/points)+angle;
			yPoints[j+1] = (int)(originY+ (sizeY/2) * (Math.sin(offset+(angle*i))));
		}
			
	}

	@Override
	public void move(Point p) {
		// TODO Auto-generated method stub
		
		originX =p.x;
		originY =p.y;
		
		genPoints(points);
		//double angle = 2*Math.PI/points;
		//double offset = Math.PI/points;
		
		
	}

	@Override
	public void setBounds(Rectangle b) {
		// TODO Auto-generated method stub
		
	}

		

	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		return star.contains(p);
		
	}

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

	//@Override
	//public void draw(Graphics g, Color c) {
		// TODO Auto-generated method stub
		
	//}

	
}
