/**
 * 
 * @author William Chad Brown
 * 
 * Description:	The Eight Queens problem. The program takes a randomly created 8x8 board.
 * 				with a chess queen placed on each row. Each queen must be placed on the 
 * 				board so that it can not attack any other queen on the board. This program can 
 * 				solve this problem and be scaled up to solve larger versions of the problem. But the 
 * 				run time scales quickly. The program will run until it solves a board of size nxn. Once the 
 * 				board gets above 10x10 size the time the program runs will be beyond 30 seconds. The program
 * 				will track the number of restarts and changes that are made, and print this information out 
 * 				as the program works. 
 * 
 */

import java.util.ArrayList;

public class Main {
	
	 

	public static void main(String[] args) {
		
		// Variables, size determines the size of the NxN board.
		int size = 8;
		
		// Creates a new board to solve the problem.
		GameBoard board= new GameBoard(size);
		CheckBoard check = new CheckBoard(board);
		
		// tracks the number of state changes made, and the number of
		// restarts. 
		int changes = 0;
		int restart = 0;
		
		//ArrayList that holds the new boards. With better Heuristics. 
		ArrayList<GameBoard> newBoards = new ArrayList<GameBoard>();
		
		// Heuristic is used to find a state of a board that is better
		// than the current board. 
		board.setHeuristic(check.findHeuristic());
		
		// Do While, loop that will keep the program running,
		// until a solution is found. If the program gets to a 
		// point when no solution is found, the board is reset. 
		do{
			
			// Clear the newBoards ArrayList.
			newBoards.clear();
			
			// If the heuristic is 0, then a solution is found. Print the board. 
			if(board.getHuristic() == 0){
				
				// Prints the current state of the board
				System.out.println("Current State");
				board.printBoard();
				
				// Tells the user how many state changes and restarts happend. 
				System.out.println("Solution Found! \n"
						+ "State Changes: " + changes + "\n"
						+ "Restarts: " + restart);
				
			// If more solutions are possible search for a better state. 
			}else{
				
				// Temp board that will be manipulated to find possible next states.
				int[] test = board.getQueens();
	
				// Loops through the board checking new locations of a queen in 
				// each row checking for a better state.
				for(int i = 0; i < test.length; i++){
					int hold = test[i];
					for(int j = 0; j < test.length; j++){
						test[i] = j;
						int h = check.findHeuristic(test);
						if(h < board.getHuristic()){
							newBoards.add(new GameBoard(test,h));
						}
					}
					test[i] = hold;
				}
				
				// Tells the user how many new boards with lower heuristic exist. 
				System.out.println("Current h: " + board.getHuristic()
					+ "\nCurrent State");
				
				// Prints the current state of the board. 
				board.printBoard();
				
				// If the newBoards Array List is empty then no better states exist. No solutions RESTART
				if(newBoards.isEmpty()){
					System.out.println("Neighbors found with lower h: 0 \n"
							+ "RESTART\n\n");
					restart++;
					board.newBoard(size);
					board.setHeuristic(check.findHeuristic(board.getQueens()));
					
				// If other better states exist, find the one with the lowest heuristic and make 
				// this the current board state. 
				}else{
					
					System.out.println("Neighbors found with lower h: " + newBoards.size() 
						+ "\nSetting new current state\n\n");
					int min = newBoards.get(0).getHuristic();
					GameBoard nextBoard = newBoards.get(0);
					for(GameBoard next: newBoards){
						if(min > next.getHuristic()){
							min = next.getHuristic();
							nextBoard = next;
						}
					}
					board = new GameBoard(nextBoard.getQueens(),nextBoard.getHuristic());
					changes++; 
					
				}
			}
			
		}while(board.getHuristic() != 0);
		
		
		// Prints the the user the solution information. 
		System.out.println("Current State");
		board.printBoard();
		System.out.println("Solution Found! \n"
				+ "State Changes: " + changes + "\n"
				+ "Restarts: " + restart);
		
		
		
		

	}

}
