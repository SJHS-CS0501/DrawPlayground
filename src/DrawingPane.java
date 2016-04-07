/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woytek
 * @author Isabelle Schroeder
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawingPane extends JPanel implements ActionListener, MouseMotionListener, MouseListener {

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String coolShape; // make a setter for this
	ArrayList<DrawingObject> objectList = new ArrayList<DrawingObject>();
	DrawingObject object;

	public DrawingPane() {
    	
    	super(); // always call super() in an extended/derived class!
        //this.setSize( 500, 500 );
        //setSize( getPreferredSize() );
        // size is handled by parent pane placement in JFrame
        // make a border
        setBorder( BorderFactory.createLineBorder(Color.RED) );
        
        
        
        
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
    	
    	switch( coolShape ){
    	case "rectangle":
    		object = new MyRectangle();
    		object.start( mousePoint );
    		repaint();
    		objectList.add(object);
    		break;
    	case "circle":
    		object = new MyCircle();
    		object.start( mousePoint );
    		repaint();
    		objectList.add(object);
    		break;
    	case "line":
    		object = new MyLine();
    		object.start( mousePoint );
    		repaint();
    		objectList.add(object);
    		break;
    	case "arc":
    		object = new MyArc();
    		object.start( mousePoint );
    		repaint();
    		objectList.add(object);
    		break;
    	case "star":
    		object = new MyStar();
    		object.start( mousePoint );
    		repaint();
    		objectList.add(object);
    		break;
    	case "string":
    		// joptionpane
    		object = new MyString();
    		object.start( mousePoint );
    		repaint();
    		objectList.add(object);
    		break;
    		default:
    			System.out.println( "NO HAPPINESS HERE" );
    	}
    	
    	
        System.out.println( "mousePressed" );
  
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    	Point p = e.getPoint();
    	
    	object.drag( p );
    	repaint();
    	// drag to make object real
    	
        System.out.println( "mouseDragged" + p.toString() );
    }

    @Override
    public void mouseReleased(MouseEvent e) {
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
    
    public void paintComponent( Graphics g ){
    	super.paintComponent(g);
    	for( int i = 0; i < objectList.size(); i++ ){
    		objectList.get(i).draw(g);
    	}
    }
    
    
}
