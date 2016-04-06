/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woytek/Ryan Smith
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawingPane extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
	public DrawingObject object;
	public ArrayList<DrawingObject> myList = new ArrayList<DrawingObject>(); 
	//MyRectangle r;
	//MyCircle c;
	//MyTriangle t;
	//MyLine l;
	//MyStar s;
	
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
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // handle what happens when the mouse is clicked. This will hinge upon
        // the mode the user has selected in the tool panel.
    	switch(ToolPanel.selection) {
    	case(0):
    		object = new MyRectangle();
    		myList.add(object);
			object.start(e.getPoint());
			
    		break;
    	case(1):
    		object = new MyCircle();
    		myList.add(object);
			object.start(e.getPoint());
			
    		break;
    	case(3):
    		object = new MyLine();
    		myList.add(object);
			object.start(e.getPoint());
			
    		break;
    	case(4):
    		object = new MyStar();
    		myList.add(object);
    		object.start(e.getPoint());
    		
    		break;
    	default:
    		break;
    	}
  
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       int x = e.getX();
       int y = e.getY();
       object.drag(e.getPoint());
       repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    	object = null;
        repaint();
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
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	for(int counter = 0; counter < myList.size(); counter++) {
    		myList.get(counter).draw(g);
    	}
    }
}
