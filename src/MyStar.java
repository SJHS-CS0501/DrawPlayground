import java.awt.*;

public class MyStar implements DrawingObject{

	int points = 5;
	double offset;
    double angle;
	int[] xValues = new int[2 * points]; 
	int[] yValues = new int[2 * points];
    int originX, originY, sizeX, sizeY;
   	Rectangle bounds = new Rectangle();
	
	public MyStar(){
	//	lines = 0;
		setBounds( bounds );
	}
	
	public MyStar( int oX, int oY, int sX, int sY ){
		sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        System.out.println( "Made star: @" + oX + ", " + oY + "; " + sX + " x " + sY );
	}
	
	
	// use draw polygon
	// use circle as bound, points on inner and outer circle for points on star
	// math and stuff :'(
	
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor( Color.BLACK );
        g2d.drawPolygon( xValues, yValues, xValues.length );
        
        
        // clipRect method? 
        //need to change points so that they are not all set to 0 **Probably fixed! (for now anyway)
        
        
        System.out.println( "Redrawing star @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
		
	}

	@Override
	public void start(Point p) {

		originX = p.x;
	    originY = p.y;
	    sizeX = p.x;
	    sizeY = p.y;
	}

	@Override
	public void drag(Point p) {
	
		for( int i = 0, j = 0; j < xValues.length; i++, j += 2 ){
			xValues[j] = (int)(originX + sizeX*Math.cos(angle*i));
			yValues[j] = (int)(originY + sizeY*Math.sin(angle*i));
			
			xValues[j+2] = (int)(originX + (sizeX/2)*Math.cos(offset + angle*i));
		}
	}

	@Override
	public void move(Point p) {
		originX = p.x;
	    originY = p.y;
	    setBounds( bounds );
		
	}

	public void setBounds( Rectangle bounds) {
		  bounds.setBounds( originX, originY, sizeX, sizeY );
	}

	@Override
	public boolean contains(Point p) {
        return bounds.contains(p);
	}

}
