 import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author woytek
 */
public class JMenuFrame extends JFrame implements ActionListener, Serializable {
    
	// More notes from Isabelle....
	// JFile user....just go with this
	// file filter..add ending on file name
	// better layout
	// make things happy
	// so happy
	
	
	private static final long serialVersionUID = 1L;
	DrawingPane dPane = new DrawingPane();
	String input;

	public JMenuFrame() {
        super();
        ToolPanel tPane = new ToolPanel(dPane);
        JPanel panel;
        
         
        JFileChooser filinStuff = new JFileChooser();
        //FileNameExtensionFilter filter = new FileNameExtensionFilter( "JPEG Images", "jpg" );
        //filinStuff.setFileFilter(filter);
            
        
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
     //   JMenu subMenu;
        
                
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
        
//        menu = new JMenu( "FOO" );
//        
//        menuItem = new JMenuItem( "Foo Thing" );
//        menuItem.setActionCommand( "MenuFoo" );
//        menuItem.addActionListener( this );
//        menu.add(menuItem);
//        
//        menu.addSeparator();
//        
//        menuItem = new JMenuItem( "Foo 2" );
//        menuItem.setActionCommand( "MenuFoo2" );
//        menuItem.addActionListener( this );
//        menu.add( menuItem );
//        
//        subMenu = new JMenu( "SubMenu" );
//        menuItem = new JMenuItem( "SubFoo" );
//        menuItem.setActionCommand( "MenuSubFoo" );
//        menuItem.addActionListener( this );
//        subMenu.add( menuItem );
//        
//        menu.add(subMenu);
//        
//        menuBar.add( menu );
//        
        menuBar.add( Box.createHorizontalGlue() );
        
        menu = new JMenu( "Help" );
        menuItem = new JMenuItem( "About" );
        menuItem.setActionCommand( "MenuAbout" );
        menuItem.addActionListener( this );
        
        menu.add( menuItem );
        
        menuBar.add( menu );
        
        this.setJMenuBar( menuBar );
        
        this.setSize( 600, 600 );
        
        
        this.setVisible( true );
    }
    
    public void actionPerformed( ActionEvent e ) {

        switch( e.getActionCommand() ) {
            case "saveJPG":
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
            case "Save":
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
          //  case "MenuSubFoo":	
          // 	break;
            case "Open":
                JFileChooser chooser = new JFileChooser();
                FileInputStream lastStreamie = null;
                ObjectInputStream iLied;
                int number = chooser.showOpenDialog(this);
                
                dPane.objectList.clear();
                
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
                
                }
                
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
