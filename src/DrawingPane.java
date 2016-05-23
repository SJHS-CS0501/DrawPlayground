/*
 * 
 * 
 * @author woytek
 * @author Isabelle Schroeder
 */
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;

public class DrawingPane extends JPanel implements ActionListener, MouseMotionListener, MouseListener, Serializable {

    
	private static final long serialVersionUID = 1L;
	public String coolShape; // make a setter for this
	ArrayList<DrawingObject> objectList = new ArrayList<DrawingObject>();
	DrawingObject object;
	boolean avoidingHazards;

	public DrawingPane() {
    	
    	super(); // always call super() in an extended/derived class!
        //this.setSize( 500, 500 );
        //setSize( getPreferredSize() );
        // size is handled by parent pane placement in JFrame
        // make a border
        setBorder( BorderFactory.createLineBorder(Color.BLUE) );
        
        
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
                System.out.println( "EVIL BAD PLACE TWO" );
                System.exit(-1);
                break;
        }
    }
   

    @Override
    public void mouseClicked(MouseEvent e) {
    	//had a switch here at some point
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // handle what happens when the mouse is clicked. This will hinge upon
        // the mode the user has selected in the tool panel.

    	//use switch with drawing object
    	
    	Point mousePoint = e.getPoint();
    	
    	// sends for selected object to be drawn in selected color and repaints the whole shebang
    	switch( coolShape ){
    	case "rectangle":
    		object = new MyRectangle();
    		object.setColor(ToolPanel.soManyColors.getColor());
    		object.start( mousePoint );
    		repaint();
    		objectList.add(object);
    		break;
    	case "circle":
    		object = new MyCircle();
    		object.setColor(ToolPanel.soManyColors.getColor());
    		object.start( mousePoint );
    		repaint();
    		objectList.add(object);
    		break;
    	case "line":
    		object = new MyLine();
    		object.setColor(ToolPanel.soManyColors.getColor());
    		object.start( mousePoint );
    		repaint();
    		objectList.add(object);
    		break;
    	case "arc":
    		object = new MyArc();
    		object.setColor(ToolPanel.soManyColors.getColor());
    		object.start( mousePoint );
    		repaint();
    		objectList.add(object);
    		break;
    	case "star":
    		object = new MyStar();
    		object.setColor(ToolPanel.soManyColors.getColor());
    		object.start( mousePoint );
    		repaint();
    		objectList.add(object);
    		break;
    	case "string":
    		object = new MyString();
    		object.setColor(ToolPanel.soManyColors.getColor());
    		object.start( mousePoint );
    		repaint();
    		objectList.add(object);
    		break;
    	// moves the most recently made object if silly user clicks in several bounding boxes
    	case "move":
    		for( int i = objectList.size() - 1; i >= 0; i-- ){
    			if( objectList.get(i).contains( mousePoint ) ){
    				avoidingHazards = true;
    				object = objectList.get(i);
    			break;
    			}	
    		}
    		break;
    		default:
    			System.out.println( "NO HAPPINESS HERE" ); // :(
    	}
    }

    // allows for moving shape when clicked in said shape's bounding box.
    // otherwise, you get left over sass from when string didn't move properly :P
    @Override
    public void mouseDragged(MouseEvent e) {
    	Point p = e.getPoint();
    	
    	if( avoidingHazards ){
    		object.move( p );
    	} else {
    		try{ object.drag( p );
    		} catch(NullPointerException n){
    			System.out.println( "You tried to move the string again, didn't you?" );// sass, sass, sass
    		}	
    	}
    	
    	repaint();
    	// drag to make object real
    	
        System.out.println( "mouseDragged" + p.toString() );
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    	avoidingHazards = false;
    	object = null;
        System.out.println( "mouseReleased()" );
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
    
    // paints objects
    public void paintComponent( Graphics g ){
    	super.paintComponent(g);
    	for( int i = 0; i < objectList.size(); i++ ){
    		objectList.get(i).draw(g);
    	}
    }
    
    
}
