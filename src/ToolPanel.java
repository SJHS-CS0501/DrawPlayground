import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.border.*;

/**
*
* @author woytek
* @author Isabelle Schroeder
*/

public class ToolPanel extends JPanel implements ActionListener {
    // drawingType is updated throughout the ToolPanel and used to determine
    // what we are doing in DrawingPane

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DrawingPane dPane = new DrawingPane();
	
	public ToolPanel( DrawingPane d ) {
        super();
        dPane = d;
        this.setSize( 50, 100 );
        this.setLayout( new GridLayout( 1, 3 ) );
        this.setBorder( BorderFactory.createEtchedBorder() );
        JButton button;
        JPanel againForButtons = new JPanel();
    
        againForButtons.setLayout( new GridLayout(4,2));
        
        button = new JButton( "Rectangle" );
        button.setActionCommand( "rectangle" );
        button.addActionListener( this );
        againForButtons.add( button );
        
        button = new JButton( "Circle" );
        button.setActionCommand( "circle" );
        button.addActionListener( this );
        againForButtons.add( button );
        
        button = new JButton( "Line" );
        button.setActionCommand( "line" );
        button.addActionListener( this );
        againForButtons.add( button );
        
        button = new JButton( "Word Box" );
        button.setActionCommand( "string" );
        button.addActionListener( this );
        againForButtons.add( button );
        
        button = new JButton( "Star" );
        button.setActionCommand( "star" );
        button.addActionListener( this );
        againForButtons.add( button );
        
        button = new JButton( "Arc" );
        button.setActionCommand( "arc" );
        button.addActionListener( this );
        againForButtons.add( button );
        
        button = new JButton( "Move" );
        button.setActionCommand( "move" );
        button.addActionListener( this );
        againForButtons.add( button );
        
        button = new JButton( "fake button" );
        //button.setActionCommand( "move" );
        //button.addActionListener( this );
        againForButtons.add( button );
       
        //JColorChooser colors = new JColorChooser();
        //againForButtons.add( colors );
        
        
        //againForButtons.add( new JSeparator() );
        
        this.add( againForButtons, BorderLayout.WEST );
        
        
        this.setVisible( true );
    }
    

    
    public void actionPerformed( ActionEvent e ) {
    	
    	dPane.coolShape = e.getActionCommand();
    }
    
    
}
