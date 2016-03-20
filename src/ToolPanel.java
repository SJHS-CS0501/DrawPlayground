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
import javax.swing.*;
//import javax.swing.border.*;

public class ToolPanel extends JPanel implements ActionListener {
    // drawingType is updated throughout the ToolPanel and used to determine
    // what we are doing in DrawingPane
	
	private static final long serialVersionUID = 1L;
	
	private DrawingPane canvas;
    
	/**
	 * ToolPanel constructor
	 */
    public ToolPanel() {
        super();
        this.setSize( 50, 200 );
        this.setLayout( new GridLayout( 6, 1 ) );
        this.setBorder( BorderFactory.createEtchedBorder() );
        
        JButton button;
        
        button = new JButton("Drag");
        button.setActionCommand("drag");
        button.addActionListener(this);
        add(button);
        
        button = new JButton("Move");
        button.setActionCommand("move");
        button.addActionListener(this);
        add(button);
        
        button = new JButton("Rectangle");
        button.setActionCommand("add rectangle");
        button.addActionListener(this);
        add(button);
        
        button = new JButton("Oval");
        button.setActionCommand("add oval");
        button.addActionListener(this);
        add(button);
        
        button = new JButton("Line");
        button.setActionCommand("add line");
        button.addActionListener(this);
        add(button);
        
        button = new JButton("Star");
        button.setActionCommand("add star");
        button.addActionListener(this);
        add(button);
    
        this.setVisible(true);
    }
    
    /**
     * Sets the DrawingPane that this ToolPanel sends events to
     * @param c The DrawingPane
     */
    public void setDrawingPane(DrawingPane c) {
    	canvas = c;
    }
    
    public void actionPerformed( ActionEvent e ) {
    	canvas.setMode(e.getActionCommand());
    }
}
