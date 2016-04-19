import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Julianna Nichols
 * @author woytek
 */
public class JMenuFrame extends JFrame implements ActionListener {
   
	private static final long serialVersionUID = 1L;

	public JMenuFrame() {
        super();
        DrawingPane dPane = new DrawingPane();
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
        
        menu = new JMenu( "Shapes" ); //title
        menuItem = new JMenuItem( "Circle" ); //menu item
        menuItem.setActionCommand( "Circle" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Rectangle" ); //item
        menuItem.setActionCommand( "Rectangle" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem( "Exit" ); //item
        menuItem.setActionCommand( "Quit" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuBar.add( menu );
        
        menu = new JMenu( "Color" ); //title
        menuItem = new JMenuItem( "Red" ); //item
        menuItem.setActionCommand( "Red" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        //menu.addSeparator();
        
        menuItem = new JMenuItem( "Orange" ); //item
        menuItem.setActionCommand( "Orange" );
        menuItem.addActionListener( this );
        menu.add( menuItem );
        
        subMenu = new JMenu( "SubMenu" ); //title of submenu
        menuItem = new JMenuItem( "SubFoo" ); //item in submenu
        menuItem.setActionCommand( "MenuSubFoo" );
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
        
        menuBar.add( menu );
        
        this.setJMenuBar( menuBar );
        
        //this.setSize( new Dimension(this.getPreferredSize() ) ); 
        this.setSize( 600, 600 );
        this.setVisible( true );
    }
    
    public void actionPerformed( ActionEvent e ) {

        switch( e.getActionCommand() ) {
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
            default:
                System.out.println( "I DON'T KNOW HOW YOU GOT HERE!!!!" );
                System.exit(-1);
                break;
        }
    }
    
}

