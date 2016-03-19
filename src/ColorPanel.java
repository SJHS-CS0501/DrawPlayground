import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 
 */

/**
 * A JPanel for picking colors for DrawPlayground
 * @author ryan
 *
 */
public class ColorPanel extends JPanel implements ActionListener {

	private class ColorSample extends JPanel implements MouseListener {
		
		public Color color;
		
		public ColorPicker picker;
		
		public ColorSample(Color c, ColorPicker p) {
			color = c;
			picker = p;
			
			addMouseListener(this);
			repaint();
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(color);
			g.fillRect(getWidth()/2 - getWidth()/4, getHeight()/2 - getHeight()/4, getWidth()/2, getHeight()/2);
		}
		
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

		@Override
		public void mousePressed(MouseEvent arg0) {
			picker.setVisible(true);
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	ColorSample sample;
	
	public ColorPanel(ColorPicker p) {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEtchedBorder());
		
		sample = new ColorSample(p.getColor(), p);
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
	
	public Color getColor() {
		return sample.color;
	}
	
}
