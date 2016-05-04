import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
 *
 * @author Julianna Nichols
 * @author woytek
 */
public class JMenuFrame extends JFrame implements ActionListener, Serializable {

	private static final long serialVersionUID = 1L;
	DrawingPane dPane = new DrawingPane();
	ToolPanel tPane = new ToolPanel();
	Scanner keyboard = new Scanner(System.in);
	File selectedFile = new File("Drawings");
	// FileInputStream fop = new FileInputStream(selectedFile);
	String fileName;
	int reply;

	public JMenuFrame() {
		super();

		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		JMenu subMenu;

		this.setLayout(new BorderLayout());
		this.setName("Jay Manue Teeest Frum");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(tPane, BorderLayout.WEST);
		this.add(dPane, BorderLayout.CENTER);

		menuBar = new JMenuBar();

		menu = new JMenu("File"); // title
		menuItem = new JMenuItem("New"); // menu item
		menuItem.setActionCommand("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open File..."); // item
		menuItem.setActionCommand("Open File");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Save"); // item
		menuItem.setActionCommand("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Exit"); // item
		menuItem.setActionCommand("Quit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		menu = new JMenu("Other Options"); // title
		menuItem = new JMenuItem("Red"); // item
		menuItem.setActionCommand("Red");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Orange"); // item
		menuItem.setActionCommand("Orange");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		subMenu = new JMenu("Star Points"); // title of submenu
		menuItem = new JMenuItem("Five (5)"); // item in submenu
		menuItem.setActionCommand("Five");
		menuItem.addActionListener(this);
		subMenu.add(menuItem);

		menuItem = new JMenuItem("Six (6)"); // item in submenu
		menuItem.setActionCommand("Six");
		menuItem.addActionListener(this);
		subMenu.add(menuItem);

		menuItem = new JMenuItem("Seven (7)"); // item in submenu
		menuItem.setActionCommand("Seven");
		menuItem.addActionListener(this);
		subMenu.add(menuItem);

		menuItem = new JMenuItem("Eight (8)"); // item in submenu
		menuItem.setActionCommand("Eight");
		menuItem.addActionListener(this);
		subMenu.add(menuItem);

		menuItem = new JMenuItem("Special"); // item in submenu
		menuItem.setActionCommand("Special");
		menuItem.addActionListener(this);
		subMenu.add(menuItem);

		menu.add(subMenu);

		menuBar.add(menu);

		menuBar.add(Box.createHorizontalGlue());

		menu = new JMenu("Help");
		menuItem = new JMenuItem("About");
		menuItem.setActionCommand("About");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("How to...");
		menuItem.setActionCommand("How to");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		this.setJMenuBar(menuBar);

		// this.setSize( new Dimension(this.getPreferredSize() ) );
		this.setSize(600, 600);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "New":
			System.out.println("'New' Pressed");
			break;
		case "Open File":
			System.out.println("'Open File' Pressed");
			JFileChooser fileChooser = new JFileChooser();
			int option = fileChooser.showOpenDialog(this);
			FileInputStream in;
			ObjectInputStream input;
			
			dPane.shapeList.clear();

			if (option == JFileChooser.APPROVE_OPTION) {
				
				selectedFile = fileChooser.getSelectedFile();
				
				try {
					in = new FileInputStream(selectedFile); //file ready to be read back into the pane
					input = new ObjectInputStream(in); //objects ready to be ready back into the pane
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				while(.available()) {
					
				}
				
			}
			break;
		case "Save Image":
			// ask if they want it saved here as a jpg

			fileName = JOptionPane.showInputDialog(dPane, "What do you want this file to be named?", "File name");
			// getting null pointer exception if the cancel button was clicked
			// on the input dialog box
			try {
				while (fileName.equals("")) {
					JOptionPane.showMessageDialog(dPane, "You must enter a file name!", "File name not entered!",
							JOptionPane.ERROR_MESSAGE);
					fileName = JOptionPane.showInputDialog(dPane, "What do you want this file to be named?",
							"File name");
				}
			} catch (Exception t) {

			}

			/*
			 * while(fileName.equals("")){ reply =
			 * JOptionPane.showConfirmDialog(dPane,
			 * "This file exists already!\nDo" +
			 * " you want to over-write this file?", "File Exists",
			 * JOptionPane.ERROR_MESSAGE, JOptionPane.YES_NO_OPTION);
			 * 
			 * if(reply == JOptionPane.YES_OPTION){ fileName =
			 * JOptionPane.showInputDialog(
			 * "What do you want this file to be named?"); } else { //delete old
			 * file and save the new one } }
			 */

			BufferedImage img = new BufferedImage(dPane.getWidth(), dPane.getHeight(), BufferedImage.TYPE_INT_RGB);
			dPane.print(img.getGraphics());
			try {
				ImageIO.write(img, "jpg", new File(fileName + ".jpg"));
				JOptionPane.showMessageDialog(dPane, "Image saved as " + fileName + ".jpg");

			} catch (IOException c) {
				System.out.println("Image not saved.");
			}
			break;
		case "Save":
			fileName = JOptionPane.showInputDialog(dPane, "What do you want this file to be named?", "File name");
			// getting null pointer exception if the cancel button was clicked
			// on the input dialog box
			try {
				while (fileName.equals("")) {
					JOptionPane.showMessageDialog(dPane, "You must enter a file name!", "File name not entered!",
							JOptionPane.ERROR_MESSAGE);
					fileName = JOptionPane.showInputDialog(dPane, "What do you want this file to be named?",
							"File name");
				}
			} catch (Exception t) {
				t.printStackTrace();
			}

			try {
				//file ready to write
				FileOutputStream out = new FileOutputStream(fileName);
				//objects ready to write
				ObjectOutputStream output = new ObjectOutputStream(out);

				for (int i = 0; i < dPane.shapeList.size(); i++) {
					output.writeObject(dPane.shapeList.get(i));
				}

			} catch (Exception f) {
				f.printStackTrace();
			}

			break;
		case "Six":
			System.out.println("'Six' Pressed");
			break;
		case "Seven":
			System.out.println("'Seven' Pressed");
			break;
		case "Eight":
			System.out.println("'Eight' Pressed");
			break;
		case "Special":
			System.out.println("'Special' Pressed");
			break;
		case "About":
			System.out.println("'About' Pressed");
			System.exit(0);
			break;
		case "How to":
			System.out.println("'How to' Pressed");
			System.exit(0);
			break;
		case "Quit":
			System.out.println("'Quit' Pressed");
			System.exit(0);
			break;
		default:
			System.out.println("You done messed up.");
			System.exit(-1);
			break;
		}
	}
}
