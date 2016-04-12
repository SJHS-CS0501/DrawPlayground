import java.awt.*;

public class MyArc implements DrawingObject{

	// critical vars for a rectangle
    int sizeX, sizeY, originX, originY, width, length;
    // future use
    int lastX, lastY;
    // bounding box (needed for move)
    Rectangle bounds = new Rectangle();
	
    MyArc(){
    	sizeX = sizeY = originX = originY = width = length = 0;
    	setBounds( bounds );
    }
    
    MyArc( int oX, int oY, int sX, int sY){
    	sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        System.out.println( "Made arc: @" + oX + ", " + oY + "; " + sX + " x " + sY );
    }
	
	@Override
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
        g2d.setColor( Color.BLACK );
		g.drawArc( sizeX, sizeY, originX, originY, width, length );
		
		 System.out.println( "Redrawing arc @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
	}

	@Override
	public void start(Point p) {
		originX = p.x;
        originY = p.y;
        lastX = p.x;
        lastY = p.y;
	}

	@Override
	public void drag(Point p) {
		sizeX = p.x - originX;
        sizeY = p.y - originY;
        setBounds( bounds );
		
	}

	@Override
	public void move(Point p) {
		originX = p.x;
	    originY = p.y;
	    setBounds( bounds );
	
	}

	@Override
	public void setBounds(Rectangle b) {
        b.setBounds( originX, originY, sizeX, sizeY );
	}

	@Override
	public boolean contains(Point p) {
        return bounds.contains(p);
	}

}
