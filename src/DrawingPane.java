import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawingPane extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
	
	static int sizeX, sizeY, originX, originY;
	static int lastX, lastY;

    public DrawingPane() {
        super(); // always call super() in an extended/derived class!
        //this.setSize( 500, 500 );
        //setSize( getPreferredSize() );
        // size is handled by parent pane placement in JFrame
        
        // make a border
        setBorder( BorderFactory.createLineBorder(Color.BLACK) );
        setVisible( true );
        
        // we need both a mouse listener (for clicks)...
        addMouseListener( this );
        // ... and a mouse motion listener (for drags)!
        addMouseMotionListener( this );

    }
    
    /**
     * actionPerformed is here in case we need it later. Not currently used.
     * @param e 
     */
    public void actionPerformed( ActionEvent e ) {
        switch( e.getActionCommand() ) {
            default:
                System.out.println( "You messed up if you're here" );
                System.exit(-1);
                break;
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // handle what happens when the mouse is clicked. This will hinge upon
        // the mode the user has selected in the tool panel.
    	int x = e.getX();
    	int y = e.getY();
    	originX = e.getX();
    	originY = e.getY();
        System.out.println( "mousePressed(" + x + "," + y + ")" );
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       int x = e.getX();
       int y = e.getY();
       sizeX = e.getX();
       sizeY = e.getY();
       System.out.println( "mouseDragged(" + x + "," + y + ")" );
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    	int x = e.getX();
        int y = e.getY();
    	lastX = e.getX();
        lastY = e.getY();
        System.out.println( "mouseReleased(" + x + "," + y + ")" );
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
