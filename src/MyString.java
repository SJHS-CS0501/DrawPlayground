import java.awt.*;


public class MyString implements DrawingObject{
	
	String string;
	int originX, originY, sizeX, sizeY;
	int lastX, lastY;
    Rectangle bounds = new Rectangle();
    
    public MyString(){
    	sizeX = sizeY = originX = originY = 0;
        setBounds( bounds );
    }

    public MyString( int oX, int oY, int sX, int sY ){
    	sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
    }
    
	@Override
	public void draw(Graphics g) {
		 Graphics2D g2d = (Graphics2D)g;
	        
	     g2d.setColor( Color.BLACK );
	     g2d.drawString( string, originX, originY );
	        
	     System.out.println( "Redrawing String @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
	        //this.setSize( this.getPreferredSize() );
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
