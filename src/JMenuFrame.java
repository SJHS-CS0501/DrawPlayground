 import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author woytek
 * @author Isabelle Schroeder
 */
public class JMenuFrame extends JFrame implements ActionListener, Serializable {
    
	// More notes from Isabelle....
	// better layout
	// make things happy
	// so happy
	
	private static final long serialVersionUID = 1L;
	DrawingPane dPane = new DrawingPane();
	String input;

	public JMenuFrame() {
        super(); // super frame!! buh buh buh bump
        ToolPanel tPane = new ToolPanel(dPane);
        
        // all the different menus
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
                
        this.setLayout( new BorderLayout() );
        this.setName( "Jay Manue Teeest Frum");
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        this.add( tPane, BorderLayout.WEST );
        this.add( dPane, BorderLayout.CENTER );

        menuBar = new JMenuBar();
        
        menu = new JMenu( "My Menu" );
        
        menuItem = new JMenuItem( "Save as JPG" );
        menuItem.setActionCommand( "saveJPG" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Save" );
        menuItem.setActionCommand( "Save" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Open" );
        menuItem.setActionCommand( "Open" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem( "Exit" );
        menuItem.setActionCommand( "Quit" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuBar.add( menu );
        
        menuBar.add( Box.createHorizontalGlue() );
        
        // help menu does nothing but give false hope to a poor, confused soul
        // update, gives basic instructions. The soul may be less confused now?
        menu = new JMenu( "Help" );
        menuItem = new JMenuItem( "About" );
        menuItem.setActionCommand( "MenuAbout" );
        menuItem.addActionListener( this );
        menu.add( menuItem ); // add button
        
        menuBar.add( menu ); // add the whole menu
        
        this.setJMenuBar( menuBar );
        
        this.setSize( 600, 600 ); // set size
        
        
        this.setVisible( true ); // set visible
    }
    
    public void actionPerformed( ActionEvent e ) {

        switch( e.getActionCommand() ) {
            case "saveJPG": // save as JPG
            	BufferedImage image = new BufferedImage( dPane.getWidth(), dPane.getHeight(), BufferedImage.TYPE_INT_RGB);
            	
            	File file = new File( "MyFile.jpg" );
            	
            	dPane.print(image.getGraphics());
            	try{
            		ImageIO.write(image, "JPEG", file);
            	} catch( IOException x ){
            		x.printStackTrace();
            		System.out.println( "IO Sadness:'(" );
            	}
            	System.out.println( "Something Pressed" );
                break;
            case "Save": // other save option
            	input = JOptionPane.showInputDialog(dPane, "File name:", "File file file");            	
            	
            	try{
            		FileOutputStream streamie = new FileOutputStream( input );
            		ObjectOutputStream otherStreamie = new ObjectOutputStream( streamie );
            		
            		for( int i = 0; i < dPane.objectList.size(); i++ ){
            			otherStreamie.writeObject(dPane.objectList.get(i));
            		}
            	otherStreamie.close();
            	} catch( Exception q ){
            		
            	}
            	break;
            case "MenuAbout": // help menu
            	JOptionPane.showMessageDialog( this, "Choose a color and shape and start making pretty, pretty pictures!"
            			+ " Don't forget to save your artwork!" );
            	break;
            case "Open": // open function to load old picture
                JFileChooser chooser = new JFileChooser(); 
                FileInputStream lastStreamie = null;
                ObjectInputStream iLied;
                int number = chooser.showOpenDialog(this);
                
                dPane.objectList.clear();
               
                // use file chooser to pick the old project you want
                // gets file and array list of objects
                try{
                	if( number == JFileChooser.APPROVE_OPTION){
                }
                	lastStreamie = new FileInputStream( chooser.getSelectedFile());
                	iLied = new ObjectInputStream(lastStreamie);
                	
                	while( lastStreamie.available() != 0 ){
                		DrawingObject object;
                		object = (DrawingObject)iLied.readObject();// casting!
                		dPane.objectList.add(object);
                		repaint();
                	}
                } catch( Exception f ){
                	System.out.println( "WHAT DID YOU DO??" );
                }
                
                break;
            case "Quit":
                System.out.println( "quit Pressed" );
                System.exit(0);
                break;
           
            default:
                System.out.println( "I DON'T KNOW HOW YOU GOT HERE!!!!" ); // seriosly, how??
                System.exit(-1);
                break;
        }
    }
}
