import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.border.*;

public class ToolPanel extends JPanel implements ActionListener {
    // drawingType is updated throughout the ToolPanel and used to determine
    // what we are doing in DrawingPane

	JPanel shapePanel;
	JRadioButton radioButton;
	
    public ToolPanel() {
        super();
        this.setSize( 50, 200 );
        this.setLayout( new GridLayout( 4, 2 ) );
        this.setBorder( BorderFactory.createEtchedBorder() );
        
        radioButton = new JRadioButton("Line");
		radioButton.setActionCommand("Line");
		radioButton.addActionListener(this);
		shapePanel.add(radioButton);
		
		radioButton = new JRadioButton("Rectangle");
		radioButton.setActionCommand("Rectangle");
		radioButton.addActionListener(this);
		shapePanel.add(radioButton);
		
		radioButton = new JRadioButton("Circle");
		radioButton.setActionCommand("Circle");
		radioButton.addActionListener(this);
		shapePanel.add(radioButton);
		
		radioButton = new JRadioButton("Star");
		radioButton.setActionCommand("Star");
		radioButton.addActionListener(this);
		shapePanel.add(radioButton);
		
		add(shapePanel, BorderLayout.WEST);
        
        this.setVisible( true );
    }
    
    public void actionPerformed( ActionEvent e ) {
        switch( e.getActionCommand() ) {

            default:
                System.out.println( "Bad Stuff" );
                System.exit(-1);
                break;
        }
    }
}
