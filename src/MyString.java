import java.awt.*;


public class MyString implements DrawingObject{
	
	String string;
	int originX, originY, sizeX, sizeY;
	int lastX, lastY;
    Rectangle bounds = new Rectangle();
    
    public MyString(){
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
