import java.awt.*;
import java.io.*;

public class MyRectangle implements DrawingObject, Serializable {

	private static final long serialVersionUID = 1L;
	// critical variables for a rectangle
	int sizeX, sizeY, originX, originY;
	// future use
	int lastX, lastY;
	// bounding box (needed for move)
	Rectangle boundingBox = new Rectangle();
	Color color;

	/**
	 * Create a new MyRectangle, all parameters initialized to zero.
	 */
	public MyRectangle() {
		// NOP
		sizeX = sizeY = originX = originY = 0;
		setBounds(boundingBox);
	}

	/**
	 * Create a new MyRectangle with parameters initialized for origin and size
	 * 
	 * @param oX
	 * @param oY
	 * @param sX
	 * @param sY
	 */
	public MyRectangle(int sX, int sY, int oX, int oY) {
		setBounds(boundingBox);
	}

	/**
	 * Draw method actually draws the object. Requires Graphics object.
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;

		graphics.setColor(getColor());
		
		graphics.drawRect(originX, originY, sizeX, sizeY);
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
		setBounds(boundingBox);
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
		setBounds(boundingBox);
	}

	/**
	 * Only used with star
	 */
	public void doMath() {
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
		return boundingBox.contains(p);
	}

	/**
	 * Called to set the color of a shape
	 */
	public void setColor(Color c) {
		color = c;
	}

	/**
	 * Called to get the color of a shape
	 */
	public Color getColor() {
		return color;
	}
}
