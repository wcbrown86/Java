/**
 * @author William Chad Brown
 * 
 * Description:	This project was to create a simple math tutor program with a simple user interface.
 * 				When the program launches the user is shown a screen that has a text box in the top 
 * 				center, with a text to the left. Along the bottom of the screen there are two drop
 * 				down option for difficulty and operation. Finally there is a history button to will 
 * 				show the user the questions answered and if you where correct or not. If the user
 * 				did not put in the correct answer the history will show the user the correct answer. 
 * 				This program does not work with negative numbers or negative answers. And it does not
 * 				account for fractions or decimal answers for division. 
 * 
 * 				This class is the main driver for the program, and only calls the needed classes for
 * 				the program to function. 
 * 
 */

// Import for setting up the main frame for the program. 
import javax.swing.JFrame;

public class TutorViewer{

	public static void main(String[] args){

		// Creates a new frame for the program.
		JFrame frame = new TutorFrame();

		// Sets the close button operation to exit the program.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Sets the title and other options for location of the frame 
		frame.setTitle("Math Tutor!!");

		// Code to set the location of the frame at start to the center of the screen
		frame.pack();
		frame.setLocationRelativeTo(null);

		// Makes the frame visible to the user. 
		frame.setVisible(true);
	}
}