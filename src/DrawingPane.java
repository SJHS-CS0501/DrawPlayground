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
	
	int x;
	int y;
	int a;
	int b;
	DrawingObject obj;
	private ArrayList<DrawingObject> drob;
	
	public static final int l = 1;
	public static final int rec = 2;
	public static final int s = 3;
	public static final int c = 4;
    
    public DrawingPane() {
        super(); 
        
        drob = new ArrayList<DrawingObject>();
        
        // always call super() in an extended/derived class!
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
    	
    	if(obj != null){
    		//obj.draw(getGraphics());
    		//drob.add(obj);
    	}
    	
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // handle what happens when the mouse is clicked. This will hinge upon
        // the mode the user has selected in the tool panel.

    	x = e.getX();
    	y = e.getY();
    	//a
    	//b
    	
    	if(ToolPanel.check == rec){
    		obj = new MyRectangle();
    	}else if(ToolPanel.check == c){
    		obj = new MyCircle();
    	}else if(ToolPanel.check == l) {
    		obj = new MyLine(x,y,x,y);
    	}else if(ToolPanel.check == s) {
    		//int[] q = {x, x+12, x+54,x+18,x+28,x, x-28, x-18, x-54, x-12};
    		//int[] w = {y, y+36, y+36, y+54, y+96, y+72, y+96, y+54, y+36, y+36 };
    		obj = new MyStar();
    	}
    	
    	if(obj != null){
    		//obj.draw(getGraphics());
    		obj.start(e.getPoint());
    		drob.add(obj);
    	}
    	

        System.out.println( "mousePressed" );
        
        repaint();
        
        
  
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       x = e.getX();
       y = e.getY();
       
       if(obj!=null){
    	   obj.drag(e.getPoint());
       }
       
       System.out.println( "mouseDragged " + "(" +x + " " +y+ ")"  );
        //paintComponent(getGraphics());
       
       repaint();
    }

    /*
    public Point getMouseLocation(){
    	
    	Point location = new Point(x,y);
    	
    	return location;
    }
    */
    
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println( "mouseReleased()" );
        
        obj = null;
        
        return;
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
    	
    	for(int i = 0; i<drob.size(); i++){
    		
    		drob.get(i).draw(g);
    	}
    }
    
}
