/**
 * 
 * @author - William Chad Brown
 * 
 * Description:	The Queue class is a linked list that implements a first in 
 * 				first out queue. This class is set up to only support a Customer
 * 				class object. 
 *
 */

public class Queue{
    
	// Global variables the store the head and tail of the list. 
    public Customer first; 
    public Customer last; 
    
    // Count variable that keeps track of how many items are in the list. 
    public int count;
    
    
    /**
     * 
     * Constructor that sets up an empty list. It sets
     * the first and last variable to null and count to 0.
     * 
     */
    public Queue(){
        first = null;
        last = null;
        count = 0;
    }
    
    /**
     * 
     * Add Customer function will add an item to the linked list.
     * If the list in empty the first variable is set to the added 
     * Customer object, and since this is a FIFO queue all new items 
     * are added to the end of the list, so the last variable is set
     * to the passed Customer object. 
     * 
     * @param c - A Customer object that needs to be added to the Queue.
     * 
     */
    public void addCustomer(Customer c){
        if(isEmpty())
            first = c;
        else
            last.setNext(c);
            
        last = c;
        count++;
    }
    
    /**
     * 
     * Remove customer function, takes the first customer 
     * Variable and point that to the second customer in line.
     * The object is not deleted, but is removed from any memory pointers 
     * and will be cleaned up with automatic garbage collection. 
     * 
     */
    public void removeCustomer(){
    
      if(!isEmpty()){
         first = first.getNext();
         count--;
      }      
    }

    /**
     * 
     * Checks to see if the list is empty. If the list is empty the function
     * returns True otherwise False
     * 
     * @return - returns a boolean true if the list is empty, and false otherwise.
     * 
     */
    public boolean isEmpty(){
        return first == null;
    } 
}