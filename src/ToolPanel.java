import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.border.*;

public class ToolPanel extends JPanel implements ActionListener {
    // drawingType is updated throughout the ToolPanel and used to determine
    // what we are doing in DrawingPane
	
	private static final long serialVersionUID = 1L;
	DrawingPane drawingPane = new DrawingPane();
	DrawingObject drawingObject;
	ButtonGroup shapeButtons;
	ButtonGroup colorButtons;
	JRadioButton radioButton;
	static String color;
	JPanel shapePanel;
	JPanel colorPanel;
		
    public ToolPanel() {
        super();
        this.setSize( 50, 200 );
        this.setLayout( new GridLayout( 4, 2 ) );
        this.setBorder( BorderFactory.createEtchedBorder() );
        
        shapeButtons = new ButtonGroup();
        colorButtons = new ButtonGroup();
        shapePanel = new JPanel(new GridLayout(4,1));
        colorPanel = new JPanel(new GridLayout(8,1));
        
        //shape buttons
        radioButton = new JRadioButton("Line");
		radioButton.setActionCommand("Line");
		radioButton.addActionListener(this);
		shapeButtons.add(radioButton);
		shapePanel.add(radioButton);
		
		radioButton = new JRadioButton("Rectangle");
		radioButton.setActionCommand("Rectangle");
		radioButton.addActionListener(this);
		shapeButtons.add(radioButton);
		shapePanel.add(radioButton);
		
		radioButton = new JRadioButton("Circle");
		radioButton.setActionCommand("Circle");
		radioButton.addActionListener(this);
		shapeButtons.add(radioButton);
		shapePanel.add(radioButton);
		
		radioButton = new JRadioButton("Star");
		radioButton.setActionCommand("Star");
		radioButton.addActionListener(this);
		shapeButtons.add(radioButton);
		shapePanel.add(radioButton);
		
		//shapePanel.add(new JSeparator());
		
		//color buttons
		radioButton = new JRadioButton("Black");
		radioButton.setActionCommand("Black");
		radioButton.addActionListener(this);
		colorButtons.add(radioButton);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Red");
		radioButton.setActionCommand("Red");
		radioButton.addActionListener(this);
		colorButtons.add(radioButton);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Orange");
		radioButton.setActionCommand("Orange");
		radioButton.addActionListener(this);
		colorButtons.add(radioButton);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Yellow");
		radioButton.setActionCommand("Yellow");
		radioButton.addActionListener(this);
		colorButtons.add(radioButton);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Green");
		radioButton.setActionCommand("Green");
		radioButton.addActionListener(this);
		colorButtons.add(radioButton);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Cyan");
		radioButton.setActionCommand("Cyan");
		radioButton.addActionListener(this);
		colorButtons.add(radioButton);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Blue");
		radioButton.setActionCommand("Blue");
		radioButton.addActionListener(this);
		colorButtons.add(radioButton);
		colorPanel.add(radioButton);
		
		radioButton = new JRadioButton("Pink");
		radioButton.setActionCommand("Pink");
		radioButton.addActionListener(this);
		colorButtons.add(radioButton);
		colorPanel.add(radioButton);
	
		add(shapePanel, BorderLayout.WEST);
		add(colorPanel, BorderLayout.WEST);
        
        this.setVisible( true );
    }
    
    public void actionPerformed( ActionEvent e ) {
    	
    	switch(e.getActionCommand()){
    	case "Line":
    		drawingPane.shape = (e.getActionCommand());
    		break;
    	case "Rectangle":
    		drawingPane.shape = (e.getActionCommand());
    		break;
    	case "Circle":
    		drawingPane.shape = (e.getActionCommand());
    		break;
    	case "Star":
    		drawingPane.shape = (e.getActionCommand());
    		break;
    		
    	case "Red":
    		color = e.getActionCommand();
    		break;
    	case "Orange":
    		color = e.getActionCommand();
    		break;
    	case "Yellow":
    		color = e.getActionCommand();
    		break;
    	case "Green":
    		color = e.getActionCommand();
    		break;
    	case "Cyan":
    		color = e.getActionCommand();
    		break;
    	case "Blue":
    		color = e.getActionCommand();
    		break;
    	case "Pink":
    		color = e.getActionCommand();
    		break;	
    	}
    }
}
