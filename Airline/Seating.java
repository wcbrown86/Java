/**
 * 
 * @author William Chad Brown
 *
 * Description:	This class is used to store information about each seat in the plane. It will store,
 * 				the seat location in the array, the location of the seat in the row (exp. A, B, C), and the
 * 				type of the seat (Window, Middle, Aisle).
 */
public class Seating {
	
	// Constant for the number of rows in the plane. 
	public static final int ROW = 20;
	
	// Global variables used to store useful information about the seat. 
	int seatNumber;
	public boolean isFull;
	String seating;
	private char position;
	
	/**
	 * Constructor method that takes the location in the array and creates
	 * the correct seat information. This will also account for the rows and 
	 * any empty information when no seat is located in that area of the plane. 
	 * 
	 * @param row - represents the row value of the array
	 * @param seat - represents the column value of the array. 
	 */
	public Seating(int row, int seat) {
		
		// setting the value of isFull at creation is false. 
		isFull = false;
		
		// If the seat is 0 then the seating information is set, position is set to none, and 
		// isFull is set to true. 
		if(seat == 0){
			// Formats the string to help with printing the information to the screen.
			seating = String.format("%-3s", (ROW - row));
			position = 'N';
			isFull = true;

		}
		// Sets the information for seats located in economy class. 
		// isFull is seat above, and then depending on the seat location in the array
		// the seat type is set. 
		else if(row < 15){
			
			switch(seat){
				case 1:
					// Formats the string to help with printing the information to the screen.
					seating = String.format("%-3s", "A");
					position = 'W';
					break;
				case 2:
					// Formats the string to help with printing the information to the screen.
					seating = String.format("%-3s", "B");
					position = 'M';
					break;
				case 3:
					// Formats the string to help with printing the information to the screen.
					seating = String.format("%-3s", "C");
					position = 'A';
					break;
				case 5:
					// Formats the string to help with printing the information to the screen.
					seating = String.format("%-3s", "D");
					position = 'A';
					break;
				case 6:
					// Formats the string to help with printing the information to the screen.
					seating = String.format("%-3s", "E");
					position = 'M';
					break;
				case 7:
					// Formats the string to help with printing the information to the screen.
					seating = String.format("%-3s", "F");
					position = 'W';
					break;
				default:
					// Formats the string to help with printing the information to the screen.
					seating = String.format("%-3s", " ");
					position = 'N';
					isFull = true;
					break;
			}
		}
		// Sets the information for seats located in first class. 
		// isFull is seat above, and then depending on the seat location in the array
		// the seat type is set.
		else{
			switch(seat){
				case 2:
					// Formats the string to help with printing the information to the screen.
					seating = String.format("%-3s", "A");
					position = 'W';
					break;
				case 3:
					// Formats the string to help with printing the information to the screen.
					seating = String.format("%-3s", "B");
					position = 'A';
					break;
				case 5:
					// Formats the string to help with printing the information to the screen.
					seating = String.format("%-3s", "C");
					position = 'A';
					break;
				case 6:
					// Formats the string to help with printing the information to the screen.
					seating = String.format("%-3s", "D");
					position = 'W';
					break;
				default:
					// Formats the string to help with printing the information to the screen.
					seating = String.format("%-3s", " ");
					position = 'N';
					isFull = true;
					break;
			}
		}
	}

	
	/**
	 * Get method for the seat location in the row. 
	 * @return - a String with the seat location in the row. (ex. A, B, C, ...)
	 */
	public String getVisual() {
		return seating;
	}
	
	/**
	 * Setter method to change the status of if the seat is full. It also
	 * changes the seat location to an X for visual purpose to show when the 
	 * seating chart is printed. 
	 */
	public void setStatusFilled(){
		
		seating = "X  ";
		isFull = true;
	}
	
	
	/**
	 * Get method that returns the true false value of if the seat is full.
	 * 
	 * @return - if the seat has been assigned to another passenger then it
	 * 			 returns true. Otherwise it will return false. 
	 */
	public boolean getStatus(){
		
		return isFull;
	}

	/**
	 * Get method that returns the position of the seat. (ex. W, M, A)
	 * 
	 * @return - returns the value of the position. 
	 * 				W - Window
	 * 				M - Middle
	 * 				A - Aisle
	 */
	public char getPosition() {
		// TODO Auto-generated method stub
		return position;
	}

}
