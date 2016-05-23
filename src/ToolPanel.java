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

    
    static JColorChooser soManyColors = new JColorChooser();
	private static final long serialVersionUID = 1L;
	DrawingPane dPane = new DrawingPane();
	
	public ToolPanel( DrawingPane d ) {
        super();
        dPane = d;
        this.setSize( 200, 1000 );
        this.setLayout( new GridLayout( 2, 6 ) ); // 2 by 6 layout
        this.setBorder( BorderFactory.createEtchedBorder() );
        JButton button;
        JPanel againForButtons = new JPanel( new GridLayout(4,2) ); // 8 buttons total, fake button gets to live
        JPanel colors = new JPanel( new GridLayout());
        Color color;
        
        // rectangle button
        button = new JButton( "Rectangle" );
        button.setActionCommand( "rectangle" );
        button.addActionListener( this );
        againForButtons.add( button );
        
        // circle button
        button = new JButton( "Circle" );
        button.setActionCommand( "circle" );
        button.addActionListener( this );
        againForButtons.add( button );
        
        // line button
        button = new JButton( "Line" );
        button.setActionCommand( "line" );
        button.addActionListener( this );
        againForButtons.add( button );
        
        // word box...for stringy words!
        button = new JButton( "Word Box" );
        button.setActionCommand( "string" );
        button.addActionListener( this );
        againForButtons.add( button );
        
        // star button
        button = new JButton( "Star" );
        button.setActionCommand( "star" );
        button.addActionListener( this );
        againForButtons.add( button );
        
        // for circles..just kidding:P
        button = new JButton( "Arc" );
        button.setActionCommand( "arc" );
        button.addActionListener( this );
        againForButtons.add( button );
        
        // moving
        button = new JButton( "Move" );
        button.setActionCommand( "move" );
        button.addActionListener( this );
        againForButtons.add( button );
        
        // fake button likes to chill in the tool panel and pretend it's being useful
        // it does keep the grid layout looking pretty though
        button = new JButton( "fake button" );
        againForButtons.add( button );
       
        // black set as default color 
        soManyColors.setColor( Color.BLACK );
        colors.add( soManyColors );
        color = soManyColors.getColor();
        
        // add the panels, silly
        this.add( againForButtons, BorderLayout.WEST );
        this.add( colors, BorderLayout.WEST );
        
        // Always set your stuffidy as visible. Wouldn't want people to miss out on this awesomeness!
        this.setVisible( true );
    }
    
    
    public void actionPerformed( ActionEvent e ) {
    	dPane.coolShape = e.getActionCommand();
    }
    
    
}
