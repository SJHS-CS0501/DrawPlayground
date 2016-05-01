/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ryley Danielson
 */

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
//import javax.swing.border.*;

public class ToolPanel extends JPanel implements ActionListener {
    // drawingType is updated throughout the ToolPanel and used to determine
    // what we are doing in DrawingPane

	
	public static int check;
	public static String po,po2,po3;
	public static File nameI;
	public JTextField points,points2,pic;
	
    
    public ToolPanel() {
        super();
        this.setSize( 50, 200 );
        this.setLayout( new GridLayout( 2,2 ) );
        this.setBorder( BorderFactory.createEtchedBorder() );
       
        KeyListener k = new kb();
        
        JButton button;
        ButtonGroup bg;
        
        bg = new ButtonGroup();
        JRadioButton Rectangle = new JRadioButton( "Rectangle" );
        JRadioButton Circle = new JRadioButton( "Circle" );
        JRadioButton Line = new JRadioButton( "Line" );
        JRadioButton Star = new JRadioButton( "= Star Points" );
        JRadioButton Polygon = new JRadioButton("= Custom Polygon");
        JRadioButton picture = new JRadioButton("Load Picture");
        //JRadioButton NoOperation = new JRadioButton( "Edit" );
        points = new JTextField("5");
        points2 = new JTextField("5");
        //pic = new JTextField("Image File Name Here");
       // NoOperation.setActionCommand("nop");
        Rectangle.setActionCommand( "rect" );
        Circle.setActionCommand( "cir" );
        Line.setActionCommand( "line" );
        Star.setActionCommand("star");
        Polygon.setActionCommand("poly");
        picture.setActionCommand("picN");
       // NoOperation.addActionListener(this);
        Rectangle.addActionListener( this );
        Circle.addActionListener( this);
        Line.addActionListener( this );
        Star.addActionListener( this );
        Polygon.addActionListener(this);
        picture.addActionListener(this);
      
        points.addKeyListener(k);
        points2.addKeyListener(k);
       // pic.addKeyListener(k);
        
        bg.add( Rectangle );
        bg.add( Circle );
        bg.add( Line );
        bg.add(Star);
        bg.add(Polygon);
        bg.add(picture);
       // bg.add(NoOperation);
        
        JPanel unitSelectionPanel = new JPanel();
        unitSelectionPanel.setLayout( new GridLayout( 2,1 ) );
        unitSelectionPanel.add( Rectangle );
        unitSelectionPanel.add( Circle);
        unitSelectionPanel.add( Line );
        unitSelectionPanel.add( points );
        unitSelectionPanel.add( Star );
        unitSelectionPanel.add(points2);
        unitSelectionPanel.add(Polygon);
        //unitSelectionPanel.add(pic);
        unitSelectionPanel.add(picture);
        
        //unitSelectionPanel.add(NoOperation);
        
        add(unitSelectionPanel);
        
       // po = points.getText();
        	
        	
        	//points.setText("Set to default of 5");

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
        	po = getPoints(points);
        	break;
        	
        case("poly"):
        	check = 6;
        	po2 = getPoints(points2);
        	break;
        	
        case("picN"):
        	check = 10;
        	JFileChooser s = new JFileChooser();
        	//s.setApproveButtonText("Open");
        	int retv = s.showOpenDialog(this);
    	
        	if(retv == JFileChooser.APPROVE_OPTION){
        		File name = s.getSelectedFile();
        		nameI = name;
        		System.out.println("I Loaded");
        	}
        	//po3 = getPoints(pic);
        	
        	break;
		
            default:
                System.out.println( "EVIL EVIL BAD PLACE" );
                System.exit(-1);
                break;
        }
    }
    
    
    public String getPoints(JTextField points){
    
    	String p = points.getText();
    	
    	
    	return p;
    }
    
    public class kb implements KeyListener{
    	
    	
    	
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
			//(Property change listener/ key listener
			 
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
			po = points.getText();
			po2 = points2.getText();
			//po3 = pic.getText();
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    }
    
}
