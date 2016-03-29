/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jack Protivnak
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.border.*;
import javax.swing.border.EtchedBorder;

public class ToolPanel extends JPanel implements ActionListener {
    // drawingType is updated throughout the ToolPanel and used to determine
    // what we are doing in DrawingPane
	
	private static final long serialVersionUID = 1;
	private JButton button;
	private JPanel shapes;

    
    public ToolPanel() {
        super("ToolPanel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize( 50, 200 );
        this.setLayout( new GridLayout(2,2) );
        this.setBorder(BorderFactory.createEmptyBorder());
        
        shapes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Shapes"));
        
        button = new JButton("Square");
        button.setActionCommand("square");
        button.addActionListener(this);
        shapes.add(button);
        
        button = new JButton("Star");
        button.setActionCommand("star");
        button.addActionListener(this);
        shapes.add(button);
        
        button = new JButton("Circle");
        button.setActionCommand("circle");
        button.addActionListener(this);
        shapes.add(button);

        button = new JButton("Line");
        button.setActionCommand("line");
        button.addActionListener(this);
        shapes.add(button);
        
        add(shapes);
    
        this.getPreferredSize();
        this.setVisible( true );
    }
    

    
    public void actionPerformed( ActionEvent e ) {
        switch( e.getActionCommand() ) {

            default:
                System.out.println( "EVIL EVIL BAD PLACE" );
                System.exit(-1);
                break;
        }
    }
}
