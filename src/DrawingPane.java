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
import java.util.ArrayList;
import javax.swing.*;

public class DrawingPane extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
	private DrawingObject obj;
	private ArrayList<DrawingObject> objectList = new ArrayList<DrawingObject>();
	private boolean draw = false;

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

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < objectList.size(); i++) {
			objectList.get(i).draw(g);
		}
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

		System.out.println("mousePressed");
		switch (ToolPanel.choice) {
		case 1:
			System.out.println("rectangle");
			obj = new MyRectangle();
			obj.start(e.getPoint());
			objectList.add(obj);
			break;

		case 2:
			System.out.println("star");
			break;

		case 3:
			System.out.println("circle");
			break;

		case 4:
			System.out.println("line");
			obj = new MyLine();
			obj.start(e.getPoint());
			objectList.add(obj);
			break;

		case 5:
			System.out.println("move");

			break;

		case 6:
			System.out.println("delete");
			break;

		default:
			System.out.println("ERROR");
			break;

		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		obj.drag(e.getPoint());
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased()");
		repaint();
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
}
