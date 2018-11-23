/*
 * 
 * The Ticket class is used to hold information about a raffle ticket that needs
 * to be validated if the tick is a winner or not. This class holds the ticket number
 * and the name of the ticket holder. 
 * 
 * @author -  William Chad Brown
 * Student ID: 800816688
 * Date: 01/25/2016
 * Section: ITCS-3112-091
 * 
 */
public class Ticket {
	
	String number;
	String name;
	String winner;
	
	/**
	 * 
	 * Constructor method that takes the name and the number of the ticket
	 * and stores that informantion. The winner string is set to "No Prize Due."
	 * 
	 * @param ticketNumber - a String that represents a 6 digit number of the 
	 * 						 ticket. The validity of the number enterd is checked
	 * 						 before it is passed to the constructor. 
	 * 
	 * @param holderNmae - a String that represents the name of the owner of the 
	 * 					   ticket.
	 * 
	 */
	public Ticket(String ticketNumber, String holderName){
		
		number = ticketNumber;
		name = holderName;
		winner = "No Prize Due";
	}
	
	/**
	 * 
	 * Get method for the name information of the ticket. 
	 * 
	 * @return - a string representing the name of the person 
	 * 			 that holds the ticket. 
	 * 
	 */
	public String getName(){
		return name; 
	}
	
	/**
	 * 
	 * A get method that returns the number of the ticket. 
	 * 
	 * @return - A string that represents the number of the 
	 * 			 ticket. 
	 * 
	 */
	public String getNumber(){
		return number;
	}
	
	/**
	 * 
	 * A get method for the winner message. 
	 * 
	 * @return - A string that states the prized that the 
	 * 			 user is due, if not prize is due the string
	 * 			 will state "No Prize Due."
	 * 
	 */
	public String getWinner(){
		return winner;
	}
	
	/**
	 * 
	 * A setter method for the winner variable. This stores 
	 * a string that represents the prize that is due to the 
	 * user. 
	 * 
	 * @param setWinner - A string that holds the prize
	 * 					  that is due to the ticket winner.
	 * 					  If no prize is due the message will
	 * 					  state "No Prize Due."
	 * 
	 */
	public void setWinner(String setWinner){
		winner = setWinner;
	}
}
