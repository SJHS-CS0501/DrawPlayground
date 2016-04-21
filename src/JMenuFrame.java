
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
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
        
        menu = new JMenu( "My Menu" );
        
        menuItem = new JMenuItem( "Save" );
        menuItem.setActionCommand( "Save" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Open File" );
        menuItem.setActionCommand( "Open File" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem( "Exit" );
        menuItem.setActionCommand( "Quit" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuBar.add( menu );
        
        menu = new JMenu( "Drawing Stuffs" );
        
        menuItem = new JMenuItem( "Foo Thing" );
        menuItem.setActionCommand( "MenuFoo" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem( "Foo 2" );
        menuItem.setActionCommand( "MenuFoo2" );
        menuItem.addActionListener( this );
        menu.add( menuItem );
        
        subMenu = new JMenu( "Delete and Clear" );
        menuItem = new JMenuItem( "Delete" );
        menuItem.setActionCommand( "Delete" );
        menuItem.addActionListener(this);
        subMenu.add(menuItem);
        menuItem = new JMenuItem ("Clear All");
        menuItem.setActionCommand( "Clear All" );
        menuItem.addActionListener( this );
        subMenu.add( menuItem );
        
        menu.add(subMenu);
        
        menuBar.add( menu );
        
        menuBar.add( Box.createHorizontalGlue() );
        
        menu = new JMenu( "Help" );
        menuItem = new JMenuItem( "About" );
        menuItem.setActionCommand( "MenuAbout" );
        menuItem.addActionListener( this );
        
        setExtendedState((getExtendedState() & MAXIMIZED_BOTH) == MAXIMIZED_BOTH? NORMAL : MAXIMIZED_BOTH);
        menu.add( menuItem );
        
        menuBar.add( menu );
        
        this.setJMenuBar( menuBar );
        
      
        this.setVisible( true );
    }
    
    public void actionPerformed( ActionEvent e ) {

        switch( e.getActionCommand() ) {
            case "Save":
            	if( dPane != null) {
            		String fileName = "panel.jpg";
            		getFileName(fileName);
            	    BufferedImage img = new BufferedImage(dPane.getWidth(), dPane.getHeight(), BufferedImage.TYPE_INT_RGB);
            	    dPane.print(img.getGraphics()); 
            	  
            	    try {
            	    	FileOutputStream outStream = new FileOutputStream("foo.dat");
            	    	
            	        ImageIO.write(img, fileName, new File(fileName));
            	    }
            	    catch (IOException e1) {
            	        // TODO Auto-generated catch block
            	        e1.printStackTrace();
            	    }
            	}
                System.out.println( "Save pressed" );
                break;
            case "Open File":
            	final JFileChooser fc = new JFileChooser();
                    int returnVal = fc.showOpenDialog(JMenuFrame.this);
                    
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                    	fc.setCurrentDirectory(new File (System.getProperty("user.home")));
                        File file = fc.getSelectedFile();
                        
                        //This is where a real application would open the file.
                        //log.append("Opening: " + file.getName());
                    }
                System.out.println( "Another Pressed" );
                break;
            case "Quit":
                System.out.println( "quit Pressed" );
                System.exit(0);
                break;
            case "Clear All":
            	DrawingPane.objList.clear();
            	repaint();
            	break;
            case"Delete":
            	for( int ctr = 0; ctr <= DrawingPane.objList.size(); ctr++ ){
            		if(DrawingPane.objList.get(ctr).contains()){
            			
            		}
            	}
            	break;
            default:
                System.out.println( "I DON'T KNOW HOW YOU GOT HERE!!!!" );
                System.exit(-1);
                break;
        }
    }
    
    public String getFileName(String fileName){
    	 JFrame frame = new JFrame();
    	    String result = JOptionPane.showInputDialog(frame, "Please type what you would like to name your save");
    	    
    	    System.out.println(result);
    	    fileName = result;
    	return fileName;
    	
    }
}
