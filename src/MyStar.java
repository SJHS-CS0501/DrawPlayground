import java.awt.*;
import java.io.Serializable;

public class MyStar implements DrawingObject, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int points = 5; // number of points on the star
	double offset = Math.PI/points; // to offset the inner points from the outer points so you don't get a sad shape
    double angle = 2*Math.PI/points; // for all my angle and mathy needs
	int[] xValues = new int[2 * points]; // for the x values (duh) 
	int[] yValues = new int[2 * points]; // for the y values (also duh)
    int originX, originY, sizeX, sizeY; // points for secret things
   	Rectangle bounds = new Rectangle(); // BOUNDING RECTANGLE!!! for bounding the object
   	Polygon poly = new Polygon(); // for moving purposes
	Color color;
   	
   	// setBounds constructor
	public MyStar(){
		setBounds( bounds );
	}
	
	// also a constructor
	// this one says where it made a star
	public MyStar( int oX, int oY, int sX, int sY ){
		sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        System.out.println( "Made star: @" + oX + ", " + oY + "; " + sX + " x " + sY );
	}
	
	
	@Override
	public void draw(Graphics g) { // actually draws the object
		Graphics2D g2d = (Graphics2D)g; // making a new graphics
        
		g2d.draw(bounds);
		g2d.setColor( getColor() ); // setting color to black right now
        g2d.drawPolygon( xValues, yValues, xValues.length ); // draw that polygon ( aka a spiff 5-pointed star)!!!       
        
        System.out.println( "Redrawing star @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
		
	}

	// the start point where the user clicks to make the shape
	@Override
	public void start(Point p) {
		originX = p.x;
	    originY = p.y;
	    sizeX = p.x;
	    sizeY = p.y;
	}

	// resizes the star (so neat^^)
	@Override
	public void drag(Point p) {
		sizeX = p.x - originX;
		sizeY = p.y - originY;
		
		for( int i = 0, j = 0; j < xValues.length; i++, j += 2 ){
			xValues[j] = (int)(originX + sizeX*Math.cos(angle*i));
			yValues[j] = (int)(originY + sizeY*Math.sin(angle*i));
			
			xValues[j+1] = (int)(originX + (sizeX/2)*Math.cos(offset + angle*i));
			yValues[j+1] = (int)(originY + (sizeY/2)*Math.sin(offset + angle*i));
		}
		
		setBounds( bounds );
	}

	// for moving the star
	@Override
	public void move(Point p) {
		
		poly.translate( p.x, p.y );
		originX = p.x;
	    originY = p.y;
	    setBounds( bounds );
		
	}

	// setBounds is super important. Trust me.
	public void setBounds( Rectangle bounds) {
		  bounds.setBounds( originX, originY, sizeX, sizeY );
	}

	// contains method will be used for moving stuff later
	@Override
	public boolean contains(Point p) {
        return bounds.contains(p);
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
