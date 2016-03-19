import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * 
 */

/**
 * This is a color picker for DrawPlayground
 * @author ryan
 *
 */
public class ColorPicker extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private class ValuePicker extends JPanel implements ActionListener, ChangeListener {
		
		private static final long serialVersionUID = 1L;
		
		private int value = 0;
		
		private JTextField valueText  = new JTextField(3);
		private JSlider valueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		
		private ColorPicker parent;
		
		private Border invalid = BorderFactory.createLineBorder(Color.RED);
		private Border valid = BorderFactory.createLineBorder(Color.BLACK);

		public ValuePicker(Color color, String name, ColorPicker parent) {
			
			this.parent = parent;
			
			setLayout(new FlowLayout());
			//setVisible(true)
			
			valueSlider.addChangeListener(this);
			add(valueSlider);
			
			JLabel label = new JLabel(name);
			label.setForeground(color);
			add(label);
			
			valueText.setBorder(valid);
			valueText.setText("0");
			valueText.addActionListener(this);
			
			add(valueText);
		}
		
		public void setValue(int value) {
			if(value < 0 || value > 255) {
				throw new IllegalArgumentException("Invalid value");
			}
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
		@Override
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

		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider)e.getSource();
	        if (source.getValueIsAdjusting()) {
	        	value = source.getValue();
	        	valueText.setText(Integer.toString(value));
	        	
	        	parent.setThisColor();
	        }
			
		}
		
	}
	
	ValuePicker red = new ValuePicker(Color.RED, "R: ", this);
	ValuePicker green = new ValuePicker(Color.GREEN, "G: ", this);
	ValuePicker blue = new ValuePicker(Color.BLUE, "B: ", this);
	
	JPanel sample = new JPanel();
	
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
		
		setVisible(true);
		setResizable(false);
        pack();
	}

	public Color getColor() {
		return new Color(red.getValue(), green.getValue(), blue.getValue());
	}
	
	public void setThisColor() {
		sample.setBackground(getColor());
	}
	
}
