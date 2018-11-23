/**
 * 
 * @author William Chad Brown
 * 
 * Description:	This class is used to store the users answer history. This class will
 * 				take the numbers the program creates, and the input the users gives. and stores this information. 
 * 				When the user hits the history button, this information is stored and shown in a way the matches 
 * 				what the user was shown. 
 *
 */

public class AnswerHistory {

	// Global variables 
	private int numbOne;
	private int numbTwo;
	private int optionSelected;
	private int userAnswer;
	private String userCorrect;

	/**
	 * Constructor function used to create the object for each history item. 
	 * 
	 * @param x - the first integer in the math problem.
	 * @param y - the second integer in the math problem.
	 * @param option - A integer that points to the math function(+ = 0, - = 1, / = 2, * = 3).  
	 * @param answer - the user entered answer.
	 * @param isCorrect - boolean if the user entered the correct answer. 
	 * 
	 */
	public AnswerHistory(int x, int y, int option, int answer, boolean isCorrect){

		numbOne = x;
		numbTwo = y;
		optionSelected = option;
		userAnswer = answer;

		// String that is used to print to the frame if the user was correct. 
		if(isCorrect)
			userCorrect = "Correct!!";
		else
			userCorrect = "Incorrect!!";
	}

	/**
	 * 
	 * toString() function that takes the information stored in the object
	 * and returns a string that is formatted to make the information readable. 
	 * The information is formated depending on the operand that is used. And 
	 * some are formated in a way that orders the number so that no negative numbers
	 * exist. 
	 * 
	 */
	public String toString(){

		switch(optionSelected){

		// Case for addition. 
		case 0:
			return String.format("%d + %d = %d, Your answser %d was %s", numbOne, numbTwo, numbOne + numbTwo, userAnswer, userCorrect);

		// Case for subtraction. This will set the numbers so no negative answers is needed. 
		case 1:
			if(numbOne > numbTwo)
				return String.format("%d - %d = %d, Your answser %d was %s", numbOne, numbTwo, numbOne - numbTwo, userAnswer, userCorrect);
			else
				return String.format("%d - %d = %d, Your answser %d was %s", numbTwo, numbOne, numbTwo - numbOne, userAnswer, userCorrect);

		// Case for multiplication.
		case 2:
			return String.format("%d * %d = %d, Your answser %d was %s", numbOne, numbTwo, numbOne * numbTwo, userAnswer, userCorrect);

		// Case for division. This will set the numbers so the user does not run into fractions/decimal answers. 
		case 3:
			if(numbOne > numbTwo)
				return String.format("%d / %d = %d, Your answser %d was %s", numbOne, numbTwo, numbOne / numbTwo, userAnswer, userCorrect);
			else
				return String.format("%d / %d = %d, Your answser %d was %s", numbTwo, numbOne, numbTwo / numbOne, userAnswer, userCorrect);
		default:
			return "Error with selection";
		}
	}
}
