import java.awt.*;
import java.io.*;
import java.awt.geom.Line2D;

public class MyLine implements DrawingObject, Serializable {

	private static final long serialVersionUID = 1L;
	int sizeX, sizeY, originX, originY;
	int lastX, lastY;
	Rectangle boundingBox = new Rectangle();
	Color color;
	double contains;

	public MyLine() {
		sizeX = sizeY = originX = originY = 0;
		setBounds(boundingBox);
	}

	/**
	 * Bounds for rectangle surrounding line
	 * 
	 * @param oX
	 * @param oY
	 * @param sX
	 * @param sY
	 */
	public MyLine(int oX, int oY, int sX, int sY) {
		setBounds(boundingBox);
	}

	/**
	 * Actually drawing the shape
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(getColor());

		g2d.drawLine(originX, originY, sizeX, sizeY);
	}

	public void start(Point p) {
		originX = p.x;
		originY = p.y;
		lastX = p.x;
		lastY = p.y;
	}

	/**
	 * When user selects and moves line
	 */
	public void drag(Point p) {
		sizeX = p.x;
		sizeY = p.y;
		setBounds(boundingBox);
	}

	/**
	 * Translation of line
	 */
	public void move(Point p) {
		sizeX = sizeX - (originX - p.x);
		originX = p.x;
		sizeY = sizeY - (originY - p.y);
		originY = p.y;
		setBounds(boundingBox);
	}

	/**
	 * Only used with star
	 */
	public void doMath() {
	}

	/**
	 * A bounding box is not used for a line
	 */
	public void setBounds(Rectangle b) {
		// not using a bounding rectangle
		// b.setBounds( originX, originY, sizeX + 5, sizeY + 5 );
	}

	/**
	 * If point is contained then it will be selected
	 */
	public boolean contains(Point p) {
		contains = Line2D.ptSegDist(originX, originY, sizeX, sizeY, p.x, p.y);
		System.out.print("ptSegDis: " + contains);

		if (contains <= 5) {
			return true;
		} else {
			return false;
		}

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
