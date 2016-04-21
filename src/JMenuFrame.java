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
	
	private JFileChooser file;
	public static final long serialVersionUID = 1;
	FileOutputStream outStream;
	ObjectOutputStream outFile;
    
    public JMenuFrame() {
        super();
        DrawingPane dPane = new DrawingPane();
        ToolPanel tPane = new ToolPanel();
        file =  new JFileChooser();
        
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
        
        menuItem = new JMenuItem( "Save" );
        menuItem.setActionCommand( "save" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Do Something" );
        menuItem.setActionCommand( "MenuSomething" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Do Another Thing" );
        menuItem.setActionCommand( "MenuAnother" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem( "Exit" );
        menuItem.setActionCommand( "Quit" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuBar.add( menu );
        
        menu = new JMenu( "FOO" );
        
        menuItem = new JMenuItem( "Foo Thing" );
        menuItem.setActionCommand( "MenuFoo" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem( "Foo 2" );
        menuItem.setActionCommand( "MenuFoo2" );
        menuItem.addActionListener( this );
        menu.add( menuItem );
        
        subMenu = new JMenu( "SubMenu" );
        menuItem = new JMenuItem( "SubFoo" );
        menuItem.setActionCommand( "MenuSubFoo" );
        menuItem.addActionListener( this );
        subMenu.add( menuItem );
        
        menu.add(subMenu);
        
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
        this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        this.setVisible( true );
    }
    
    /**
     * Action Listener for the different options within the JMenu.
     */
    public void actionPerformed( ActionEvent e ) {

        switch( e.getActionCommand() ) {
        	case "save":
        		writeFile();
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
            default:
                System.out.println( "I DON'T KNOW HOW YOU GOT HERE!!!!" );
                System.exit(-1);
                break;
        }
    }
    
    public void writeFile() {
    	try{
    		outStream = new FileOutputStream("foo.dat");
    		outFile = new ObjectOutputStream(outStream);
    	} catch(Exception eq) {
    		System.out.println("Exception:" + eq.getMessage());
    	}
    	String sb = "TEST CONTENT";
	    file = new JFileChooser();
	    file.setCurrentDirectory(new File("Drawings"));
	    int retrival = file.showSaveDialog(null);
	    
	    if (retrival == JFileChooser.APPROVE_OPTION) {
	    	try(FileWriter fw = new FileWriter(file.getSelectedFile()+".jpg")) {
	    	    fw.write(sb.toString());
	    	} catch (Exception es) {
	    		System.out.println("Exception:" + es.getMessage());
	    	}
	    }
    	}
}
