
/**
 * This class is designed to determine where the
 * mouse was pressed within a drawing pane and then
 * will use that information to create shapes inside
 * the drawing area.
 * @author Jack Protivnak
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class DrawingPane extends JPanel implements ActionListener, MouseMotionListener, MouseListener, Serializable {

	private JFileChooser file;
	public static final long serialVersionUID = 1;
	FileOutputStream outStream;
	ObjectOutputStream outFile;
	FileInputStream inStream;
	ObjectInputStream inFile;
	private DrawingObject obj;
	private ArrayList<DrawingObject> objectList = new ArrayList<DrawingObject>();
	private boolean move = false;

	/**
	 * Constructor for the class. Adds action listeners and the actual drawing
	 * pane is created.
	 */
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
	 * Method will repaint the pane every time a drawing object is created or
	 * modified.
	 * 
	 * @param g
	 */
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

	/**
	 * Detects mouse clicks.
	 * 
	 * @param e
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 * Detects mouse presses. Also determines which shape is going to be drawn
	 * and then creates a object based on that shape.
	 * 
	 * @param e
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// handle what happens when the mouse is clicked. This will hinge upon
		// the mode the user has selected in the tool panel.

		System.out.println("mousePressed");
		switch (ToolPanel.choice) {
		case 1:
			System.out.println("rectangle");
			obj = new MyRectangle(false);
			obj.setColor(ToolPanel.chooser.getColor());
			obj.start(e.getPoint());
			objectList.add(obj);
			break;

		case 2:
			System.out.println("star");
			obj = new MyStar(false);
			obj.setColor(ToolPanel.chooser.getColor());
			obj.start(e.getPoint());
			objectList.add(obj);
			break;

		case 3:
			System.out.println("circle");
			obj = new MyCircle(false);
			obj.setColor(ToolPanel.chooser.getColor());
			obj.start(e.getPoint());
			objectList.add(obj);
			break;

		case 4:
			System.out.println("line");
			obj = new MyLine();
			obj.setColor(ToolPanel.chooser.getColor());
			obj.start(e.getPoint());
			objectList.add(obj);
			break;

		case 5:
			System.out.println("oval");
			obj = new MyOval(false);
			obj.setColor(ToolPanel.chooser.getColor());
			obj.start(e.getPoint());
			objectList.add(obj);
			break;

		case 6:
			System.out.println("square");
			obj = new MySquare(false);
			obj.setColor(ToolPanel.chooser.getColor());
			obj.start(e.getPoint());
			objectList.add(obj);
			break;

		case 7:
			System.out.println("move");
			for (int i = objectList.size() - 1; i >= 0; i--) {
				if (objectList.get(i).contains(e.getPoint())) {
					obj = objectList.get(i);
					System.out.println("Coconut");
					move = true;
					break;
				}
			}
			break;

		case 8:
			System.out.println("delete");
			break;

		case 9:
			System.out.println("unknown shape");
			obj = new MyShape(false);
			obj.setColor(ToolPanel.chooser.getColor());
			obj.start(e.getPoint());
			objectList.add(obj);
			break;

		case 10:
			System.out.println("rectangle");
			obj = new MyRectangle(true);
			obj.setColor(ToolPanel.chooser.getColor());
			obj.start(e.getPoint());
			objectList.add(obj);
			break;

		case 11:
			System.out.println("star");
			obj = new MyStar(true);
			obj.setColor(ToolPanel.chooser.getColor());
			obj.start(e.getPoint());
			objectList.add(obj);
			break;

		case 12:
			System.out.println("circle");
			obj = new MyCircle(true);
			obj.setColor(ToolPanel.chooser.getColor());
			obj.start(e.getPoint());
			objectList.add(obj);
			break;

		case 13:
			System.out.println("oval");
			obj = new MyOval(true);
			obj.setColor(ToolPanel.chooser.getColor());
			obj.start(e.getPoint());
			objectList.add(obj);
			break;

		case 14:
			System.out.println("square");
			obj = new MySquare(true);
			obj.setColor(ToolPanel.chooser.getColor());
			obj.start(e.getPoint());
			objectList.add(obj);
			break;

		case 15:
			System.out.println("unknown shape");
			obj = new MyShape(true);
			obj.setColor(ToolPanel.chooser.getColor());
			obj.start(e.getPoint());
			objectList.add(obj);
			break;

		default:
			System.out.println("ERROR");
			break;

		}

	}

	/**
	 * Detects mouse drags and repaints screen. Also drags the object to be
	 * resized.
	 * 
	 * @param e
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if (obj != null) {
			if (move) {
				obj.move(e.getPoint());
			} else {
				obj.drag(e.getPoint());
			}
			repaint();
		}
	}

	/**
	 * Detects mouse releases. Also repaints pane.
	 * 
	 * @param e
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased()");
		repaint();
		obj = null;
		move = false;
	}

	/**
	 * Detects mouse entered.
	 * 
	 * @param e
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * Detects mouse exited.
	 * 
	 * @param e
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * Detects mouse movements.
	 * 
	 * @param e
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
	}

	public void writeFile() {
		String sb = "TEST CONTENT";
		file = new JFileChooser();
		file.setCurrentDirectory(new File("Drawing Images"));
		int retrival = file.showSaveDialog(null);

		if (retrival == JFileChooser.APPROVE_OPTION) {
			try (FileWriter fw = new FileWriter(file.getSelectedFile() + ".jpg")) {
				fw.write(sb.toString());
			} catch (Exception es) {
				System.out.println("Exception:" + es.getMessage());
			}
		}
		file.setCurrentDirectory(new File("Drawings"));
		try {
			outStream = new FileOutputStream(file.getSelectedFile());
			outFile = new ObjectOutputStream(outStream);
			for (int i = objectList.size() - 1; i >= 0; i--) {
				outFile.writeObject(objectList.get(i));
				System.out.println("Coconut");
			}
		} catch (Exception eq) {
			System.out.println("Exception: " + eq.getMessage());
			eq.printStackTrace();
		}
	}

	public void openFile() {
		DrawingObject object;
		file = new JFileChooser();
		file.setCurrentDirectory(new File("Drawings"));
		int open = file.showOpenDialog(null);

		if (open == JFileChooser.APPROVE_OPTION) {
			objectList.clear();
			repaint();
			try {
				inStream = new FileInputStream(file.getSelectedFile());
				inFile = new ObjectInputStream(inStream);
				while (inStream.available() > 0) {
					Scanner input = new Scanner(file.getSelectedFile());
					while (input.hasNextLine()) {
						object = (DrawingObject) inFile.readObject();
						objectList.add(object);
						System.out.println("Pop");
						repaint();
					}
				}
			} catch (Exception es) {
				System.out.println("Cannot Retrieve File: " + es.getMessage());
			}
		}
	}
}
