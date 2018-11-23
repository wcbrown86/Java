/**
 * 
 * @author William Chad Brown
 * 
 * Description:	The Customer Class holds the information about the 
 * 				next customer in line, as well as the service time for 
 * 				the customer. The service time is decremented each loop,
 * 				until it is equal to 0. Then at that time the customer is
 * 				removed from the queue.
 *
 */

public class Customer {
	
	//Global variables that hold the next customer in the queue and the service time
	// which is currently set at 5. 
	Customer next;
	int serviceTime = 5;

	/**
	 * 
	 * The set next function, sets the next variable to a customer object
	 * that points the to customer that is next in line in the queue. 
	 * 
	 * @param c - Customer object that represents the next customer in line. 
	 * 
	 */
	public void setNext(Customer c) {
		next = c;
	}

	/**
	 * 
	 * A get function that returns the value of next, a customer object 
	 * that represents the next customer in line. 
	 * 
	 * @return - a Customer object that represents the next customer in line
	 * 
	 */
	public Customer getNext() {
		// TODO Auto-generated method stub
		return next;
	}

	/**
	 * 
	 * A get function for the service time of the customer, this returns an 
	 * integer that represents the remaining service time for this customer.
	 * 
	 * @return - a integer that represents the remaining service time for the 
	 * 			 customer. 
	 * 
	 */
	public int getServiceTime() {
		// TODO Auto-generated method stub
		return serviceTime;
	}

	/**
	 * 
	 * A function that will reduce the customer service time by one. This is 
	 * used to simulate one minute passing. 
	 * 
	 */
	public void decServiceTime() {
		// TODO Auto-generated method stub
		serviceTime--;
	}

}
