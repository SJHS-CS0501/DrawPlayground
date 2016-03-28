
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woytek
 */
public class JMenuFrame extends JFrame implements ActionListener {
    
	DrawingPane dPane = new DrawingPane();
	ColorPicker pFrame;
	
    public JMenuFrame() {
        super("Draw Playground");
        
        pFrame = new ColorPicker();
        
        ToolPanel tPane = new ToolPanel();
        tPane.setDrawingPane(dPane);
        
        ColorPanel pPane = new ColorPanel(pFrame);
        
        dPane.setColorPanel(pPane);
        
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        JMenu subMenu;
                
        this.setLayout( new BorderLayout() );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        
        panel.add(tPane);
        panel.add(pPane);
        
        this.add(panel, BorderLayout.WEST);
        this.add( dPane, BorderLayout.CENTER );

        menuBar = new JMenuBar();
        
        menu = new JMenu( "File" );
        
        menuItem = new JMenuItem( "Exit" );
        menuItem.setActionCommand( "Quit" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuBar.add( menu );
        
        menu = new JMenu( "Edit" );
        
        menuItem = new JMenuItem( "Drag" );
        menuItem.setActionCommand( "MenuSomething" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Move" );
        menuItem.setActionCommand( "MenuAnother" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem( "Rectangle" );
        menuItem.setActionCommand( "add rectangle" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Circle" );
        menuItem.setActionCommand( "add circle" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Line" );
        menuItem.setActionCommand( "add line" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Star" );
        menuItem.setActionCommand( "add star" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Triangle" );
        menuItem.setActionCommand( "add triangle" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem( "Color Picker" );
        menuItem.setActionCommand( "picker" );
        menuItem.addActionListener( this );
        menu.add(menuItem);

        menuBar.add( menu );
        
        menuBar.add( Box.createHorizontalGlue() );
        
        menu = new JMenu( "Help" );
        menuItem = new JMenuItem( "About" );
        menuItem.setActionCommand( "MenuAbout" );
        menuItem.addActionListener( this );
        
        menu.add( menuItem );
        
        menuBar.add( menu );
        
        this.setJMenuBar( menuBar );
        
        //this.setSize( new Dimension(this.getPreferredSize() ) ); 
        this.setSize( 600, 600 );
        this.setVisible( true );
    }
    
    public void actionPerformed( ActionEvent e ) {

        switch( e.getActionCommand() ) {
            case "picker":
            	pFrame.setVisible(true);
            	break;
            case "Quit":
                System.out.println( "quit Pressed" );
                System.exit(0);
                break;
            default:
            	dPane.setMode(e.getActionCommand());
                break;
        }
    }
}
