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
	
    public ToolPanel() {
        super();
        this.setSize( 50, 200 );
        this.setLayout( new GridLayout( 4, 2 ) );
        this.setBorder( BorderFactory.createEtchedBorder() );
        JRadioButton square = new JRadioButton("Draw Square");
        square.setMnemonic(KeyEvent.VK_B);
        square.setActionCommand("Draw Square");
        
        
        JRadioButton line = new JRadioButton("Draw Line");
        line.setMnemonic(KeyEvent.VK_B);
        line.setActionCommand("Draw Line");
        
        JRadioButton circle = new JRadioButton("Draw Circle");
        circle.setMnemonic(KeyEvent.VK_B);
        circle.setActionCommand("Draw Circle");
        
        JRadioButton star = new JRadioButton("Draw Star");
        star.setMnemonic(KeyEvent.VK_B);
        star.setActionCommand("Draw Star");
        
        JRadioButton move = new JRadioButton("Move Shape");
        line.setMnemonic(KeyEvent.VK_B);
        move.setActionCommand("Move Shape");
      
        ButtonGroup shapes = new ButtonGroup();
        shapes.add(square);
        shapes.add(line);
        shapes.add(circle);
        shapes.add(star);
        shapes.add(move);
        
        add(square);
        add(line);
        add(circle);
        add(star);
        add(move);
        
        square.addActionListener(this);
        line.addActionListener(this);
        circle.addActionListener(this);
        star.addActionListener(this);
        move.addActionListener(this);
        
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
        default:
             System.out.println( "EVIL EVIL BAD PLACE" );
             System.exit(-1);
             break;
        }
    }
}



