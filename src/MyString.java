import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MyString {
	
	String string;
	int originX, originY, sizeX, sizeY;
	int lastX, lastY;
    Rectangle bounds = new Rectangle();
    
    public MyString(){
    	sizeX = sizeY = originX = originY = 0;
        setBounds( bounds );
    }

	private void setBounds(Rectangle bounds2) {
		
	}
}
