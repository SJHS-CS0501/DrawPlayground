import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.border.*;

public class ToolPanel extends JPanel implements ActionListener {
    // drawingType is updated throughout the ToolPanel and used to determine
    // what we are doing in DrawingPane
	
	JColorChooser colorChooser = new JColorChooser();
	private static final long serialVersionUID = 1L;
	DrawingPane drawingPane = new DrawingPane();
	DrawingObject drawingObject;
	ButtonGroup shapeButtons;
	ButtonGroup colorButtons;
	JRadioButton radioButton;
	static String color;
	JPanel shapePanel;
	JPanel colorPanel;
	
	/*
	 * move:
	 *  
	 *  star bounding...call contains on polygon object
	 *  but bounding rectangle is cool too
	 *  
	 *  line
	 *  - reactangle does not work well
	 *  - use formula to determine if point is on a line
	 *  - have some threshold so it expands the points a little
	 *  
	 *  color
	 *  - not too hard
	 *  - set color, get color
	 *  	- give yourself ability to set get available all the time
	 */
	
    public ToolPanel() {
        super();
        this.setSize( 50, 200 );
        this.setLayout( new GridLayout( 4, 2 ) );
        this.setBorder( BorderFactory.createEtchedBorder() );
      
        shapeButtons = new ButtonGroup();
        //colorButtons = new ButtonGroup();
        shapePanel = new JPanel(new GridLayout(4,1));
        colorPanel = new JPanel(new GridLayout(8,1));
        
        /*
        * shape buttons
        *
        * - create new button
        * - set ACtionCommand
        * - add to ActionListener
        * - add that button to the the shape button group
        * - also add that button to the panel 
        */
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
		
		radioButton = new JRadioButton("Move shape");
		radioButton.setActionCommand("Move shape");
		radioButton.addActionListener(this);
		shapeButtons.add(radioButton);
		shapePanel.add(radioButton);
		
		//color buttons
		radioButton = new JRadioButton("Choose color");
		radioButton.setActionCommand("Choose color");
		radioButton.addActionListener(this);
//		colorButtons.add(radioButton);
		colorPanel.add(radioButton);
	
		add(shapePanel, BorderLayout.WEST);
		add(colorPanel, BorderLayout.WEST);
        
        this.setVisible( true );
    }
    
    public void actionPerformed( ActionEvent e ) {
    	
    	switch(e.getActionCommand()){
    	case "Line":
    		DrawingPane.shape = (e.getActionCommand());
    		break;
    	case "Rectangle":
    		DrawingPane.shape = (e.getActionCommand());
    		break;
    	case "Circle":
    		DrawingPane.shape = (e.getActionCommand());
    		break;
    	case "Star":
    		DrawingPane.shape = (e.getActionCommand());
    		break;
    	case "Move shape":
    		DrawingPane.shape = (e.getActionCommand());
    		break;
    	case "Choose color":
    		DrawingPane.shape = (e.getActionCommand());
    		break;
//    	case "Orange":
//    		color = e.getActionCommand();
//    		break;
//    	case "Yellow":
//    		color = e.getActionCommand();
//    		break;
//    	case "Green":
//    		color = e.getActionCommand();
//    		break;
//    	case "Cyan":
//    		color = e.getActionCommand();
//    		break;
//    	case "Blue":
//    		color = e.getActionCommand();
//    		break;
//    	case "Pink":
//    		color = e.getActionCommand();
//    		break;	
    	}
    }
}
