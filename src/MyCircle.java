import java.awt.*;
import java.io.Serializable;

// CIRCLES
// This is the same as the MyRectangle class except the draw has drawOval
public class MyCircle implements DrawingObject, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int originX, originY, sizeX, sizeY;
	int lastX, lastY;
    Rectangle bounds = new Rectangle();
    
    public MyCircle(){
    	sizeX = sizeY = originX = originY = 0;
        setBounds( bounds );
    }
    
	@Override
	public void draw(Graphics g) {
		 Graphics2D g2d = (Graphics2D)g;
	     
	     g2d.setColor( Color.BLACK );
	     g2d.drawOval( originX, originY, sizeX, sizeY ); // Important stuff right here
	        
	     // Ok, so I also had to change it to say Redrawing circle instead of rectangle because that would just be weird
	     System.out.println( "Redrawing circle @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
	}
	
	// start point where user starts drawing the shape
	@Override
	public void start(Point p) {
		originX = p.x;
        originY = p.y;
        lastX = p.x;
        lastY = p.y;
	}

	// for resizing shape at its creation
	@Override
	public void drag(Point p) {
		sizeX = p.x - originX;
        sizeY = p.y - originY;
        setBounds( bounds );
	}

	// doesn't work yet
	@Override
	public void move(Point p) {
        originX = p.x;
        originY = p.y;
        setBounds( bounds );
	}

	// setting bounds rectangle
	@Override
	public void setBounds(Rectangle b) {
		 b.setBounds( originX, originY, sizeX, sizeY );
	}

	// not used yet
	@Override
	public boolean contains(Point p) {
		return bounds.contains(p);
	}

	@Override
	public void resize(Point p) {
	}
	
	public void getColor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor(Color c) {
	}

}
