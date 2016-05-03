import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

/**
 * This class is used to create the menu bar that appears
 * at the top of the entire frame.
 * @author Jack Protivnak
 */
public class JMenuFrame extends JFrame implements ActionListener, Serializable {
	
	public static final long serialVersionUID = 1;
	private DrawingPane dPane;
    
    public JMenuFrame() {
        super();
        dPane = new DrawingPane();
        ToolPanel tPane = new ToolPanel();
        
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        JMenu subMenu;
                
        this.setLayout( new BorderLayout() );
        this.setName( "Jay Manue Teeest Frum");
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        this.add( tPane, BorderLayout.WEST );
        this.add( dPane, BorderLayout.CENTER );

        menuBar = new JMenuBar();
        
        menu = new JMenu( "My Menu" );
        
        menuItem = new JMenuItem( "New" );
        menuItem.setActionCommand( "new" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Open" );
        menuItem.setActionCommand( "open" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Save" );
        menuItem.setActionCommand( "save" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Save Image" );
        menuItem.setActionCommand("saveImage");
        menuItem.addActionListener(this);
        menu.add(menuItem);
       
        menu.addSeparator();
        
        menuItem = new JMenuItem( "Exit" );
        menuItem.setActionCommand( "Quit" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuBar.add( menu );
        
        menuBar.add( Box.createHorizontalGlue() );
        
        menu = new JMenu( "Help" );
        menuItem = new JMenuItem( "About" );
        menuItem.setActionCommand( "about" );
        menuItem.addActionListener( this );
        
        menu.add( menuItem );
        
        menuBar.add( menu );
        
        this.setJMenuBar( menuBar );
        
        //this.setSize( new Dimension(this.getPreferredSize() ) ); 
        this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        this.setVisible( true );
    }
    
    /**
     * Action Listener for the different options within the JMenu.
     */
    public void actionPerformed( ActionEvent e ) {

        switch( e.getActionCommand() ) {
        	case "new":
        		dPane.clear();
        		break;
        	case "save":
        		dPane.writeFile();
        		break;
        	case "saveImage":
        		dPane.saveImage();
        		break;
        	case "open":
        		dPane.openFile();
        		break;
            case "MenuSomething":
                System.out.println( "Something Pressed" );
                break;
            case "MenuAnother":
                System.out.println( "Another Pressed" );
                break;
            case "Quit":
                System.out.println( "quit Pressed" );
                System.exit(0);
                break;
            case "about":
            	JOptionPane.showMessageDialog(null, "DRAWING PROGRAM\n™ and © 2016 Pro Inc. All Rights Reserved ®. License Agreement");
            	break;
            default:
                System.out.println( "I DON'T KNOW HOW YOU GOT HERE!!!!" );
                System.exit(-1);
                break;
        }
    }
}
