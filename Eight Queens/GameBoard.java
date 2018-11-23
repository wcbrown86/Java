/**
 * 
 * @author William Chad Brown
 * 
 * Description:	The GameBoard class stores the state of a game board. This
 * 				is used for the current state, a temporary state, and the possible
 * 				next states of the board. This is also used to create a new random board.
 * 
 */

// Random class import used to create new boards be randomly placing a 
// queen on the board in each row. 
import java.util.Random;

public class GameBoard {
	
	// Global variables used to keep track of the current state of the board. 
	private int heuristic, gameSize;
	private int[] currentState;
	
	
	/**
	 * 
	 * Constructor for the GameBoard class. This constructor calls
	 * the newBoard function after setting up the global variables. 
	 * 
	 * @param size - An integer that represents the size of the board,
	 * 				 this size is currently set to 8 and can be changed 
	 * 				 in the main.java file. 
	 * 
	 */
	public GameBoard(int size){
		
		currentState = new int[size];
		gameSize = size;
		
		newBoard(size);
		
	}
	
	/**
	 * 
	 * Constructor for the GameBoard class that takes a board object,
	 * and a heuristic. The constructor sets the information sent to 
	 * the stored global variables. 
	 * 
	 * @param newQueens - GameBoard object
	 * @param h - An integer that represents the heuristic of the new board.
	 * 
	 */
	public GameBoard(int[] newQueens, int h){
		currentState = newQueens;
		gameSize = currentState.length;
		heuristic = h;
	}
	
	/**
	 * 
	 * This function creates a new random board of 
	 * size N, and each value of the array stores an
	 * integer of the row location of the queen. 
	 * 
	 * @param size - takes an integer to set the size of
	 * 				 the game board. Currently the size is set 
	 * 				 to 8, but this can be changed in the main.java
	 * 				 file to adjust the size of the problem. 
	 * 
	 */
	public void newBoard(int size) {
		int[] temp = new int[size];
		
		for(int i = 0; i < size; i++){
			
			Random rand = new Random();
			temp[i] = rand.nextInt(gameSize);

		}
		currentState = temp;
	}
	
	/**
	 * 
	 * Prints the Array out in a 2D representation of the 
	 * game board. The function loops and prints a 2D array.
	 * The row information for the location of the queen is stored
	 * in the value of the currentState array.
	 * 
	 */
	public void printBoard(){
		for(int i = 0; i < currentState.length; i++){
			for(int j = 0; j < currentState.length; j++){
				if(currentState[j] == i){
					System.out.print("  1");
				}else{
					System.out.print("  0");
				}
			}
			System.out.println("\n");
		}
	}

	/**
	 * 
	 * Get Function that returns the integer value of the 
	 * heuristic.
	 * 
	 * @return - an integer that represents the heuristic of the
	 * 			 board. The heuristic is a number of how many conflicts
	 * 			 that currently exist in the board.  
	 * 
	 */
	public int getHuristic() {
		return heuristic;
	}

	/**
	 * 
	 * Setting function for the heuristic of the board. 
	 * 
	 * @param huristic
	 * 
	 */
	public void setHeuristic(int heuristic) {
		this.heuristic = heuristic;
	}
	
	/**
	 * 
	 * Get function that will return the current 
	 * state of the board. 
	 * 
	 * @return - An array that has a number that represents the location
	 * 			 in the column of a 2D array. 
	 * 
	 */
	public int[] getQueens(){
		return currentState;
	}

}
