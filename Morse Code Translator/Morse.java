/**
 * 
 * @author - William Chad Brown
 * 
 * Description:	In this program, a file is read that contains a 1-9 and A-Z morse code
 * 				translation. This information is placed in object that holds the information 
 * 				in the file. The user is then given a GUI interface that will ask the user to 
 * 				enter a word or a phrase to translate to morse code. Once the user enters the 
 * 				information into the program another pop-up box is shown. This box will show the
 * 				user the phrase that they entered and the morse code translation. Where . is the 
 * 				symbol for a short tone, and - is the symbol for a long tone. The user can 
 * 				continue to  
 * 
 */

// Imports used to read the file and store the information.
import java.io.*;
import java.util.Scanner;

// Used to show the user the GUI of the program. 
import javax.swing.JOptionPane;


public class Morse {

	/**
	 * 
	 * The main function for the program. In this function the file is read 
	 * and the information in the file is placed in the Code object. The user
	 * is shown an input box, then a message is shown once the user inputs the 
	 * information to translate. Then the user is asked if they would like to 
	 * translate another phrase. 
	 * 
	 * @param args - system argument array, this is not used in this application.
	 * 
	 */
	public static void main(String[] args){

		// Creates the object to store the translation information.
		Code code = new Code();

		// Try/Catch block that attempts to open the file and read the information.
		// If the information can be read then the pop up box will be shown to the user
		// if not an error message is shown to the user. 
		try{
			
			// Scanner object that will check the file and read the information in the file. 
			Scanner file = new Scanner(new File("Morse.txt"));

			// While the file has more information to read the program will read the next line,
			// and split the information and place it in the Code object.
			while(file.hasNextLine()){
				
				String str = file.nextLine();
				
				// the first character of the string is the letter or number,
				// the rest after the space is the morse code translation. 
				code.add(str.substring(0, 1), str.substring(1));
			}
			
			// Closes the file.
			file.close();
			
			// Continue variable, this is set from the selection of yes or no in the confirmDialog box.
			int cont;
			
			// Do while that keeps the program running until the user hits the NO button on the confirmDialog box.
			do{
				
				// str is used to store the input from the user. and translation is used to store and show the translated user input.
				String str;
				String translation;
				
				// Grabs the users input from the dialog box.
				str = JOptionPane.showInputDialog(null, "Please enter a word or phrase to tranlate: ", "Morse Code!", JOptionPane.PLAIN_MESSAGE);
				
				// calls the code translate function to get the morse code that represents the users input.
				translation = code.translate(str);

				// Shows the user the translated string.
				JOptionPane.showMessageDialog(null, "Phrase entered: " + str + "\nIn morse code: " + translation, "Morse Code!", JOptionPane.PLAIN_MESSAGE);

				// Asks the user if they would like to continue or exit. 
				cont = JOptionPane.showConfirmDialog(null, "Would you like to translate another word?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				
			}while(cont != JOptionPane.NO_OPTION);
			
		// Catch if no file is found, if this happens the user is shows an error message. 
		} catch(FileNotFoundException e) {
			
			JOptionPane.showMessageDialog(null, "No File Found, please check your file location and try again!", "Error", JOptionPane.ERROR_MESSAGE);
		
		// Catch for null pointer, this is to catch if the user hits the exit button in the top left corner, if the user does this the program closes. 
		} catch(NullPointerException e) {
			
			System.exit(0);
		}
		
		// Exits the program. 
		System.exit(0);
	}

}
