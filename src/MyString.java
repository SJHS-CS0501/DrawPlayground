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
    
    public MyString(){
    	sizeX = sizeY = originX = originY = 0;
    }

    public MyString( int oX, int oY, int sX, int sY ){
    	sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
    }

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
	        
	    try{
	    g2d.drawString( wordo, originX, originY );
	    }catch(NullPointerException e){
	    	System.out.println( "Sadness" );
	    }
	    
	    // String, string, string <3
	    System.out.println( "Redrawing String @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
	    //this.setSize( this.getPreferredSize() );
	}
    
	@Override
	public void start(Point p) {
		originX = p.x;
        originY = p.y;
        lastX = p.x;
        lastY = p.y;
        wordo = JOptionPane.showInputDialog( "Wordie Stuff Goes Here" ); // I rarely talk like a normal human
        
        setBounds( bounds );
	}

	@Override
	public void drag(Point p) {	
		sizeX = p.x - originX;
        sizeY = p.y - originY;
        originX = p.x;
        originY = p.y;
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
		int realX, realY;
		
		realX = originX - 2;
		realY = originY -15;
		sizeX = wordo.length() * 7;
		sizeY = 20;
		
		b.setBounds( realX, realY, sizeX, sizeY );
	}

	@Override
	public boolean contains(Point p) {

		return bounds.contains(p);
	}

	@Override
	public void getColor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor(Color c) {
		// TODO Auto-generated method stub
		
	}
	
}
