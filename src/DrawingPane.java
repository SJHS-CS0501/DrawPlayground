/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woytek
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawingPane extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
	public DrawingObject obj = null;
    public ArrayList<DrawingObject> objList = new ArrayList<DrawingObject>(); 
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

        System.out.println( "mousePressed()" );
        switch( ToolPanel.buttonSelected ){
        
        case(0):
        	
        	obj = new MyRectangle();
        	objList.add(obj);
            obj.start(e.getPoint());
			
        	break;
        case(1):
        	
        	break;
        case(2):
        	
        	break;
        case(3):
        	
        	break;
        }
       
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       int x = e.getX();
       int y = e.getY();
       obj.drag(e.getPoint());
        System.out.println( "mouseDragged( " + x + ", " + y + " )" );
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println( "mouseReleased()" );
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
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	for(int ctr= 0; objList.size() <= ctr; ctr++){
    	objList.get(ctr).draw(g);
    	}
    }
}
