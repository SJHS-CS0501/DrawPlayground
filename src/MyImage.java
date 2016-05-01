import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 
 * @author Ryley Danielson
 *
 */
public class MyImage implements DrawingObject, Serializable{
	
	// critical vars for a rectangle
    int sizeX, sizeY, originX, originY;
    // future use
    int lastX, lastY;
    // bounding box (needed for move)
   // int fillout;
    File imageFill;
    BufferedImage img;
    Rectangle R;
    Rectangle bounds = new Rectangle();
    Color c;
    /**
     * Create a new MyRectangle, all params initialized to zero.
     */
    public MyImage(File fileName) {
        // NOP
        sizeX = sizeY = originX = originY = 0;
        setBounds( bounds );
        
        imageFill = fileName;
        
        //fillout = ColorPanel.fo;
        
        try {
            img = ImageIO.read(imageFill );//+ ".jpg"));
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(null,"File Not Found" + imageFill);
        	e.printStackTrace();
        }
    }
    
    /**
     * Create a new MyRectangle with params initialized for origin and size.
     * 
     * @param oX
     * @param oY
     * @param sX
     * @param sY 
     */
    public MyImage( int oX, int oY, int sX, int sY ) {
        sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        System.out.println( "Made Editable Image: @" + oX + ", " + oY + "; " + sX + " x " + sY );
    }
    
    /**
     * draw method actually draws the object. Requires Graphics object.
     * 
     * @param g 
     */
    public void draw( Graphics g ) {

        Graphics2D g2d = (Graphics2D)g;
        
        //fillout = ColorPanel.fo;
        /*
        if(c != null){
	        g2d.setColor( c );
		 }else{
			 g2d.setColor( Color.BLACK );
		 }
		 */
        //g2d.clearRect( originX, originY, sizeX, sizeY );  // this is cool to make a background-filled rectangle!
        /*
        if(fillout == 2){
			g.drawRect(originX, originY, sizeX, sizeY );
		}else if(fillout == 1){
			g.fillRect(originX, originY, sizeX, sizeY);
		}
        */
        //R = new Rectangle(originX, originY);
       g.drawImage(img, originX, originY, sizeX, sizeY, null);
        
        
        System.out.println( "Redrawing Image @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
        //this.setSize( this.getPreferredSize() );
    }
    
    /**
     * Called to start drawing a new object when mouse is clicked.
     * 
     * @param p 
     */
    public void start( Point p ) {
        originX = p.x;
        originY = p.y;
        lastX = p.x;
        lastY = p.y;
    }
    
    /**
     * Called repeatedly while dragging an object to size (usually in a 
     * mouseDragged() MouseMotionListener).
     * 
     * @param p 
     */
    public void drag( Point p ) {
        sizeX = p.x - originX;
        sizeY = p.y  - originY;
    	
        setBounds( bounds );
    }
    
    /**
     * Called repeatedly while moving an object (usually in a mouseDragged()
     * MouseMotionListener).
     * 
     * @param p 
     */
    public void move( Point p ) {
        originX = p.x ;
        originY = p.y ;
        setBounds( bounds );
    }
    
    /**
     * Update the bounding box. The Rectangle argument is typically but not always
     * in this object. This is required for @method contains() to work.
     * 
     * @param b 
     */
    public void setBounds( Rectangle b ) {
        b.setBounds( originX, originY, sizeX, sizeY );
    }
    
    /**
     * Returns true if the point p is in the bounding box for this object. Might
     * be used to select and/or move an object.
     * 
     * @param p
     * @return 
     */
    public boolean contains( Point p ) {
    	return bounds.contains(p);
    }

    @Override
	public void setColor(Color newC) {
		// TODO Auto-generated method stub
		c = newC;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return c;
	}

	@Override
	public void setFill(int fo) {
		// TODO Auto-generated method stub
		//fillout = fo;
		
	}
	
	
    
	//@Override
	//public void draw(Graphics g, Color c) {
		// TODO Auto-generated method stub
		
	//}

	

}
	


