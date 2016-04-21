import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

/**
 * This is a frame that pops up after a menu option has been selected to save/load images and files
 * @author Ryley Danielson
 *
 */

public class SaveImageFrame extends JFrame implements ActionListener {
	
	JTextField name;
	JButton save;
	JFileChooser jfc;
	
	public SaveImageFrame(){
		super();
		
		
	    this.setLayout( new GridLayout( 1, 2 ) );
	    //this.setBorder( BorderFactory.createEtchedBorder() );
	    this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	    
	    name = new JTextField("New_Image_Name");
	    
	    jfc = new JFileChooser();
	    
	   // save = new JButton("Save"); 
	    //save.setActionCommand( "saveImg" );
	    //save.addActionListener( this );
	    
	    
	    //this.add(name);
	    
	   this.add(jfc);
	   File rr = new File(System.getProperty("user.home"));
	   jfc.setCurrentDirectory(rr);
	   jfc.setApproveButtonText("Save");
	   
	   
	   this.setSize(this.getPreferredSize());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		
		case ("saveImg"):
			
			//setVisible();
		
		}
	}
	
	/**
	 * resets the text in the text field
	 */
	public void resetName(){
		name.setText("New_Image_Name");
	}
	
	public String getName(){
		return name.getText();
	}
	

}
