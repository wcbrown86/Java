/**
 * 
 * @author - William Chad Brown
 * 
 * Description:	The Store class runs the program. This program is set up to simulate 
 * 			a line in a store. Where a new customer is added to the line randomly,
 * 			and the line is managed in a first in first out manner. Each customer has
 * 			a set wait time of 5 and once this time has elapsed the next customer in 
 * 			line is removed. The program loops 60 times currently, this is meant to 
 * 			simulate an hour of the store being open.  	
 *   
 */

import java.util.Random;

public class Store{

	/**
	 * 
	 * The Main driver for the program, it contains the loop that keeps the program 
	 * running for a count of 60. This length can be changed by adjusting the time
	 * variable. 
	 * 
	 * @param args - System arguments is not used in this program. 
	 * 
	 */
	public static void main(String[] args){
		
		// Local variables, Object q is used to hold the customers that are waiting in line
		Queue q = new Queue();
		
		// rand is used to generate a random number, this is used to determine when a new customer
		// will be added to the queue
		Random rand = new Random();
		
		// Time is used to set how long the program "runs".
		int time = 60;

		// Loop that will continue until time equals 0
		do{

			// Logic that will randomly add a new customer to the line. A random number is generated between 
			// 1 and 5, if that number is one. Add a new customer. And inform the user. 
			if(rand.nextInt(4)+1 == 1){
				q.addCustomer(new Customer());
				System.out.println("New Customer Added, there are currently " + q.count + " customers in line");
			}
			
			// If the queue is not empty. Check to see if the customer service time is complete then remove the
			// customer from the front of the line and move to the next customer. If a customer is removed
			// inform the user. 
			if(q.first != null){
				if(q.first.getServiceTime() < 0){
					q.removeCustomer();
					System.out.println("Customer served there are currently " + q.count + " customers in line");
				}else
					q.first.decServiceTime(); 
			}      
			
			// Visual output of each loop.
			System.out.println("----------------");
			time--;
		}while(time >= 0);  
	}
}