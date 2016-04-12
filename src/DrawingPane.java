/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woytek
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawingPane extends JPanel implements ActionListener, MouseMotionListener, MouseListener {

	public DrawingObject obj = null;
	public ArrayList<DrawingObject> objList = new ArrayList<DrawingObject>();

	public DrawingPane() {
		super(); // always call super() in an extended/derived class!
		// this.setSize( 500, 500 );
		// setSize( getPreferredSize() );
		// size is handled by parent pane placement in JFrame
		// make a border
		setBorder(BorderFactory.createLineBorder(Color.RED));
		setVisible(true);

		// we need both a mouse listener (for clicks)...
		addMouseListener(this);
		// ... and a mouse motion listener (for drags)!
		addMouseMotionListener(this);

	}

	/**
	 * actionPerformed is here in case we need it later. Not currently used.
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		default:
			System.out.println("EVIL BAD PLACE TWO");
			System.exit(-1);
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// handle what happens when the mouse is clicked. This will hinge upon
		// the mode the user has selected in the tool panel.

		System.out.println("mousePressed()");
		switch (ToolPanel.buttonSelected) {

		case (0):

			obj = new MyRectangle();
			objList.add(obj);
			obj.start(e.getPoint());

			break;
		case (1):

			obj = new MyCircle();
			objList.add(obj);
			obj.start(e.getPoint());

			break;
		case (2):

			obj = new DrawLine();
			objList.add(obj);
			obj.start(e.getPoint());
			break;
		case (3):

			obj = new MyStar();
			objList.add(obj);
			obj.start(e.getPoint());
			break;

		case (4):

			for (int ctr = objList.size() - 1; ctr >= 0; ctr--) {
				if (objList.get(ctr).contains(e.getPoint())) {
					obj = objList.get(ctr);
					break;
				}

			}
			break;
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (obj != null) {
			if (ToolPanel.buttonSelected == 4) {
				/*
				originX = originX - e.getX();
				originY = originY - e.getY();
				*/
				obj.move(e.getPoint());
				System.out.println("Moving");
			} else {
				obj.drag(e.getPoint());
			}
			repaint();
		}
		System.out.println("mouseDragged( " + x + ", " + y + " )");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased()");
		repaint();
		obj = null;

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int ctr = 0; ctr < objList.size(); ctr++) {
			objList.get(ctr).draw(g);
		}
	}
}
