import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class ToolPanel extends JPanel implements ActionListener, Serializable {
	// drawingType is updated throughout the ToolPanel and used to determine
	// what we are doing in DrawingPane

	static JColorChooser colorChooser = new JColorChooser();
	private static final long serialVersionUID = 1L;
	DrawingPane drawingPane = new DrawingPane();
	DrawingObject drawingObject;
	ButtonGroup shapeButtons;
	ButtonGroup colorButtons;
	JRadioButton radioButton;
	public static Color color;
	JPanel shapePanel;
	JPanel colorPanel;

	public ToolPanel() {
		super();
		this.setSize(50, 500);
		this.setLayout(new GridLayout(4, 2));
		this.setBorder(BorderFactory.createEtchedBorder());

		shapeButtons = new ButtonGroup();
		// colorButtons = new ButtonGroup();
		shapePanel = new JPanel(new GridLayout(5, 1));
		colorPanel = new JPanel(new GridLayout());

		/*
		 * shape buttons
		 *
		 * - create new button - set ACtionCommand - add to ActionListener - add
		 * that button to the the shape button group - also add that button to
		 * the panel
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

		// color panel
		colorChooser.setColor(Color.BLACK);
		colorPanel.add(colorChooser);
		color = colorChooser.getColor();

		add(shapePanel, BorderLayout.WEST);
		add(colorPanel, BorderLayout.WEST);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
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
		}
	}
}
