import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class MyAnimal implements DrawingObject {

	int[] xPoints;
	int[] yPoints;
	 // critical vars for a rectangle
    int sizeX, sizeY, originX, originY;
    // future use
    int lastX, lastY;
    // bounding box (needed for move)
    Rectangle bounds = new Rectangle();
   Color c;
    
    public MyAnimal(){
    	
    	 // NOP
        sizeX = sizeY = originX = originY = 0;
        setBounds( bounds );
    }
    
    public MyAnimal(int[] px, int[] py){
    	
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
	        g2d.drawPolygon(xPoints, yPoints, 10);
	        
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

        xPoints = new int[] {x, x+12, x+54,x+18,x+28,x, x-28, x-18, x-54, x-12};
	    yPoints = new int[]{y, y+36, y+36, y+54, y+96, y+72, y+96, y+54, y+36, y+36 };
		
		

	}

	@Override
	public void drag(Point p) {
		// TODO Auto-generated method stub
		int x = p.x;
		int y = p.y;
		
		sizeX = p.x - originX;
	    sizeY = p.y  - originY;
/*
		for(int i = 0; i< xPoints.length; i+= 2){
		
			double l = (360/5) * (Math.PI/180);
			xPoints[i] = (int)(originX  * Math.cos(l)) ;
			yPoints[i] = (int)(originY * Math.sin(l));
		
		}
	*/	
		for(int i = 0, j = 0; j<xPoints.length; i++, j+=2){
			
			System.out.println(i +"redraw");
			
			double angle = 2*Math.PI/10;
			
			double l = (360/5) * (Math.PI/180);
			xPoints[j] = (int)(originX + sizeX * Math.cos(angle*(i)));// * //Math.cos(l)) ;
			yPoints[j] = (int)(originY + sizeY * Math.sin(angle *(i)));//* Math.sin(l));
			xPoints[j+1] = (int)(originX + (sizeX/2) * Math.cos(angle*(i)));//(Math.cos(Math.PI/points)+angle;
			yPoints[j+1] = (int)(originY + (sizeY/2) * Math.sin(angle*(i)));
		}
			
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

	//@Override
	//public void draw(Graphics g) {
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
}
