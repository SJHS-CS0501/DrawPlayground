import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MyString implements DrawingObject, KeyListener{
	
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
	     g2d.drawString( "Type here", originX, originY );
	        
	     System.out.println( "Redrawing String @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
	        //this.setSize( this.getPreferredSize() );
	}

	@Override
	public void start(Point p) {
		
		originX = p.x;
        originY = p.y;
        lastX = p.x;
        lastY = p.y;
        //string.equals( "type here" );
		
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

	// I don't think this needs any code since I'm not setting this up with any fancy letters
	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	// same here. These are part of the interface though.
	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	
	@Override
	public void keyTyped(KeyEvent k) {
		displayInfo(k, "");
	}

	private void displayInfo(KeyEvent k, String string) {
		
		
	}
	
	// needed to fire keyboard events
	public boolean isFocusable( boolean f ){
		return f;
	}
	
}
