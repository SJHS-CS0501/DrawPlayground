import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.border.*;

public class ToolPanel extends JPanel implements ActionListener {
    // drawingType is updated throughout the ToolPanel and used to determine
    // what we are doing in DrawingPane
	
	private static final long serialVersionUID = 1L;
	ButtonGroup shapes;
	ButtonGroup colors;
	JPanel shapePanel;
	JPanel colorPanel;
	JRadioButton radioButton;
	MyRectangle rec = new MyRectangle();
	DrawingPane drawingPane = new DrawingPane();
	
    public ToolPanel() {
        super();
        this.setSize( 50, 200 );
        this.setLayout( new GridLayout( 4, 2 ) );
        this.setBorder( BorderFactory.createEtchedBorder() );
        
        shapes = new ButtonGroup();
        colors = new ButtonGroup();
        shapePanel = new JPanel(new GridLayout(4,1));
        colorPanel = new JPanel(new GridLayout(8,1));
        
        //shape buttons
        radioButton = new JRadioButton("Line");
		radioButton.setActionCommand("Line");
		radioButton.addActionListener(this);
		shapes.add(radioButton);
		shapePanel.add(radioButton);
		
		radioButton = new JRadioButton("Rectangle");
		radioButton.setActionCommand("Rectangle");
		radioButton.addActionListener(this);
		shapes.add(radioButton);
		shapePanel.add(radioButton);
		
		radioButton = new JRadioButton("Circle");
		radioButton.setActionCommand("Circle");
		radioButton.addActionListener(this);
		shapes.add(radioButton);
		shapePanel.add(radioButton);
		
		radioButton = new JRadioButton("Star");
		radioButton.setActionCommand("Star");
		radioButton.addActionListener(this);
		shapes.add(radioButton);
		shapePanel.add(radioButton);
		
		//shapePanel.add(new JSeparator());
		
		//color buttons
		radioButton = new JRadioButton("Black");
		radioButton.setActionCommand("Black");
		radioButton.addActionListener(this);
		colors.add(radioButton);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Red");
		radioButton.setActionCommand("Red");
		radioButton.addActionListener(this);
		colors.add(radioButton);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Orange");
		radioButton.setActionCommand("Orange");
		radioButton.addActionListener(this);
		colors.add(radioButton);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Yellow");
		radioButton.setActionCommand("Yellow");
		radioButton.addActionListener(this);
		colors.add(radioButton);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Green");
		radioButton.setActionCommand("Green");
		radioButton.addActionListener(this);
		colors.add(radioButton);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Cyan");
		radioButton.setActionCommand("Cyan");
		radioButton.addActionListener(this);
		colors.add(radioButton);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Blue");
		radioButton.setActionCommand("Blue");
		radioButton.addActionListener(this);
		colors.add(radioButton);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Pink");
		radioButton.setActionCommand("Pink");
		radioButton.addActionListener(this);
		colors.add(radioButton);
		colorPanel.add(radioButton);
	
		add(shapePanel, BorderLayout.WEST);
		add(colorPanel, BorderLayout.WEST);
        
        this.setVisible( true );
    }
    
    public void actionPerformed( ActionEvent e ) {
        switch( e.getActionCommand() ) {
        //shapes
        case "Line":
        	break;
        case "Rectangle":
        	break;
        case "Circle":
        	break;
        case "Star":
        	break;
        //colors
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
