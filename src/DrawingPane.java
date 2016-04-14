import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawingPane extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
	
	ArrayList<DrawingObject> shapeList= new ArrayList<DrawingObject>();
	private static final long serialVersionUID = 1L;
	public static String shape;
	DrawingObject drawingObject;
	static int sizeX, sizeY;
	JFrame colors;
	boolean yes;

    public DrawingPane() {
        super(); // always call super() in an extended/derived class!
        /*
        this.setSize( 500, 500 );
        setSize( getPreferredSize() );
        size is handled by parent pane placement in JFrame
        */
        
        setBorder( BorderFactory.createLineBorder(Color.BLACK) ); //border
        setVisible( true );
        
        addMouseListener( this ); //mouse listener (clicks)
        addMouseMotionListener( this ); //mouse motion listener (drags)

    }
    
    /**
     * actionPerformed is here in case we need it later. Not currently used.
     * @param e 
     */
    public void actionPerformed( ActionEvent e ) {
        switch( e.getActionCommand() ) {
            default:
                System.out.println( "No...bad place" );
                System.exit(-1);
                break;
        }
    }
    
    public void paintComponent( Graphics g) {
    	super.paintComponent(g);
    	for(int i = 0; i < shapeList.size(); i++) {
    		shapeList.get(i).draw(g);
    	}
    }
    
    /**
     * Allows the user to change the color of the shape
     */
    public void changeColor() {
    	
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    	int x = e.getX();
    	int y = e.getY();
        System.out.println( "mousePressed(" + x + "," + y + ")" );
        
        switch(shape) {
        case "Line":
        	drawingObject = new MyLine();
        	drawingObject.start(e.getPoint());
        	shapeList.add(drawingObject);
        	break;
        case "Rectangle":
        	drawingObject = new MyRectangle();
        	drawingObject.start(e.getPoint());
        	shapeList.add(drawingObject);
        	break;
        case "Circle":
        	drawingObject = new MyCircle();
        	drawingObject.start(e.getPoint());
        	shapeList.add(drawingObject);
        	break;
        case "Star":
        	drawingObject = new MyStar();
        	drawingObject.start(e.getPoint());
        	shapeList.add(drawingObject);
        	break;
        case "Move shape":
        	// will select top shape
        	for(int i = shapeList.size()-1; i >= 0; i--) {
        		if(shapeList.get(i).contains(e.getPoint())){
        			drawingObject = shapeList.get(i);
        			yes = true;
        			break;
        		}
        	}
        	break;
        case "Choose color":
        	System.out.print("hi color chooser");
        	colors = new JFrame( "Color Chooser"  );
        	colors.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	colors.setSize(200, 300);
        	colors.setVisible(true);
        	break;
        default:
        	System.out.print( "Bad" );
        	System.exit(-1);
        	break;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       int x = e.getX();
       int y = e.getY();
       
       if(yes){
    	  drawingObject.move(e.getPoint());
       } else {
    	  drawingObject.drag(e.getPoint());
       }
       
       repaint();
       System.out.println( "mouseDragged(" + x + "," + y + ")" );
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    	int x = e.getX();
        int y = e.getY();
        repaint();
        yes = false;
        drawingObject = null; //so it won't re-modify the old rectangle
        System.out.println( "mouseReleased(" + x + "," + y + ")" );
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
