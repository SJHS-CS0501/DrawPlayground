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

	public static final int l = 1;
	public static final int r = 2;
	public static final int s = 3;
	public static final int c = 4;
    
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
        unitSelectionPanel.setLayout( new GridLayout( 0, 3 ) );
        unitSelectionPanel.add( Rectangle );
        unitSelectionPanel.add( Circle);
        unitSelectionPanel.add( Line );
        unitSelectionPanel.add( Star );
        
        add(unitSelectionPanel, BorderLayout.NORTH);

       this.setSize(20,20);
        this.setVisible( true );
    }
    

    
    public void actionPerformed( ActionEvent e ) {
        switch( e.getActionCommand() ) {
        
        case("rect"):
        	
        	
        	
        	break;
        case("cir"):
        	break;
        case("line"):
        	break;
        case("star"):
        	break;

            default:
                System.out.println( "EVIL EVIL BAD PLACE" );
                System.exit(-1);
                break;
        }
    }
}
