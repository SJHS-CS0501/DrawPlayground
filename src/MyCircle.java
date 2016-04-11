/**
 * This class is designed to enable a user to
 * create a circle.
 * @author Jack Protivnak
 */
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javafx.scene.shape.Line;

public class MyCircle implements DrawingObject {
	int sizeX, sizeY, originX, originY;
	// future use
	int lastX, lastY;
	Color color;
	// bounding box (needed for move)
	Rectangle bounds = new Rectangle();
	// Line2D.Float bounds = new Line2D.Float();

	/**
	 * Create a new MyCircle, all params initialized to zero.
	 */
	public MyCircle() {
		// NOP
		sizeX = sizeY = originX = originY = 0;
		setBounds(bounds);
	}

	/**
	 * Create a new MyCircle with params initialized for origin and size.
	 * @param oX
	 * @param oY
	 * @param sX
	 * @param sY
	 */
	public MyCircle(int oX, int oY, int sX, int sY) {
		sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
	}

	/**
	 * Draw method actually draws the object. Requires Graphics object.
	 * @param g
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(getColor());
		if(ToolPanel.fill) {
        	g2d.fillOval(originX, originY, sizeX, sizeY);
        }
		g2d.drawOval(originX, originY, sizeX, sizeY);
		System.out.println("Redrawing circle @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
		// this.setSize( this.getPreferredSize() );
	}

	/**
	 * Called to start drawing a new object when mouse is clicked.
	 * @param p
	 */
	public void start(Point p) {
		originX = p.x;
		originY = p.y;
		sizeX = p.x;
		sizeY = p.y;
	}

	/**
	 * Called repeatedly while dragging an object to size (usually in a
	 * mouseDragged() MouseMotionListener).
	 * @param p
	 */
	public void drag(Point p) {
		sizeX = p.x - originX;
		sizeY = sizeX;
		setBounds(bounds);
	}

	/**
	 * Called repeatedly while moving an object (usually in a mouseDragged()
	 * MouseMotionListener).
	 * @param p
	 */
	public void move(Point p) {
		originX = p.x;
		originY = p.y;
		setBounds(bounds);
	}

	/**
	 * Update the bounding box. The Rectangle argument is typically but not
	 * always in this object. This is required for @method contains() to work.
	 * @param b
	 */
	public void setBounds(Rectangle b) {
		b.setBounds(originX, originY, sizeX, sizeY);
	}
	
	/**
     * Returns color of object.
     */
    public Color getColor() {
    	return color;
    }
    
    /**
     * Sets color
     * @param c
     */
    public void setColor(Color c) {
    	color = c;
    }

	/**
	 * Returns true if the point p is in the bounding box for this object. Might
	 * be used to select and/or move an object.
	 * @param p
	 * @return
	 */
	public boolean contains(Point p) {
		return bounds.contains(p);
	}

}
