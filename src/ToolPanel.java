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
	
	public static int buttonSelected = 0;
	static JColorChooser colorChooser = new JColorChooser();
	static GridBagLayout layout; // variable for the gridbag layout
    public ToolPanel() {
        super();
        this.setSize( 50, 200 );

        layout = new GridBagLayout(); // creates a new GridBagLayout
		setLayout(layout); // sets the layout of myFrame according to GridBagLayout
		GridBagConstraints c = new GridBagConstraints(); // creates a new GridBagRestraint 
		GridBagConstraints chooser = new GridBagConstraints();
		// general constraints
		c.fill = GridBagConstraints.BOTH;
		
		// label constraints
		c.weightx = .5; // changes weight of label to receive less space
		c.weighty = 1;
		c.gridwidth = GridBagConstraints.NORTHEAST; // sets the label to be in the second to last column
		c.gridheight = GridBagConstraints.NORTHEAST;
		chooser.weightx = .5;
		chooser.weighty = .5;
		chooser.gridwidth = GridBagConstraints.SOUTHEAST;
		chooser.gridheight = GridBagConstraints.SOUTHEAST;
        JRadioButton square = new JRadioButton("Draw Square");
        square.setMnemonic(KeyEvent.VK_B);
        square.setActionCommand("Draw Square");
        layout.setConstraints(square, c); // more button constraints
		
        
        JRadioButton line = new JRadioButton("Draw Line");
        line.setMnemonic(KeyEvent.VK_B);
        line.setActionCommand("Draw Line");
        layout.setConstraints(line, c); // more button constraints
        
        JRadioButton circle = new JRadioButton("Draw Circle");
        circle.setMnemonic(KeyEvent.VK_B);
        circle.setActionCommand("Draw Circle");
        layout.setConstraints(circle, c); // more button constraints
        
        JRadioButton star = new JRadioButton("Draw Star");
        star.setMnemonic(KeyEvent.VK_B);
        star.setActionCommand("Draw Star");
        layout.setConstraints(star, c); // more button constraints
        
        JRadioButton move = new JRadioButton("Move Shape");
        move.setMnemonic(KeyEvent.VK_B);
        move.setActionCommand("Move Shape");
        layout.setConstraints(move, c); // more button constraints
        
        JRadioButton colorPicker = new JRadioButton("Color Chooser");
        colorPicker.setMnemonic(KeyEvent.VK_B);
        colorPicker.setActionCommand("Change Color");
        layout.setConstraints(colorPicker, c); // more button constraints
        
        layout.setConstraints(colorChooser, chooser);
        ButtonGroup shapes = new ButtonGroup();
        shapes.add(square);
        shapes.add(line);
        shapes.add(circle);
        shapes.add(star);
        shapes.add(move);
        shapes.add(colorPicker);
        
        add(square);
        add(line);
        add(circle);
        add(star);
        add(move);
        add(colorChooser);
        add(colorPicker);
        
        square.addActionListener(this);
        line.addActionListener(this);
        circle.addActionListener(this);
        star.addActionListener(this);
        move.addActionListener(this);
        colorPicker.addActionListener(this);
        
        this.setVisible( true );
        
    }
    

    
    public void actionPerformed( ActionEvent e) {
    	
        switch( e.getActionCommand() ) {
        case"Draw Square":
        	buttonSelected = 0;
        	break;
        case"Draw Circle":
        	buttonSelected = 1;
        	break;
        case"Draw Line":
        	buttonSelected = 2;
        	break;
        case"Draw Star":
        	buttonSelected = 3;
        	break;
        case"Move Shape":
        	buttonSelected = 4;
        	break;
        case"Change Color":
        	buttonSelected = 5;
        	break;
        default:
             System.out.println( "EVIL EVIL BAD PLACE" );
             System.exit(-1);
             break;
        }
    }
}



