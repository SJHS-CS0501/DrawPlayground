import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ColorPanel extends JPanel implements ActionListener {
	 
	 static int fo;
	 public ColorPanel(){
		 super();
		 this.setSize( 50, 200 );
	     this.setLayout( new GridLayout( 2, 2 ) );
	     this.setBorder( BorderFactory.createEtchedBorder() );
	     
	     JPanel p = new JPanel();
	     JPanel p2 = new JPanel();
		 ButtonGroup bg;
		 //JColorChooser color;
	     
	     bg = new ButtonGroup();
	     JRadioButton outline = new JRadioButton( "Outline" );
	     JRadioButton fill = new JRadioButton( "Fill" );
	     outline.setActionCommand( "outline" );
	     fill.setActionCommand( "fill" );
	     outline.addActionListener( this );
	     fill.addActionListener( this);
	     bg.add( outline );
	     bg.add( fill);
	     
	     p.setLayout(new GridLayout(2,0));
	        
	     p.add(outline);
	     p.add(fill);
	     
	 add(p);
	    
	     this.setSize(20,20);
	     this.setVisible( true );
	 }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		 switch( e.getActionCommand() ) {
	        
	        case "fill":
	        	fo =1;
	        	break;
	        	
	        case ("outline"):
	        	fo =2;
	        	break;

	        default:
	                System.out.println( "EVIL EVIL BAD PLACE 4" );
	                System.exit(-1);
	                break;
	        }
	}

}
