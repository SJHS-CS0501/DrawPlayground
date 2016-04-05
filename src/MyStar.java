import java.awt.*;
import java.util.ArrayList;

public class MyStar implements DrawingObject{

    ArrayList<Dimension> xValues = new ArrayList<Dimension>();
    ArrayList<Dimension> yValues = new ArrayList<Dimension>();
	int lines;
    int lastX, lastY;
    Rectangle bounds = new Rectangle();
	
	MyStar(){
		lines = 0;
		setBounds( bounds );
	}
	
	
	
	
	// use draw polygon
	// use circle as bound, points on inner and outer circle for points on star
	// math and stuff :'(
	
	
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
