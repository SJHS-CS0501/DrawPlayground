/**
 * This class is used to create the tool panel that contains
 * the color options, shape buttons, movement buttons, and 
 * resources used by other parts of this operation.
 * @author Jack Protivnak
 */
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

import javafx.beans.value.ChangeListener;

import java.io.*;
import java.util.*;

public class ToolPanel extends JPanel implements ActionListener {
	// drawingType is updated throughout the ToolPanel and used to determine
	// what we are doing in DrawingPane
	// All variables are declared.

	private static final long serialVersionUID = 1;
	public static final short one = 1;
	public final short two = 2;
	public final short three = 3;
	public final short four = 4;
	public final short five = 5;
	public final short six = 6;
	public final short seven = 7;
	public final short eight = 8;
	public final short nine = 9;
	public final short ten = 10;
	public final short eleven = 11;
	public final short tweleve = 12;
	public final short thirteen = 13;
	public final short fourteen = 14;
	public final short fifteen = 15;
	public final short sixteen = 16;
	public final short seventeen = 17;
	public static short choice;
	public static boolean move = false;
	public static Color color;
	private JButton button;
	private JPanel shapes;
	private JPanel theUnknown;
	private JPanel colorChooser;
	private JPanel movements;
	public static JColorChooser chooser;
	public String command;

	/**
	 * Constructor to create the frame of the tool panel
	 * and will contain panels for each aspect:
	 * shapes, unknown shape, color chooser, and 
	 * movement options.
	 */
	public ToolPanel() {
		super();
		this.setSize(50, 200);
		this.setLayout(new GridLayout(4, 1));
		this.setBorder(BorderFactory.createEmptyBorder());

		shapes = new JPanel();
		shapes.setLayout(new GridLayout(6, 2));
		shapes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Shapes"));
		
		theUnknown = new JPanel();
		theUnknown.setLayout(new GridLayout(1, 1));
		theUnknown.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Unknown Shape"));
		
		colorChooser = new JPanel();
		colorChooser.setLayout(new GridLayout(1, 1));
		colorChooser.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Color Changer"));

		movements = new JPanel();
		movements.setLayout(new GridLayout(1, 1));
		movements.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED),"Movement Options"));

		button = new JButton("Rectangle");
		button.setActionCommand("rectangle");
		button.addActionListener(this);
		shapes.add(button);
		
		button = new JButton("Filled Rectangle");
		button.setActionCommand("filledRectangle");
		button.addActionListener(this);
		shapes.add(button);

		button = new JButton("Star");
		button.setActionCommand("star");
		button.addActionListener(this);
		shapes.add(button);
		
		button = new JButton("Filled Star");
		button.setActionCommand("filledStar");
		button.addActionListener(this);
		shapes.add(button);

		button = new JButton("Circle");
		button.setActionCommand("circle");
		button.addActionListener(this);
		shapes.add(button);
		
		button = new JButton("Fiiled Circle");
		button.setActionCommand("filledCircle");
		button.addActionListener(this);
		shapes.add(button);
		
		button = new JButton("Oval");
		button.setActionCommand("oval");
		button.addActionListener(this);
		shapes.add(button);
		
		button = new JButton("Filled Oval");
		button.setActionCommand("filledOval");
		button.addActionListener(this);
		shapes.add(button);
		
		button = new JButton("Square");
		button.setActionCommand("square");
		button.addActionListener(this);
		shapes.add(button);
		
		button = new JButton("Filled Square");
		button.setActionCommand("filledSquare");
		button.addActionListener(this);
		shapes.add(button);
		
		button = new JButton("Line");
		button.setActionCommand("line");
		button.addActionListener(this);
		shapes.add(button);

		add(shapes);
		
		button = new JButton("The Polymorpher Button");
		button.setActionCommand("unknownShape");
		button.addActionListener(this);
		theUnknown.add(button);
		
		button = new JButton("The Polymorpher Button (Filled)");
		button.setActionCommand("filledUnknownShape");
		button.addActionListener(this);
		theUnknown.add(button);
		
		add(theUnknown);
		
		chooser = new JColorChooser();
		chooser.setColor(Color.BLACK);
		button = new JButton("Color Chooser");
		button.setActionCommand("colorChooser");
		button.addActionListener(this);
		colorChooser.add(button);
		
		add(colorChooser);

		button = new JButton("Move");
		button.setActionCommand("move");
		button.addActionListener(this);
		movements.add(button);

		add(movements);

		this.getPreferredSize();
		this.setVisible(true);
	}

	/**
	 * Action listener for the different buttons.
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "rectangle":
				choice = 0;
				choice = one;
				break;
				
			case "star":
				choice = 0;
				choice = two;
				break;
				
			case "circle":
				choice = 0;
				choice = three;
				break;
				
			case "line":
				choice = 0;
				choice = four;
				break;
				
			case "oval":
				choice = 0;
				choice = five;
				break;
				
			case "square":
				choice = 0;
				choice = six;
				break;
				
			case "move":
				choice = 0;
				choice = seven;
				break;
				
			case "delete":
				choice = 0;
				choice = eight;
				break;
				
			case "unknownShape":
				choice = 0;
				choice = nine;
				break;
				
			case "filledRectangle":
				choice = 0;
				choice = ten;
				break;
				
			case "filledStar":
				choice = 0;
				choice = eleven;
				break;
				
			case "filledCircle":
				choice = 0;
				choice = tweleve;
				break;
				
			case "filledOval":
				choice = 0;
				choice = thirteen;
				break;
				
			case "filledSquare":
				choice = 0;
				choice = fourteen;
				break;
				
			case "filledUnknownShape":
				choice = 0;
				choice = fifteen;
				break;
				
			case "colorChooser":
				color = chooser.showDialog(chooser, "Choose a color", Color.BLACK);
				break;

			default:
				System.out.println("EVIL EVIL BAD PLACE");
				System.exit(-1);
				break;
		}
	}
}
