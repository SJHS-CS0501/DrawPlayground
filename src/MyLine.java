import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class MyLine implements DrawingObject{

    int sizeX, sizeY, originX, originY;
    int lastX, lastY;
    Rectangle bounds = new Rectangle();
	
    MyLine(){
    	sizeX = sizeY = originX = originY = 0;
    	setBounds( bounds );
    }
	
	@Override
	public void draw(Graphics g) {

		
	}

	@Override
	public void start(Point p) {

		
	}

	@Override
	public void drag(Point p) {
	
		
	}

	@Override
	public void move(Point p) {
	
		
	}

	@Override
	public void setBounds(Rectangle b) {
	
		
	}

	@Override
	public boolean contains(Point p) {
	
		return false;
	}

}
