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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * The drawing surface for DrawPlayground
 * @author woytek
 * @author Ryan Luchs
 *
 */
public class DrawingPane extends JPanel implements ActionListener, MouseMotionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	
	// list of shapes to draw to the screen
	private ArrayList<DrawingObject> shapes = new ArrayList<DrawingObject>();
	
	// currently selected shape
	private DrawingObject select;
	
	// mouse position
	private Point mouse;
	
	// changes how the object reacts to mouse events
	private String mode = "default";
	
	// the filename to save as
	private String filename;
	
	// a color panel to get colors from
	private ColorPanel picker;
	
	/**
	 * DrawingPane constructor
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
     * @param e the event
     */
    public void actionPerformed( ActionEvent e ) {
        switch( e.getActionCommand() ) {
            default:
                System.out.println( "EVIL BAD PLACE TWO" );
                System.exit(-1);
                break;
        }
    }
    
    /**
     * Clears the drawing pane
     */
    public void clear() {
    	shapes.clear();
    	repaint();
    }
    
    /**
     * Sets the pane's mode
     * This should be fed action events from a ToolPane
     * @param mode The mode
     */
    public void setMode(String mode) {
    	this.mode = mode;
    }
    
    /**
     * Sets the ColorPanel to get colors from
     * @param p The ColorPanel
     */
    public void setColorPanel(ColorPanel p) {
    	picker = p;
    }
    
    /**
     * Draws the DrawingObjects to the screen
     */
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	for(int i = 0; i < shapes.size(); i++) {
    		shapes.get(i).draw(g);
    	}
    }
    
    
    
    /**
     * Exports the contents of the DrawingPane to a .png file
     */
    public void save() {
    	if(filename == null) {
    		saveAs();
    	} else {
			BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
	    	Graphics2D g = image.createGraphics();
	    	printAll(g);
	    	g.dispose();
	    	try { 
	    	    ImageIO.write(image, "png", new File("pictures/" + filename)); 
	    	} catch (IOException e) {
	    	    e.printStackTrace();
	    	}
    	}
    }
    
    /**
     * Exports the contents of the DrawingPane to a .png file named by the user
     */
    public void saveAs() {
    	
    	filename = JOptionPane.showInputDialog(this, "Filename:");
    	
    	File file = new File("pictures/" + filename);
    	
    	if(file.exists())  {
    		if(JOptionPane.showConfirmDialog(this, "A file with this name already exists. Do you wish to overwrite it?", "Save As", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    			BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
    	    	Graphics2D g = image.createGraphics();
    	    	printAll(g);
    	    	g.dispose();
    	    	try { 
    	    	    ImageIO.write(image, "png", file); 
    	    	} catch (IOException e) {
    	    	    e.printStackTrace();
    	    	}
    		}
    	} else {
    		BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
	    	Graphics g = image.createGraphics();
	    	paintComponent(g);
	    	g.dispose();
	    	try { 
	    	    ImageIO.write(image, "png", file); 
	    	} catch (IOException e) {
	    	    e.printStackTrace();
	    	}
    	}
    }

    /**
     * Reacts to mouse clicks
     */
    public void mouseClicked(MouseEvent e) {
    	mouse = e.getPoint();
    	
    	// for adding new shapes
    	if(mode.contains("add")) {
    		DrawingObject s;
    		
    		switch(mode) {
    			case "add rectangle":
    				s = new MyRectangle();
    				break;
    			case "add circle":
    				s = new MyCircle();
    				break;
    			case "add line":
    				s = new MyLine();
    				break;
    			case "add star":
    				s = new MyPentagram();
    				break;
    			case "add triangle":
    				s = new MyTriangle();
    				break;
    			default:
    				s = new MyRectangle();
    				break;
    		} 
    		
    		s.start(mouse);
    		s.setColor(picker.getColor());
    		
    		shapes.add(s);
    		select = shapes.get(shapes.size() - 1);
    		
    		repaint();
    		
    	} else {
    		for(int i = 0; i < shapes.size(); i++) {
    			if(shapes.get(i).contains(mouse)) {
    				select = shapes.get(i);
    			}
    		}
    		
    		if(mode.equals("remove")) {
    			shapes.remove(select);
    			repaint();
    		}
    		
    		if(mode.equals("recolor")) {
    			select.setColor(picker.getColor());
    			repaint();
    		}
    	}
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // handle what happens when the mouse is clicked. This will hinge upon
        // the mode the user has selected in the tool panel.
  
    }

    /**
     * Reacts to mouse drags
     */
    public void mouseDragged(MouseEvent e) {
    	// get mouse position
    	mouse = e.getPoint();
    	
    	// change what operation is performed on the selected DrawingObjects
    	if(select != null) {
    		if(mode.contains("add")) {
    			// allow resizing of the most recently created DrawingObject
    			select.drag(mouse);
    		} else {
    			switch(mode) {
		    		case "drag":
		    			// resize selected DrawingObject
		    			select.drag(mouse);
		    			break;
		    		case "move":
		    			// move selected DrawingObject
		    			select.move(mouse);
		    			break;
		    		default:
		    			break;
    			}
    		}
    	}
    	
    	this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    	
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
