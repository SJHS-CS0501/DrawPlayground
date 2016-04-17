import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ColorPanel extends JPanel implements ActionListener {
	 JPanel p;
	 ButtonGroup bg;
	 JColorChooser color;
	 
	 public ColorPanel(){
		 super();
		 this.setSize( 50, 200 );
	     this.setLayout( new GridLayout( 2, 2 ) );
	     this.setBorder( BorderFactory.createEtchedBorder() );
	     
	     bg = new ButtonGroup();
	     JRadioButton outline = new JRadioButton( "Outline" );
	     JRadioButton fill = new JRadioButton( "Fill" );
	     outline.setActionCommand( "rect" );
	     fill.setActionCommand( "cir" );
	     outline.addActionListener( this );
	     fill.addActionListener( this);
	     bg.add( outline );
	     bg.add( fill);
	     
	     color = new JColorChooser();
	        
	     p.add(outline);
	     p.add(fill);
	     p.add(color);
	 }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
