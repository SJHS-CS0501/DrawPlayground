import java.awt.event.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

import javafx.scene.shape.Line;

public class MyStar implements DrawingObject {
	// critical vars for a rectangle
	int sizeX, sizeY, originX, originY;
	// future use
	int lastX, lastY;
	// bounding box (needed for move)
	Rectangle bounds = new Rectangle();
	// Line2D.Float bounds = new Line2D.Float();

	/**
	 * Create a new MyRectangle, all params initialized to zero.
	 */
	public MyStar() {
		// NOP
		sizeX = sizeY = originX = originY = 0;
		setBounds(bounds);
	}

	/**
	 * Create a new MyRectangle with params initialized for origin and size.
	 * 
	 * @param oX
	 * @param oY
	 * @param sX
	 * @param sY
	 */
	public MyStar(int oX, int oY, int sX, int sY) {
		sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
	}

	/**
	 * draw method actually draws the object. Requires Graphics object.
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.BLACK);
		// g2d.clearRect( originX, originY, sizeX, sizeY ); // this is cool to
		// make a background-filled rectangle!
		drawStar(g, originX, originY, sizeX, sizeY);

		System.out.println("Redrawing Line @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
		// this.setSize( this.getPreferredSize() );
	}

	/**
	 * Called to start drawing a new object when mouse is clicked.
	 * 
	 * @param p
	 */
	public void start(Point p) {
		originX = p.x;
		originY = p.y;
		sizeX = originX - p.x;
		sizeY = originY - p.y;
	}

	/**
	 * Called repeatedly while dragging an object to size (usually in a
	 * mouseDragged() MouseMotionListener).
	 * 
	 * @param p
	 */
	public void drag(Point p) {
		sizeX = p.x;
		sizeY = p.y;
		setBounds(bounds);
	}

	/**
	 * Called repeatedly while moving an object (usually in a mouseDragged()
	 * MouseMotionListener).
	 * 
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
	 * 
	 * @param b
	 */
	// public void setBounds( Line2D.Float b ) {
	// ((Line2D.Float)b).setBounds( (float) originX, (float) originY, (float)
	// sizeX, (float) sizeY );
	public void setBounds(Rectangle b) {
		b.setBounds(originX, originY, sizeX, sizeY);
	}

	/**
	 * Returns true if the point p is in the bounding box for this object. Might
	 * be used to select and/or move an object.
	 * 
	 * @param p
	 * @return
	 */
	public boolean contains(Point p) {
		return bounds.contains(p);
	}
	
	public void drawStar(Graphics g, int ox, int oy, int sx, int sy) {
		int x[] = {ox, (ox+120), ox+150, (ox+185), ox};
		int y[] = {oy, (oy+50), oy, (oy-120), oy};
		int five = 5;
		g.drawPolygon(x, y, five);
	}

}
