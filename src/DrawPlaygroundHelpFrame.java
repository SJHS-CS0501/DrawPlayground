import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * This is the class that handles the help and about menus
 * @author Ryan Luchs
 *
 */
public class DrawPlaygroundHelpFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JTextArea text;
	JScrollPane scroll;
	
	public static final short MODE_HELP = 0;
	public static final short MODE_ABOUT = 1;
	
	/**
	 * DrawPlaygroundHelpFrame constructor
	 */
	DrawPlaygroundHelpFrame() {
		super("Help");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		text = new JTextArea(10, 50);
		text.setEditable(false);
		
		scroll = new JScrollPane(text);
		add(scroll);

		pack();
	}

	/**
	 * Sets whether to frame displays the help or about text.
	 * @param m
	 */
	public void setMode(short m) {
		switch(m) {
			case MODE_HELP:
				this.setTitle("Help");
				text.setText(
						"When creating a new shape:\n"
						+ "Click once to set the start point fo the shape, then click and drag to resize the shape\n"
						+ "\n"
						+ "When Moving or Dragging shapes:\n"
						+ "Click once on the shape's border to select it, then click and drag to move/resize\n"
						+ "\n"
						+ "Color Picker:\n"
						+ "The input boxes accepts values from 0-256, press enter after inputting text to set the value\n"
						);
				break;
			case MODE_ABOUT:
				this.setTitle("About");
				text.setText(
						"DrawPlayground is a simple drawing tool written for the Saint Joseph High School\n"
						+ "Computer Programming with Java class of 2015-2016.\n"
						+ "\n"
						+ "Author: Ryan Luchs\n");
				break;
			default:
				this.setTitle("Invalid Mode");
				text.setText("Invalid Mode: This mode does not exist!");
				break;
		}
	}

}
