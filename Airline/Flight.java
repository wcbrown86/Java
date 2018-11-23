/**
 * @author William Chad Brown
 * 
 * Description:	This is the main class for the Airplane program. It controls the flow of the 
 * 				menu and the users progression in the program. This program is design to find the 
 * 				first available seat or seats that fix the users class preference and seat location
 * 				in the row. The plane is filled from the back to the front in the selected seating
 * 				class. 
 * 
 */

// Scanner import is used to pull user input from the console. 
import java.util.Scanner;

public class Flight {

	// Global variables that store the information of the user input.
	// And the state of the current plane.
	static Scanner userInput = new Scanner(System.in);
	static Airplane plane;
	
	// Constants that store the size of the plane and are used as
	// the sizes for the 2d array of the plane. 
	public static final int ROW = 20;
	public static final int SEAT = 8;
	
	/**
	 * Constructor for the Flight class, when called a new Airplane 
	 * object is created. no parameters are required. 
	 */
	public Flight() {

		plane = new Airplane();
		
	}

	/**
	 * The main function for this program and controls the creation of the plane,
	 * manages the progress of the program based off user input. The user input is 
	 * setup to be either the number beside the option or the full option typed out.  
	 * 
	 * @param args - Needed for the the main function deceleration, but
	 * 				 is not used in this case. 
	 */
	public static void main(String[] args) {
		
		// Calls the constructor to created the Airplane object and the Flight object.
		Flight flight = new Flight();
		
		// String that is used to store the user input from the console.
		String command ="";
		
		// Main while loop that keeps the program running until the user enter the quit command
		while(!command.equalsIgnoreCase("quit") && !command.equals("3")){
			
			// Function that is used to print the main menu.
			printMenu();
			
			// Grabs the users input 
			command = userInput.nextLine();
			command = command.toLowerCase();
			
			// Case statements that determines the correct information to show to the user
			// based off the user input. 
			switch(command){
			
			// The add passenger option will show if the user enters 1 or types add passenger.
			case "add passenger":
			case "1":
				
				// Boolean that if false will keep the next while loop going until the user 
				// enters a valid command. 
				boolean correctClass = false;
				
				// Secondary while loop that will continue until the user enters a valid option. 
				while(!correctClass) {
					
					// Provides the user with the option to select the seating class that they would like 
					// to find a seat in. If the user does not enter at valid comment the program will notify 
					// the user then ask the user to select the seat class again. 
					System.out.println("PLease enter the class: \n1. First \n2.Economy");
					
					// Grabs the user input, the user can enter the number or type the option out. 
					String seatClass = userInput.nextLine().toLowerCase();
					
					// Conditional statement that will call the correct function for the next set of 
					// menu options for finding open seats. 
					if(seatClass.equals("economy") || seatClass.equals("2")){	
						correctClass = true;
						findSeatsEconomy();
						
					}else if(seatClass.equals("first") || seatClass.equals("1")){
						
						correctClass = true;
						findSeatsFirst();
					} else
						System.out.println("Please enter a vaild command.");
				}
				
				break;
			
			// Show seating option that calls the function that will print the plan seating to the screen.
			case "show seating":
			case "2":
				flight.printSeating();
				break; 
			
			// Quit option that will show the user the exit message. 
			case "quit":
			case "3":
				System.out.println("Good Bye!");
				break;
			
			// If no valid option is enter the user will be notified and the loop will continue.
			default:
				System.out.println("Please enter a vaild command.");
				break;
			}	
		}
	}
	
	/**
	 * Print menu function that will show the user the main menu. 
	 * This menu gives the user the options to add a passenger, show 
	 * the current state of the seating, or to quit the program. 
	 */
	private static void printMenu() {
		System.out.println("Please enter one of the following commands");
		System.out.println("1. Add Passenger. ");
		System.out.println("2. Show seating. ");
		System.out.println("3. Quit.");
	}
	
