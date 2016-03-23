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

    
    public ToolPanel() {
        super();
        this.setSize( 50, 200 );
        this.setLayout( new GridLayout( 4, 2 ) );
        this.setBorder( BorderFactory.createEtchedBorder() );
        JButton button;
        
        button = new JButton("Draw rectangle");
        button.setActionCommand("Rectangle");
        button.addActionListener(this);
        add(button);
        
        button = new JButton("Draw circle");
        button.setActionCommand("Circle");
        button.addActionListener(this);
        add(button);
        
        button = new JButton("Draw triangle");
        button.setActionCommand("Triangle");
        button.addActionListener(this);
        add(button);
        
        button = new JButton("Draw line");
        button.setActionCommand("Line");
        button.addActionListener(this);
        add(button);
        
        button = new JButton("Draw star");
        button.setActionCommand("Star");
        button.addActionListener(this);
        add(button);
        
        button = new JButton("NOP");
        add(button);
        
        button = new JButton("NOP");
        add(button);
        
        button = new JButton("NOP");
        add(button);
    
        this.setVisible( true );
    }
    

    
    public void actionPerformed( ActionEvent e ) {
        switch( e.getActionCommand() ) {
        case "Rectangle":
        	break;
        case "Circle":
        	break;
        case "Triangle":
        	break;
        case "Line":
        	break;
        case "Star":
        	break;
            default:
                System.out.println( "EVIL EVIL BAD PLACE" );
                System.exit(-1);
                break;
        }
    }
}
