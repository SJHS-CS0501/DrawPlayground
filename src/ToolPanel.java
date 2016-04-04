import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.border.*;

public class ToolPanel extends JPanel implements ActionListener {
    // drawingType is updated throughout the ToolPanel and used to determine
    // what we are doing in DrawingPane
	
	private static final long serialVersionUID = 1L;
	JPanel shapePanel;
	JPanel colorPanel;
	JRadioButton radioButton;
	
    public ToolPanel() {
        super();
        this.setSize( 50, 200 );
        this.setLayout( new GridLayout( 4, 2 ) );
        this.setBorder( BorderFactory.createEtchedBorder() );
        
        shapePanel = new JPanel(new GridLayout(4,1));
        colorPanel = new JPanel(new GridLayout(8,1));
        
        //shape buttons
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
		
		//shapePanel.add(new JSeparator());
		
		//color buttons
		radioButton = new JRadioButton("Black");
		radioButton.setActionCommand("Black");
		radioButton.addActionListener(this);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Red");
		radioButton.setActionCommand("Red");
		radioButton.addActionListener(this);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Orange");
		radioButton.setActionCommand("Orange");
		radioButton.addActionListener(this);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Yellow");
		radioButton.setActionCommand("Yellow");
		radioButton.addActionListener(this);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Green");
		radioButton.setActionCommand("Green");
		radioButton.addActionListener(this);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Cyan");
		radioButton.setActionCommand("Cyan");
		radioButton.addActionListener(this);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Blue");
		radioButton.setActionCommand("Blue");
		radioButton.addActionListener(this);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Pink");
		radioButton.setActionCommand("Pink");
		radioButton.addActionListener(this);
		colorPanel.add(radioButton);
		
		add(shapePanel, BorderLayout.WEST);
		add(colorPanel, BorderLayout.WEST);
        
        this.setVisible( true );
    }
    
    public void actionPerformed( ActionEvent e ) {
        switch( e.getActionCommand() ) {
        case "Line":
        	break;
        case "Rectangle":
        	break;
        case "Circle":
        	break;
        case "Star":
        	break;
        	
        case "Black":
        	break;
        case "Red":
        	break;
        case "Orange":
        	break;
        case "Yellow":
        	break;
        case "Green":
        	break;
        case "Cyan":
        	break;
        case "Blue":
        	break;
        case "Pink":
        	break;
        default:
        	System.out.println( "Bad Stuff" );
            System.exit(-1);
            break;
        }
    }
}
