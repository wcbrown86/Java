/**
 * 
 * @author William Chad Brown
 * 
 * Description:	This class is set up to check the state of the board to 
 * 				find the current heuristic state of the board. The heuristic 
 * 				is an integer that shows the number of conflicts that exist on 
 * 				the board. A conflict is described as any two queens that can 
 * 				attack another queen. 
 *
 */

public class CheckBoard {
	
	// Global GameBoard variable. 
	GameBoard game;
	
	/**
	 * 
	 * Constructor that takes on object as a parameter. This stores the
	 * state of the board to be checked. 
	 * 
	 * @param newGame - a GameBoard object the sets the global GameBoard 
	 * 					object to the one sent to the constructor. 
	 * 
	 */
	public CheckBoard(GameBoard newGame){
		
		this.game = newGame;
	}
	
	/**
	 * 
	 * Function that finds the heuristic value of the current CheckBoard object.
	 * This no parameter function checks the current objects heuristic. 
	 * 
	 * @return - An integer that represents the heuristic value of the stored GameBoard.
	 * 
	 */
	public int findHeuristic(){
		
		int huristic = 0;
		int[] queens = game.getQueens();
		
		for(int i = 0; i < queens.length; i++){
			for(int j = (i+1); j < queens.length; j++){
				
				if(queens[i] == queens[j])
					huristic++;
				if(Math.abs(j-i) == Math.abs(queens[j] - queens[i]))
					huristic++;
			}
		}
		
		return huristic;
	}
	
	/**
	 * 
	 * This findHeuristic function takes an array to check the for the 
	 * boards heuristic. 
	 * 
	 * @param test - an array representing the current state of a board
	 * 				 to check for its current heuristic value. 
	 * 
	 * @return	- 	An integer value representing the heuristic value of the 
	 * 			  	board information passed to the function.
	 *  
	 */
	public int findHeuristic(int[] test){
		int huristic = 0;
		int[] queens = test;
		
		for(int i = 0; i < queens.length; i++){
			for(int j = (i+1); j < queens.length; j++){
				
				if(queens[i] == queens[j])
					huristic++;
				if(Math.abs(j-i) == Math.abs(queens[j] - queens[i]))
					huristic++;
			}
		}
		
		return huristic;
	}

}
