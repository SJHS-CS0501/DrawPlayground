/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jack Protivnak
 */

import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.io.*;
import java.util.*;

public class ToolPanel extends JPanel implements ActionListener {
	// drawingType is updated throughout the ToolPanel and used to determine
	// what we are doing in DrawingPane

	private static final long serialVersionUID = 1;
	public static final short one = 1;
	public final short two = 2;
	public final short three = 3;
	public final short four = 4;
	public final short five = 5;
	public final short six = 6;
	public static short choice;
	public static boolean move = false;
	public static boolean delete = false;
	private JButton button;
	private JPanel shapes;
	JPanel movements;
	private MyRectangle rectangle = new MyRectangle();
	private Graphics2D gShape;
	public String command;

	public ToolPanel() {
		super();
		this.setSize(50, 200);
		this.setLayout(new GridLayout(2, 2));
		this.setBorder(BorderFactory.createEmptyBorder());

		shapes = new JPanel();
		shapes.setLayout(new GridLayout(2, 2));
		shapes.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Shapes"));

		movements = new JPanel();
		movements.setLayout(new GridLayout(2, 2));
		movements.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
				"Movement Options"));

		button = new JButton("Rectangle");
		button.setActionCommand("rectangle");
		button.addActionListener(this);
		shapes.add(button);

		button = new JButton("Star");
		button.setActionCommand("star");
		button.addActionListener(this);
		shapes.add(button);

		button = new JButton("Circle");
		button.setActionCommand("circle");
		button.addActionListener(this);
		shapes.add(button);

		button = new JButton("Line");
		button.setActionCommand("line");
		button.addActionListener(this);
		shapes.add(button);

		add(shapes);

		button = new JButton("Move");
		button.setActionCommand("move");
		button.addActionListener(this);
		movements.add(button);

		button = new JButton("Delete");
		button.setActionCommand("delete");
		button.addActionListener(this);
		movements.add(button);

		add(movements);

		this.getPreferredSize();
		this.setVisible(true);
	}

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
				
			case "move":
				choice = 0;
				choice = five;
				break;
				
			case "delete":
				choice = 0;
				choice = six;
				break;

			default:
				System.out.println("EVIL EVIL BAD PLACE");
				System.exit(-1);
				break;
		}
	}
}
