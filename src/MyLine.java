import java.awt.*;
import java.awt.geom.Line2D;
import java.io.Serializable;


public class MyLine implements DrawingObject, Serializable { // these all implement DrawingObject (all the shapie things)

	private static final long serialVersionUID = 1L;
	int sizeX, sizeY, originX, originY;
    int lastX, lastY;
    //Rectangle bounds = new Rectangle(); // bounding rectangle again
    Color color;
	
    MyLine(){
    	sizeX = sizeY = originX = originY = 0; // initializing stuff and things in the constructor
    	//setBounds( bounds );
    }
	
	@Override
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		   
	    g2d.setColor( getColor());
	    g2d.drawLine( originX, originY, sizeX, sizeY ); // Draw the line, Kronk!
	        
	    System.out.println( "Redrawing line @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);	
	}

	// start point where user clicks
	@Override
	public void start(Point p) {
		originX = p.x;
        originY = p.y;
        lastX = p.x;
        lastY = p.y;
	}

	// resizing line when first made, swivels on start point above
	@Override
	public void drag(Point p) {
		
		sizeX = p.x;
        sizeY = p.y;
        //setBounds( bounds );
	}

	//
	@Override
	public void move(Point p) {
		sizeX = sizeX - (originX - p.x);
		sizeY = sizeY - (originY - p.y);
		originX = p.x;
	    originY = p.y;
	    
	     //setBounds( bounds );
	}

	// bounding rectangle!!!
	@Override
	public void setBounds(Rectangle b) {
		 b.setBounds( originX, originY, sizeX + 2, sizeY + 2);
	}

	//
	@Override
	public boolean contains(Point p) {
		double result = Line2D.ptSegDist( originX, originY, sizeX, sizeY, p.x, p.y );
		
		if( result <= 5 ){
			return true;
		} else {
			return false;
		}
		
		//return bounds.contains(p);
	}

	@Override
	public void resize(Point p) {
	}
	
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color c) {
		color = c;
	}

}
