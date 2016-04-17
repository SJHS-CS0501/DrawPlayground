
import java.awt.*;
import java.awt.event.*;
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
	int x = 1;
    int y = 2;
    static JColorChooser color;
    static ToolPanel tPane;
    //JPanel p
    
    public JMenuFrame() {
        super();
        DrawingPane dPane = new DrawingPane();
        tPane = new ToolPanel();
        color = new JColorChooser();
        JPanel p = new JPanel();
        
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        JMenu subMenu;
                
        this.setLayout( new BorderLayout() );
        this.setName( "Jay Manue Teeest Frum");
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        dPane.setPreferredSize(new Dimension(100,200));
        this.add(color, BorderLayout.SOUTH);
        this.add( tPane, BorderLayout.NORTH);
        this.add( dPane, BorderLayout.CENTER );
        color.setVisible(false);
        color.setColor(Color.BLACK);
        
        menuBar = new JMenuBar();
        
        menu = new JMenu( "My Menu" );
        
        menuItem = new JMenuItem( "Do Something" );
        menuItem.setActionCommand( "MenuSomething" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Draw Test Circle" );
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
        
        menu = new JMenu( "Colors" );
        menuItem = new JMenuItem( "Color Pane" );
        menuItem.setActionCommand("colorBox");
        menuItem.addActionListener(this);
        menu.add( menuItem );
        
        menuBar.add( menu );
        
        menu = new JMenu( "Shapes" );
        menuItem = new JMenuItem( "Tool Panel" );
        menuItem.setActionCommand("S&P");
        menuItem.addActionListener(this);
        menu.add( menuItem );
        
        menuBar.add( menu );
        
        menu = new JMenu( "Edit" );
        menuItem = new JMenuItem( "Move" );
        menuItem.setActionCommand("edit");
        menuItem.addActionListener(this);
        menu.add( menuItem );
        
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
        this.setSize( 900, 900 );
        
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
                
            case "colorBox":
            	if(color.isVisible() == true){
            		color.setVisible(false);
            	}else{
            	color.setVisible(true);
            	//tPane.setVisible(false);
            	}
            	break;
            	
            case "S&P":
            	if(tPane.isVisible() == true){
            		tPane.setVisible(false);
            	}else{
            	tPane.setVisible(true);
            	//tPane.setVisible(false);
            	}
                break;
                
            case "edit":
            	ToolPanel.check = 0;
            	tPane.setVisible(false);
            	color.setVisible(false);
                break;
                
            default:
                System.out.println( "I DON'T KNOW HOW YOU GOT HERE!!!!" );
                System.exit(-1);
                break;
        }
    }
    
    /**
     * Checks to see whether or not color frame is on
     * @return boolean
     */
    public static boolean isColorOn(){
    	return color.isVisible();
    }
    
    /**
     * Checks to see whether tool panel is on or not
     * @return
     */
    public static boolean isToolOn(){
    	return tPane.isVisible();
    	
    }
    
    /**
     * Returns a color from 
     * @return
     */
    public static Color getColor(){
    	return color.getColor();
    	
    }

}
