import java.awt.*;
import java.io.Serializable;

import javax.swing.JOptionPane;

// The bestest button in my opinion:)

public class MyString implements DrawingObject, Serializable{
	
	private static final long serialVersionUID = 1L;
	String wordo; // for the user's wordos
	int originX, originY, sizeX, sizeY;
	int lastX, lastY;
    Rectangle bounds = new Rectangle();
    Color color;
    
    // constructor 1
    public MyString(){
    	sizeX = sizeY = originX = originY = 0;
    }

    // constructor 2
    public MyString( int oX, int oY, int sX, int sY ){
    	sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
    }

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
	        
		g2d.setColor( getColor());
	    try{
	    g2d.drawString( wordo, originX, originY );
	    }catch(NullPointerException e){
	    	System.out.println( "Sadness" );
	    }
	    
	    // String, string, string <3
	    System.out.println( "Redrawing String @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
	    //this.setSize( this.getPreferredSize() );
	}
    
	// makes string appear where user clicked
	@Override
	public void start(Point p) {
		originX = p.x;
        originY = p.y;
        lastX = p.x;
        lastY = p.y;
        wordo = JOptionPane.showInputDialog( "Wordie Stuff Goes Here" ); // I rarely talk like a normal human
        
        setBounds( bounds );
	}

	// for dragging. Not to be confused with moving...
	@Override
	public void drag(Point p) {	
		sizeX = p.x - originX;
        sizeY = p.y - originY;
        originX = p.x;
        originY = p.y;
        setBounds( bounds );
	}

	// for moving
	@Override
	public void move(Point p) {
		originX = p.x;
        originY = p.y;
        
        setBounds( bounds );
	}

	// BOUNDS!
	@Override
	public void setBounds(Rectangle b) {
		int realX, realY;
		
		realX = originX - 2; // stretches bounding box down by 2 pixels
		realY = originY - 15; // moves bounding box left by 15 pixels
		sizeX = wordo.length() * 7; // multiplies number of bits of letters by 7
		sizeY = 20;
		
		b.setBounds( realX, realY, sizeX, sizeY );
	}

	// shows if user clicked within the string's bounds
	@Override
	public boolean contains(Point p) {
		return bounds.contains(p);
	}
	
	// get color
	public Color getColor() {
		return color;
	}

	// set color
	@Override
	public void setColor(Color c) {
		color = c;
	}
	
}
