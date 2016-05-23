import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * This is a color picker for DrawPlayground
 * @author Ryan Luchs
 *
 */
public class ColorPicker extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Private class to get a 0-255 value for rbg color values
	 * Works via sliders and text fields
	 * @author ryan
	 *
	 */
	private class ValuePicker extends JPanel implements ActionListener, ChangeListener {
		
		private static final long serialVersionUID = 1L;
		
		private int value = 0;
		
		// text field to get direct values
		private JTextField valueText  = new JTextField(3);
		
		// slider to allow easier mnipulation of values
		private JSlider valueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		
		// the ColorPicker this object belongs to
		private ColorPicker parent;
		
		// borders for the text field to shot the user if the input is valid
		private Border invalid = BorderFactory.createLineBorder(Color.RED);
		private Border valid = BorderFactory.createLineBorder(Color.BLACK);

		/**
		 * ValuePicker constructor
		 * @param color The color to set the title JLabel
		 * @param name The title for the text field
		 * @param parent The ColorPicker this object returns its value to
		 */
		public ValuePicker(Color color, String name, ColorPicker parent) {
			
			this.parent = parent;
			
			setLayout(new FlowLayout());
			//setVisible(true)
			
			// value slider
			valueSlider.addChangeListener(this);
			add(valueSlider);
			
			// Label to show what color this meant supposed to change
			JLabel label = new JLabel(name);
			label.setForeground(color);
			add(label);
			
			// The text field for the direct value input
			valueText.setBorder(valid);
			valueText.setText("0");
			valueText.addActionListener(this);
			
			add(valueText);
		}
		
		/**
		 * Sets this object value
		 * @throws IllegalArgumnetException if the given value < 0 or > 255
		 * @param value The value
		 */
		public void setValue(int value) {
			if(value < 0 || value > 255) {
				throw new IllegalArgumentException("Invalid value");
			}
			this.value = value;
		}
		
		/**
		 * Returns this object's value
		 * @return The value
		 */
		public int getValue() {
			return value;
		}
		
		/**
		 * Sets the value to what's in the text field when enter is pressed
		 * Also updates the sample panel
		 */
		public void actionPerformed(ActionEvent e) {
			
			if(valueText.getText().matches("[0-9]{1,3}")) {
				int temp = Integer.parseInt(valueText.getText());
				
				if(temp <= 255) {
					value = temp;
					valueSlider.setValue(temp);
					valueText.setBorder(valid);
					
					parent.setThisColor();
				} else {
					valueText.setBorder(invalid);
				}
			} else {
				valueText.setBorder(invalid);
			}
		}

		/**
		 * Changes the value using the slider
		 * Also updates the sample panel
		 */
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider)e.getSource();
	        if (source.getValueIsAdjusting()) {
	        	value = source.getValue();
	        	valueText.setText(Integer.toString(value));
	        	valueText.setBorder(valid);
	        	parent.setThisColor();
	        }
			
		}
		
	}
	
	// ValuePickers for the rgb values
	ValuePicker red = new ValuePicker(Color.RED, "R: ", this);
	ValuePicker green = new ValuePicker(Color.GREEN, "G: ", this);
	ValuePicker blue = new ValuePicker(Color.BLUE, "B: ", this);
	
	// Shows the current color
	JPanel sample = new JPanel();
	
	/**
	 * ColorPicker constructor
	 */
	public ColorPicker() {
		super("Color Picker");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		setThisColor();
		sample.setPreferredSize(new Dimension(100, 100));
		sample.setBorder(BorderFactory.createEtchedBorder());
		add(sample, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		
		add(panel, BorderLayout.SOUTH);
		
		setVisible(false);
		setResizable(false);
        pack();
	}

	/**
	 * Get the color selected by this object
	 * @return The color
	 */
	public Color getColor() {
		return new Color(red.getValue(), green.getValue(), blue.getValue());
	}
	
	/**
	 * Sets the color
	 */
	public void setThisColor() {
		sample.setBackground(getColor());
	}
	
}
