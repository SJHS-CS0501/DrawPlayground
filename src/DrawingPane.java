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
import java.io.*;

public class DrawingPane extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
	public DrawingObject object;
	public static ArrayList<DrawingObject> myList = new ArrayList<DrawingObject>(); 
	//MyRectangle r;
	//MyCircle c;
	//MyTriangle t;
	//MyLine l;
	//MyStar s;
	
	/*
	 * Save image as .jpeg
	 * save to file so that it can be reopened
	 */
	
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
    	case(5):
    		for(int ctr = myList.size() - 1; ctr >= 0; ctr--) {
    			if(myList.get(ctr).contains(e.getPoint())) {
    				object = myList.get(ctr);
    				break;
    			}
    		}
    		break;
    	case(6):
    		Color c = null;
    		System.out.println(myList.size());
    		for(int otherCtr = 0; otherCtr < myList.size() - 1; otherCtr++) {
    			object = myList.get(otherCtr);
    			if(object.contains(e.getPoint())) {
    				c = ToolPanel.choose.getColor();
        			object.setColor(c);
    			}
    			
    			
    		}
    		break;
    	default:
    		break;
    	}
  
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       int x = e.getX();
 	   int y = e.getY();
       if(object != null) {
    	   if(ToolPanel.selection == 5) {
        	   object.move(e.getPoint());
        	   System.out.println("Moving");
           } else {
        	   object.drag(e.getPoint());
           }
    	   repaint();
    	   
       }
       
       
       
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
    public void save() {
    	 try {
    		 FileOutputStream otherStream = new FileOutputStream("foobar.dat");
    		 ObjectOutputStream objStream = new ObjectOutputStream(otherStream);
    		 
    		 for(int inc = 0; inc < myList.size(); inc++) {
    			 objStream.writeObject(myList.get(inc));
    		 }
    		 objStream.close();
    	 }
    	 catch(Exception e1) {
    		 e1.printStackTrace();
    	 }
    		 
    }
}
