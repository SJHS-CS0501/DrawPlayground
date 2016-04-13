
/**
 * This class is designed to enable a user to
 * create a polymorphic shape.
 * @author Jack Protivnak
 */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MyShape implements DrawingObject {
	int sizeX, sizeY, originX, originY;
	// future use
	int lastX, lastY;
	Color color;
	boolean fill;
	// bounding box (needed for move)
	Rectangle bounds = new Rectangle();

	/**
	 * Create a new MyShape, all params initialized to zero.
	 */
	public MyShape(boolean b) {
		// NOP
		sizeX = sizeY = originX = originY = 0;
		setBounds(bounds);
		fill = b;
	}

	/**
	 * Create a new MyShape with params initialized for origin and size.
	 * 
	 * @param oX
	 * @param oY
	 * @param sX
	 * @param sY
	 */
	public MyShape(int oX, int oY, int sX, int sY) {
		sizeX = sX;
		sizeY = sY;
		originX = oX;
		originY = oY;
		setBounds(bounds);

		System.out.println("Made shape: @" + oX + ", " + oY + "; " + sX + " x " + sY);
	}

	/**
	 * Draw method actually draws the object. Requires Graphics object.
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(getColor());
		drawShape(g, originX, originY, sizeX, sizeY);
		System.out.println("Redrawing shape @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
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
		lastX = p.x;
		lastY = p.y;
	}

	/**
	 * Called repeatedly while dragging an object to size (usually in a
	 * mouseDragged() MouseMotionListener).
	 * 
	 * @param p
	 */
	public void drag(Point p) {
		sizeX = p.x - originX;
		sizeY = p.y - originY;
		setBounds(bounds);
	}

	/**
	 * Called repeatedly while moving an object (usually in a mouseDragged()
	 * MouseMotionListener).
	 * 
	 * @param p
	 */
	public void move(Point p) {
		movePolygon(p);
		setBounds(bounds);
	}

	/**
	 * Update the bounding box. The Rectangle argument is typically but not
	 * always in this object. This is required for @method contains() to work.
	 * 
	 * @param b
	 */
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

	/**
	 * Returns color of object.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets color
	 * 
	 * @param c
	 */
	public void setColor(Color c) {
		color = c;
	}

	/**
	 * This will do the math involved in setting the points inside the arrays so
	 * drawPolygon() can create a shape.
	 * 
	 * @param g
	 * @param ox
	 * @param oy
	 * @param hx
	 * @param hy
	 */
	public void drawShape(Graphics g, int ox, int oy, int hx, int hy) {
		int x[] = { ox, (ox + hx), (ox + hy), (ox - hx), ox };
		int y[] = { oy, (oy - hy), oy + hx, (oy - hy), oy };
		int five = 5;
		g.drawPolygon(x, y, five);
		if(fill) {
			g.fillPolygon(x, y, five);
		}

	}

}
