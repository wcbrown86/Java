/*
 * A driver (main class) as well as a programmer-defined class must be used.
 * The main program (driver) should ask the user to enter the winning 6 digit number. 
 * Do this only once. Input from the keyboard, the ticket holder’s name and his/her six 
 * digit ticket number. Analyze the ticket to see if it is a winner using the rules for winning above. 
 * If the ticket is a winner, display a message indicating the prize winner and the holder’s name. 
 * Continue to process tickets until there are no more. 
 * 
 * When all tickets have been processed, display the total number of first prize winners, 
 * second prize winners, and third prize winners.
 * 
 * @author - William Chad Brown
 * ID: 800816688
 * Date: 01/25/2016
 * Section: ITCS-3112-091
 * 
 */

 // Import used to grab information from the user in the console from STDIN.
import java.util.Scanner;

public class Raffle {
	
	// An array that holds all the entered information from the user
	static Ticket[] ticketArray = new Ticket[100]; 

	// Input scanner that takes that input from the user
	static Scanner userInput = new Scanner(System.in);

	// An integer used to track the current item being added to the array
	static int index = 0;
	
	//The winning number must be set here. 
	static String winningNumber = "123456";
	
	/**
	 * Asks the user for the ticket information, continues this loop until the user is done
	 * after each ticket is entered the user will be told if the ticket is a winner. Once the
	 * user is done with checking tickets the user will be given a report showing all the winners.
	 * 
	 * @param args - Main system input argumaents. this is not used on. 
	 * 
	 */
	public static void main(String[] args) {
		
		// Charactor used to keep the program running until the user enters n at 
		// the do you have more tickets to check prompt. 
		char cont = 'Y';

		
		// Main outter loop used to check the program running until the user chooses to 
		// exit. 
		while (cont == 'Y'){
			
			// String variables used to stroe the user input, that is later placed into a 
			// ticket object and added to the array. 
			String ticketNumber = "";
			String holdersName = "";

			// loop that runs until the user enters a correct ticket number. 
			do{
				 
				System.out.println("PLease enter the ticket number!");
				ticketNumber = userInput.nextLine();
			
			} while(!ticketNumber.matches("\\d{6}"));
			
			// loop that runs until the user enters a valid name. 
			// meaning no numbers or special charactors in the name. 
			do{

				System.out.println("Please enter the ticket holders name!");
				holdersName = userInput.nextLine();

			} while(!holdersName.matches("[a-zA-Z]+"));
			
			// Checks to see if the array can hold more items. if not then the array 
			// size is increased. 
			if(index < ticketArray.length)
				ticketArray[index] = new Ticket(ticketNumber, holdersName);
			else{
				increaseSize();
				ticketArray[index] = new Ticket(ticketNumber, holdersName);
			}
			
			// Checks to see if the ticket entered is a winner, and the user is
			// updated of the tickets status. 
			checkWinner(ticketArray[index]);
			System.out.println(ticketArray[index].getWinner());

			// Increments the index value.
			index++;
			
			// Askes the user if they would like to continue. 
			System.out.println("Do you have more teckets to check? Y/N");
			cont = userInput.nextLine().toUpperCase().charAt(0);
		}
		
		// Prints the ticket report the the user as the program ends. 
		printArray();

	}
	
	/**
	 * 
	 * Prints the Ticket numbers and if a prize is due to the console.
	 * By listing the Ticket holders name, ticket number, and prize level. 
	 * 
	 */
	private static void printArray() {
		
		for(int i = 0; i < ticketArray.length && ticketArray[i] != null; i++){
			System.out.println("Name: " + ticketArray[i].getName() + ", Ticket Number: "
					+ ticketArray[i].getNumber() + ", Prize: " + ticketArray[i].getWinner());
		}
		
	}

	/** 
	 * 
	 * First Prize – The six digit number on the ticket exactly matches the winning number.
	 * Example: If the number on the ticket is 123456, it is a winner if the winning number is 123456.
	 * 
	 * Second Prize – The reverse of the 6 digit number on the ticket exactly matches the winning number.
	 * Example: If the number on the ticket is 654321, it is a winner if the winning number is 123456. 
	 * 
	 * @param check - a Ticket object that needs to be checked if it is a winning ticket. 
	 * 
	 */
	private static void checkWinner(Ticket check) {
		
		String number = check.getNumber();
		if(number.equals(winningNumber))
			check.setWinner("First Prize");
		else if(number.equals(stringReverse(winningNumber)))
			check.setWinner("Second Prize");
		else if(thirdPrize(check))
			check.setWinner("Third Prize");
		
	}

	/**
	 * 
	 * Third Prize – Any 3 sequential digits of the 6 digit number on the ticket exactly matches 3 sequential
	 * digits in the same position of the winning ticket.
	 * 
	 * Example: If the number on the ticket is 123456, it is a winner if the winning number has 123 in
	 * positions 1 – 3, 234 in positions 2 – 4, 345 in positions 3 – 5, or 456 in positions 4 – 6.
	 * 
	 * @param check - A Ticket oject to be checked if it qualifies for the third prize place, this 
	 * 				  prize will can be multiple tickets. 
	 * 
	 */
	private static boolean thirdPrize(Ticket check) {
		
		// Character arrays used to hold the information 
		// about the winning number and the number to be checked. 
		char[] temp = check.getNumber().toCharArray();
		char[] winner = winningNumber.toCharArray();

		// Nested loops that look a three number in a row and see if they
		// match in the two numbers that are comapaired. 
		for(int i = 1; i <= 4; i++){
			boolean isWinner = false; 
			for(int j = i; j < (i+3) && j < temp.length + 1; j++){
				if(winner[j-1] != temp[j-1]){
					isWinner = false;
					break;
				}
				else
					isWinner = true;
				
				
			}
			if(isWinner)
				return true;
		}
		return false;
	}
	
	/**
	 * 
	 * This fucntion takes a string and reveses the order of that string. 
	 * 
	 * @param winning - a String that needs to be reversed.
	 * 
	 * @return - a String that is a reversed version of the string passed
	 * 			 to the function. 
	 */
	private static String stringReverse(String winning) {
		char[] tempArray = winning.toCharArray();
		String temp = ""; 
		
		for(int i = tempArray.length - 1; i >= 0; i--){
			temp += "" + tempArray[i];
		}
		return temp;
	}
	
	/**
	 * 
	 * Takes the current global array that is used to store the 
	 * tickets that where checked, and creates an array of double 
	 * the size of the current array and transfers the information from 
	 * the old array to the new array. 
	 * 
	 */
	private static void increaseSize() {
		
		Ticket[] temp = new Ticket[ticketArray.length * 2];
		
		for(int i = 0; i < ticketArray.length; i++){
			temp[i] = ticketArray[i];
		}
		
		ticketArray = temp;
		
	}

}
