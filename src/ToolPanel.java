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
	
MyRectangle r = new MyRectangle( 40, 40, 50 , 50 );
	
    
    public ToolPanel() {
        super();
        this.setSize( 50, 200 );
        this.setLayout( new GridLayout( 4, 2 ) );
        this.setBorder( BorderFactory.createEtchedBorder() );
        JButton button;
        JButton button1;
        JButton button2;
        JButton button3;
        button = new JButton("Draw Square");
        button1 = new JButton("Draw Line");
        button2 = new JButton("Draw Star");
        button3 = new JButton("Draw Cirle");
        button.setFont(new Font("TimesRoman", Font.ITALIC, 12));
		button1.setFont(new Font("TimesRoman", Font.ITALIC, 12));
		button2.setFont(new Font("TimesRoman", Font.ITALIC, 12));
		button3.setFont(new Font("TimesRoman", Font.ITALIC, 12));
        add(button);
        add(button1);
        add(button2);
        add(button3);
        button.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button.setActionCommand("Draw Square");
        this.setVisible( true );
        
    }
    

    
    public void actionPerformed( ActionEvent e ) {
        switch( e.getActionCommand() ) {
        case("Draw Square"):
        	rX = e.getX();
        
        	r.start();
        	r.draw(getGraphics());
        		break;
            default:
                System.out.println( "EVIL EVIL BAD PLACE" );
                System.exit(-1);
                break;
        }
    }
}
