
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
 * The main JFrame for DrawPlayground
 * @author woytek
 * @author Ryan Luchs
 */
public class JMenuFrame extends JFrame implements ActionListener {
    
	DrawingPane dPane = new DrawingPane();
	ColorPicker pFrame;
	DrawPlaygroundHelpFrame hFrame;
	
    public JMenuFrame() {
        super("Draw Playground");
        
        pFrame = new ColorPicker();
        hFrame = new DrawPlaygroundHelpFrame();
        hFrame.setMode(DrawPlaygroundHelpFrame.MODE_ABOUT);
        
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
        
        menuItem = new JMenuItem( "New" );
        menuItem.setActionCommand( "clear" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Save" );
        menuItem.setActionCommand( "save" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Save As..." );
        menuItem.setActionCommand( "saveas" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem( "Exit" );
        menuItem.setActionCommand( "Quit" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuBar.add( menu );
        
        menu = new JMenu( "Edit" );
        
        menuItem = new JMenuItem( "Drag" );
        menuItem.setActionCommand( "drag" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Move" );
        menuItem.setActionCommand( "move" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Remove" );
        menuItem.setActionCommand( "remove" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Recolor" );
        menuItem.setActionCommand( "recolor" );
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
        
        menuItem = new JMenuItem( "Set BG Color" );
        menuItem.setActionCommand( "recolor bg" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
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
        
        menuItem = new JMenuItem( "Help" );
        menuItem.setActionCommand( "MenuHelp" );
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
            case "clear":
            	dPane.clear();
            	break;
            case "save":
            	dPane.save();
            	break;
            case "saveas":
            	dPane.saveAs();
            	break;
            case "recolor bg":
            	dPane.setBackground(pFrame.getColor());
            	break;
            case "MenuAbout":
            	hFrame.setMode(DrawPlaygroundHelpFrame.MODE_ABOUT);
            	hFrame.setVisible(true);
            	break;
            case "MenuHelp":
            	hFrame.setMode(DrawPlaygroundHelpFrame.MODE_HELP);
            	hFrame.setVisible(true);
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
