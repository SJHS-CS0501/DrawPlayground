import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * A JPanel for picking colors for DrawPlayground
 * @author Ryan Luchs
 *
 */
public class ColorPanel extends JPanel implements ActionListener {

	/**
	 * Private JPanel for displaying a small centered sample box
	 * @author Ryan Luchs
	 *
	 */
	private class ColorSample extends JPanel implements MouseListener {
		
		// the current color
		public Color color;
		
		// color picker to leech off of
		public ColorPicker picker;
		
		/**
		 * ColorSample constructor
		 * @param p ColorPicker to get colors from
		 */
		public ColorSample(ColorPicker p) {
			color = p.getColor();
			picker = p;
			
			addMouseListener(this);
			repaint();
		}
		
		/**
		 * Paint the sample square
		 */
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(color);
			g.fillRect(getWidth()/2 - getWidth()/4, getHeight()/2 - getHeight()/4, getWidth()/2, getHeight()/2);
		}
		
		/**
		 * Sets the color of the sample square
		 * @param c The color
		 */
		public void setColor(Color c) {
			color = c;
			repaint();
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * Summons the ColorPicker upon a touch
		 */
		public void mousePressed(MouseEvent arg0) {
			picker.setVisible(true);
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private ColorSample sample;
	
	/**
	 * ColorPanel constructor
	 * @param p ColorPicker used to get colors
	 */
	public ColorPanel(ColorPicker p) {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEtchedBorder());
		
		sample = new ColorSample(p);
		add(sample, BorderLayout.CENTER);
		
		JButton button;
		button = new JButton("Update");
		button.setActionCommand("update");
		button.addActionListener(this);
		add(button, BorderLayout.SOUTH);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "update":
				sample.setColor(sample.picker.getColor());
				sample.picker.setVisible(false);
				break;
			default:
				break;
		}
	}
	
	/**
	 * Returns the current color
	 * @return The color
	 */
	public Color getColor() {
		return sample.color;
	}
	
}
