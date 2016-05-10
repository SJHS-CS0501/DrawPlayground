import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.io.*;

public class DrawingPane extends JPanel implements ActionListener, MouseMotionListener, MouseListener, Serializable {

	public static ArrayList<DrawingObject> shapeList = new ArrayList<DrawingObject>();
	private static final long serialVersionUID = 1L;
	public static String shape;
	public static Color color;
	DrawingObject drawingObject;
	int sizeX, sizeY;
	JFrame colors;
	boolean moving;

	public DrawingPane() {
		super(); // always call super() in an extended/derived class!
		setBorder(BorderFactory.createLineBorder(Color.BLACK)); // border
		setVisible(true);

		addMouseListener(this); // mouse listener (clicks)
		addMouseMotionListener(this); // mouse motion listener (drags)

	}

	/**
	 * actionPerformed is here in case we need it later. Not currently used.
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		default:
			System.out.println("No...bad place");
			System.exit(-1);
			break;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < shapeList.size(); i++) {
			shapeList.get(i).draw(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		/*
		 * error is thrown if a button isn't selected and they click the on the
		 * drawingPane
		 */
		try {
			switch (shape) {
			case "Line":
				drawingObject = new MyLine();
				drawingObject.setColor(ToolPanel.colorChooser.getColor());
				drawingObject.start(e.getPoint());
				shapeList.add(drawingObject);
				break;
			case "Rectangle":
				drawingObject = new MyRectangle();
				drawingObject.setColor(ToolPanel.colorChooser.getColor());
				drawingObject.start(e.getPoint());
				shapeList.add(drawingObject);
				break;
			case "Circle":
				drawingObject = new MyCircle();
				drawingObject.setColor(ToolPanel.colorChooser.getColor());
				drawingObject.start(e.getPoint());
				shapeList.add(drawingObject);
				break;
			case "Star":
				drawingObject = new MyStar();
				drawingObject.setColor(ToolPanel.colorChooser.getColor());
				drawingObject.start(e.getPoint());
				shapeList.add(drawingObject);
				break;
			case "Move shape":
				// will select top shape
				for (int i = shapeList.size() - 1; i >= 0; i--) {
					if (shapeList.get(i).contains(e.getPoint())) {
						drawingObject = shapeList.get(i);
						moving = true;
						break;
					}
				}
				break;
			default:
				System.out.println("Bad");
				System.exit(-1);
				break;
			}
		} catch (Exception t) {
			t.printStackTrace();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (moving) {
			drawingObject.move(e.getPoint());
		} else {
			try {
				drawingObject.drag(e.getPoint());
			} catch (Exception b) {
				b.printStackTrace();
			}
		}

		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		repaint();
		moving = false;
		drawingObject = null; // so it won't re-modify the old rectangle
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
