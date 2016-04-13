import java.awt.*;

public class MyLine implements DrawingObject{ // these all implement DrawingObject (all the shapie things)

    int sizeX, sizeY, originX, originY;
    int lastX, lastY;
    Rectangle bounds = new Rectangle(); // bounding rectangle again
	
    MyLine(){
    	sizeX = sizeY = originX = originY = 0; // initializing stuff and things in the constructor
    	setBounds( bounds );
    }
	
	@Override
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
	        
	    g2d.setColor( Color.BLACK );
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
        setBounds( bounds );
	}

	//
	@Override
	public void move(Point p) {
	
		 originX = p.x;
	     originY = p.y;
	     setBounds( bounds );
		
	}

	// bounding rectangle!!!
	@Override
	public void setBounds(Rectangle b) {
		 b.setBounds( originX, originY, sizeX, sizeY );
	}

	//
	@Override
	public boolean contains(Point p) {
		return bounds.contains(p);
	}

}
