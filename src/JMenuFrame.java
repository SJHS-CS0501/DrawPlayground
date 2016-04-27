import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 *
 * @author Julianna Nichols
 * @author woytek
 */
public class JMenuFrame extends JFrame implements ActionListener, Serializable {
   
	private static final long serialVersionUID = 1L;
	DrawingPane dPane = new DrawingPane();
    ToolPanel tPane = new ToolPanel();

	public JMenuFrame() {
        super();
         
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
        
        menu = new JMenu( "File" ); //title
        menuItem = new JMenuItem( "New" ); //menu item
        menuItem.setActionCommand( "New" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Open File..." ); //item
        menuItem.setActionCommand( "Open File" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem( "Save" ); //item
        menuItem.setActionCommand( "Save" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem( "Exit" ); //item
        menuItem.setActionCommand( "Quit" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuBar.add( menu );
        
        menu = new JMenu( "Other Options" ); //title
        menuItem = new JMenuItem( "Red" ); //item
        menuItem.setActionCommand( "Red" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Orange" ); //item
        menuItem.setActionCommand( "Orange" );
        menuItem.addActionListener( this );
        menu.add( menuItem );
        
        subMenu = new JMenu( "Star Points" ); //title of submenu
        menuItem = new JMenuItem( "Five (5)" ); //item in submenu
        menuItem.setActionCommand( "Five" );
        menuItem.addActionListener( this );
        subMenu.add( menuItem );
        
        menuItem = new JMenuItem( "Six (6)" ); //item in submenu
        menuItem.setActionCommand( "Six" );
        menuItem.addActionListener( this );
        subMenu.add( menuItem );
        
        menuItem = new JMenuItem( "Seven (7)" ); //item in submenu
        menuItem.setActionCommand( "Seven" );
        menuItem.addActionListener( this );
        subMenu.add( menuItem );
        
        menuItem = new JMenuItem( "Eight (8)" ); //item in submenu
        menuItem.setActionCommand( "Eight" );
        menuItem.addActionListener( this );
        subMenu.add( menuItem );
        
        menuItem = new JMenuItem( "Special" ); //item in submenu
        menuItem.setActionCommand( "Special" );
        menuItem.addActionListener( this );
        subMenu.add( menuItem );
        
        menu.add(subMenu);
        
        menuBar.add( menu );
        
        menuBar.add( Box.createHorizontalGlue() );
        
        menu = new JMenu( "Help" );
        menuItem = new JMenuItem( "About" );
        menuItem.setActionCommand( "About" );
        menuItem.addActionListener( this );
        menu.add( menuItem );
        
        menuItem = new JMenuItem( "How to..." );
        menuItem.setActionCommand( "How to" );
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
            case "New":
                System.out.println( "'New' Pressed" );
                break;
            case "Open File":
                System.out.println( "'Open File' Pressed" );
                break;
            case "Save":
            	BufferedImage img = new BufferedImage(1400, 1000, BufferedImage.TYPE_INT_RGB);
                dPane.print(img.getGraphics()); // or: panel.printAll(...);
                try {
                    ImageIO.write(img, "jpg", new File("panel.jpg"));
                    System.out.print("Image saved.");
                }
                catch (IOException c) {
                    System.out.print("Image not saved.");
                }
                break;
            case "Five":
                System.out.println( "'Five' Pressed" );
                break;
            case "Six":
                System.out.println( "'Six' Pressed" );
                break;
            case "Seven":
                System.out.println( "'Seven' Pressed" );
                break;
            case "Eight":
                System.out.println( "'Eight' Pressed" );
                break;
            case "Special":
                System.out.println( "'Special' Pressed" );
                break;
            case "About":
                System.out.println( "'About' Pressed" );
                System.exit(0);
                break;
            case "How to":
                System.out.println( "'How to' Pressed" );
                System.exit(0);
                break;
            case "Quit":
                System.out.println( "'Quit' Pressed" );
                System.exit(0);
                break;
            default:
                System.out.println( "You done messed up." );
                System.exit(-1);
                break;
        }
    }    
}

