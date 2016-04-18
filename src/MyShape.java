
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
	int five = 5;
	Color color;
	boolean fill;
	Polygon poly;
	// bounding box (needed for move)
	Rectangle bounds = new Rectangle();

	/**
	 * Create a new MyShape, all params initialized to zero.
	 */
	public MyShape(boolean b) {
		// NOP
		sizeX = sizeY = originX = originY = 0;
		poly = new Polygon();
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
		g2d.drawPolygon(poly);
		if(fill) {
			g2d.fillPolygon(poly);
		}
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
		doMathOrSomething();
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
		doMathOrSomething();
		setBounds(bounds);
	}

	/**
	 * Update the bounding box. The Rectangle argument is typically but not
	 * always in this object. This is required for @method contains() to work.
	 * 
	 * @param b
	 */
	public void setBounds(Rectangle b) {
		b = poly.getBounds();
	}

	/**
	 * Returns true if the point p is in the bounding box for this object. Might
	 * be used to select and/or move an object.
	 * 
	 * @param p
	 * @return
	 */
	public boolean contains(Point p) {
		return poly.contains(p);
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
	
	private void doMathOrSomething() {
		poly.reset();
		int x[] = { originX, (originX + sizeX), (originX + sizeY), (originX - sizeX), originX };
		int y[] = { originY, (originY - sizeY), originY + sizeX, (originY - sizeY), originY };
		poly.xpoints = x;
		poly.ypoints = y;
		poly.npoints = five;
	}

}