	/**
	 * Find seats in economy, this function will show the user a prompt to 
	 * enter the amount of passenger traveling together. And if the amount of
	 * passengers does not fill a whole side of the row, then the user is prompted
	 * to select a seat location like window or aisle. 
	 */
	private static void findSeatsEconomy() {
		
		// Boolean variable that will keep the loop running until
		// the user enters correct input. 
		boolean correctNumPassengers = false;
		
		
		// while loop that will prompt the user to to enter the number of passenger
		// this loop will continue until the user enters the correct input. 
		do {
			
			System.out.println("Please enter the number of passengers traveling together up to 3 passengers:");
			
			// passengers variable calls the parseInt function to check the user input.
			// if the user input is a Integer then that number is returned, if it is not 
			// then -1 is returned. 
			int passengers = parseInt(userInput.nextLine());
			
			// Conditional statement that will show the user the correct prompt based off the 
			// number of passengers traveling together. 
			if(passengers == 1) {
				
				// Boolean variables that stores if the user input is in the correct range
				// based off the prompts given. 
				correctNumPassengers = true;
				boolean correctType = false;
				
				
				// while loop that will continue until the user selects the correct seat location based off the 
				// prompt the users is shown. 
				do {
					
					System.out.println("PLease enter the seating preference: \n1. Aisle \n2. Middle \n3. Window.");
					
					// Grabs the user input the user can enter the number or type out the option. 
					String seating = userInput.nextLine().toLowerCase();
					
					// Conditional statement that will call the correct function with the seat 
					// selection and number of passengers traveling together. And sets the boolean
					// to true so the loop will stop. If the user does not enter the correct information 
					// the user will be notified and the loop will continue. 
					if(seating.equals("Aisle") || seating.equals("1")) {
						correctType = true;
						System.out.println(plane.findSeatsEconomy(passengers, 'A'));
					} else if(seating.equals("middle") || seating.equals("2")) {
						correctType = true;
						System.out.println(plane.findSeatsEconomy(passengers, 'M'));
					} else if(seating.equals("window") || seating.equals("3")) {
						correctType = true;
						System.out.println(plane.findSeatsEconomy(passengers, 'W'));
					} else
						System.out.println("Incorrect selection.");
					
				}while(!correctType);
				
			// If the user enters two passengers traveling together then the user is only
			// given the option of aisle or window, since no matter what the user will be 
			// filling the middle seat. 
			} else if(passengers == 2){
				
				// Boolean variables that stores if the user input is in the correct range
				// based off the prompts given. 
				correctNumPassengers = true;
				boolean correctType = false;
				
				System.out.println("PLease enter the seating preference: \n1. Aisle \n2. Window.");
				
				// while loop that will continue until the user selects the correct seat location based off the 
				// prompt the users is shown. 
				do {
					
					String seating = userInput.nextLine();
					
					// Conditional statement that will call the correct function with the seat 
					// selection and number of passengers traveling together. And sets the boolean
					// to true so the loop will stop. If the user does not enter the correct information 
					// the user will be notified and the loop will continue. 
					if(seating.equals("Aisle") || seating.equals("1")) {
						correctType = true;
						System.out.println(plane.findSeatsEconomy(passengers, 'A'));
					} else if(seating.equals("window") || seating.equals("2")) {
						correctType = true;
						System.out.println(plane.findSeatsEconomy(passengers, 'W'));
					} else
						System.out.println("Incorrect selection.");
					
				}while(!correctType);
				
			// if the user selects three passengers traveling together then the user
			// is not given the option to choose a seat type due to taking up the whole
			// side of the row. 
			}else if(passengers == 3) {
			
				correctNumPassengers = true;
				System.out.println(plane.findSeatsEconomy(passengers, 'A'));
			
			// Incorrect information entered. 
			}else
				System.out.println("Incorrect selection.");
				
		}while(!correctNumPassengers);
	}
	
	/**
	 * Find seats in first, this function will show the user a prompt to 
	 * enter the amount of passenger traveling together. And if the amount of
	 * passengers does not fill a whole side of the row, then the user is prompted
	 * to select a seat location like window or aisle. 
	 */
	private static void findSeatsFirst() {
		
		// Boolean variable that will keep the loop running until
		// the user enters correct input.
		boolean correctNumPassengers = false;
		
		// while loop that will prompt the user to to enter the number of passenger
		// this loop will continue until the user enters the correct input.
		do {
			
			System.out.println("Please enter the number of passengers traveling together up to 2 passengers:");
			
			// passengers variable calls the parseInt function to check the user input.
			// if the user input is a Integer then that number is returned, if it is not 
			// then -1 is returned.
			int passengers = parseInt(userInput.nextLine());
			
			// Conditional statement that will show the user the correct prompt based off the 
			// number of passengers traveling together. 
			if(passengers == 1) {
				
				// Boolean variables that stores if the user input is in the correct range
				// based off the prompts given.
				correctNumPassengers = true;
				boolean correctType = false;
				
				// while loop that will continue until the user selects the correct seat location based off the 
				// prompt the users is shown.
				do {
					
					System.out.println("PLease enter the seating preference: \n1. Aisle \n2. Window.");
					
					// Grabs the user input the user can enter the number or type out the option.
					String seating = userInput.nextLine().trim();
					
					// Conditional statement that will call the correct function with the seat 
					// selection and number of passengers traveling together. And sets the boolean
					// to true so the loop will stop. If the user does not enter the correct information 
					// the user will be notified and the loop will continue.
					if(seating.toUpperCase().equals("WINDOW") || seating.equals("2")) {
						
						correctType = true;
						System.out.println(plane.findSeatsFirst(passengers, 'W'));
						
					}else if(seating.toUpperCase().equals("AISLE") || seating.equals("1")) {
						correctType = true;
						System.out.println(plane.findSeatsFirst(passengers, 'A'));
					}else
						System.out.println("Incorrect selection.");
				}while(!correctType);
			
			// if the user selects two passengers traveling together then the user
			// is not given the option to choose a seat type due to taking up the whole
			// side of the row. 
			}else if(passengers == 2) {
				correctNumPassengers = true;
				System.out.println(plane.findSeatsFirst(passengers, 'A'));
			
			// Incorrect information entered.
			}else
				System.out.println("Incorrect selection.");
			
		}while(!correctNumPassengers);
	}
	
	
	/**
	 * This function is used to show the current state of the planes seating.
	 * This function can be called by the user from the main screen. 
	 * When the information is printed to the screen it is formatted in a way 
	 * that it will show the plane with row numbers along the top and first class 
	 * on the right of the screen. 
	 */
	private void printSeating() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < SEAT; i++){
			for(int j = 0; j < ROW; j++){
				System.out.print(plane.getSeat(i,j));
			}
			System.out.println("");
		}
		
	}
	
	
	/**
	 * This function is used to turn a string into an integer if possible.
	 * 
	 * @param i - a string that could represent a integer. 
	 * @return - if the string can be parsed to an integer it returns the 
	 * 			 integer value. If it can not the function will return a -1.
	 */
	private static int parseInt(String i) {
		int num = 0;
		
		try {
			num = Integer.parseInt(i);
			return num;
			
		} catch(Exception e) {
			return -1;
		}
	}

}
