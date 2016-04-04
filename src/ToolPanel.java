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
//import javax.swing.border.*;

public class ToolPanel extends JPanel implements ActionListener {
    // drawingType is updated throughout the ToolPanel and used to determine
    // what we are doing in DrawingPane

	
	public static int check;
	
	
    
    public ToolPanel() {
        super();
        this.setSize( 50, 200 );
        this.setLayout( new GridLayout( 4, 2 ) );
        this.setBorder( BorderFactory.createEtchedBorder() );
        JButton button;
        ButtonGroup bg;
        
        bg = new ButtonGroup();
        JRadioButton Rectangle = new JRadioButton( "Rectangle" );
        JRadioButton Circle = new JRadioButton( "Circle" );
        JRadioButton Line = new JRadioButton( "Line" );
        JRadioButton Star = new JRadioButton( "Star" );
        Rectangle.setActionCommand( "rect" );
        Circle.setActionCommand( "cir" );
        Line.setActionCommand( "line" );
        Star.setActionCommand("star");
        Rectangle.addActionListener( this );
        Circle.addActionListener( this);
        Line.addActionListener( this );
        Star.addActionListener( this );
        
        bg.add( Rectangle );
        bg.add( Circle );
        bg.add( Line );
        bg.add(Star);
        
        JPanel unitSelectionPanel = new JPanel();
        unitSelectionPanel.setLayout( new GridLayout( 1,0 ) );
        unitSelectionPanel.add( Rectangle );
        unitSelectionPanel.add( Circle);
        unitSelectionPanel.add( Line );
        unitSelectionPanel.add( Star );
        
        add(unitSelectionPanel);

       this.setSize(20,20);
        this.setVisible( true );
    }
    

    
    public void actionPerformed( ActionEvent e ) {
        switch( e.getActionCommand() ) {
        
        case("rect"):
        	check = DrawingPane.rec;
        	break;
        	
        case("cir"):
        	check = DrawingPane.c;
        	break;
        	
        case("line"):
        	check = DrawingPane.l;
        	break;
        
        case("star"):
        	check = DrawingPane.s;
        	break;

            default:
                System.out.println( "EVIL EVIL BAD PLACE" );
                System.exit(-1);
                break;
        }
    }
}
