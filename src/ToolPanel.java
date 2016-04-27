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
import javax.swing.*;
//import javax.swing.border.*;

public class ToolPanel extends JPanel implements ActionListener {
    // drawingType is updated throughout the ToolPanel and used to determine
    // what we are doing in DrawingPane
	MyRectangle r = new MyRectangle();
	MyCircle c = new MyCircle();
	MyLine l = new MyLine();
	MyStar s = new MyStar();
	static int selection;
	static JColorChooser choose = new JColorChooser();
    static GridBagLayout layout;
    public ToolPanel() {
        super();
        this.setSize( 50, 200 );
        layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraints foo = new GridBagConstraints();
        JRadioButton button;
        ButtonGroup group = new ButtonGroup();
        constraints.fill = GridBagConstraints.NONE;
        
        constraints.weightx = 5;
        constraints.weighty = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridheight = GridBagConstraints.BOTH;
        foo.weightx = 1;
        foo.weighty = .5;
        foo.gridwidth = GridBagConstraints.REMAINDER;
        foo.gridheight = GridBagConstraints.RELATIVE;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        foo.anchor = GridBagConstraints.LAST_LINE_START;
        
        button = new JRadioButton("Draw rectangle");
        button.setActionCommand("Rectangle");
        button.addActionListener(this);
        layout.setConstraints(button, constraints);
        add(button);
        group.add(button);
        
        button = new JRadioButton("Draw circle");
        button.setActionCommand("Circle");
        button.addActionListener(this);
        layout.setConstraints(button, constraints);
        add(button);
        group.add(button);
        
        button = new JRadioButton("Draw line");
        button.setActionCommand("Line");
        button.addActionListener(this);
        layout.setConstraints(button, constraints);
        add(button);
        group.add(button);
        
        button = new JRadioButton("Draw star");
        button.setActionCommand("Star");
        button.addActionListener(this);
        layout.setConstraints(button, constraints);
        add(button);
        group.add(button);
        
        button = new JRadioButton("Move");
        button.setActionCommand("Move");
        button.addActionListener(this);
        layout.setConstraints(button, constraints);
        add(button);
        group.add(button);
        
        button = new JRadioButton("Choose color");
        button.setActionCommand("Color");
        button.addActionListener(this);
        layout.setConstraints(button, constraints);
        add(button);
        group.add(button);
        
        
        
        
        
        add(choose);
        layout.setConstraints(choose, constraints);
        
    
        this.setVisible( true );
    }
    

    
    public void actionPerformed( ActionEvent e ) {
        switch( e.getActionCommand() ) {
        case "Rectangle":
        	selection = 0;
        	break;
        case "Circle":
        	selection = 1;
        	break;
        case "Line":
        	selection = 3;
        	break;
        case "Star":
        	selection = 4;
        	break;
        case "Move":
        	selection = 5;
        	break;
        case "Color":
        	selection = 6;
        	break;
            default:
                System.out.println( "You just did absolutely NOTHING!! Congratulations!" );
                System.exit(-1);
                break;
        }
    }
}
