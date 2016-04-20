import javax.swing.JFrame;

/**
 *
 * @author Woytek
 * @author Julianna Nichols
 */
public class JMenuTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JMenuFrame myFrame = new JMenuFrame();
        myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
 
        /*
         * Contact Reader Writer: 
         * 		- text file
         * 		- used to be called ASCII [asky], 7-bit (store 128 different characters), doesn't really exist anymore
		 * 		- now it's UTF/unicode, many many bits, how java handles every bit of code
		 * Binary Files
		 * 		- not human readable
		 * 		- stored in bits, directly in binary format
		 * 		- page 729
		 * Serialization
		 * 		- allows you to take any object and store it to disk in one magic method
		 * 		- like two lines of code and you write the entire object to disk
		 * 		- as a programmer you don't have to worry how to read or write it to disk
		 * 		- implement serializable 
		 * 		- each object must implement serializable
		 * 		- key words:
		 * 			- fileOutputStream = new FileOutputStream("feed it name of file");
		 * 			- objectOutputStream = new objectOutputStream(feed it name of fileOutputStream);
		 * 			...
		 * 			outFile.writeObject(object);
		 * 			- same to read but input
		 * 			- cast to correct object
		 * 				- obj = (MyRectangle)inFile.readObject();
		 * 		- this is for when 
		 * 		- for loop to write to disk, clear the arrayList, then when you open it again for loop to repopulate arrayList
		 * 
		 * Taking pane and saving pane as .jpeg
		 * 
		 * use JFileChooser...so user can chooser what file they want to work with
         */		
    }
}