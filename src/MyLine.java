import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * 
 */

/**
 * @author Ryan Smith
 *
 */
public class MyLine implements DrawingObject{

	@Override
	public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor( Color.BLACK );
		
	}

	@Override
	public void start(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drag(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBounds(Rectangle b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

}
