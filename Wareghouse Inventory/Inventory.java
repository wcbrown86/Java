/**
 * 
 * @author - William Chad Brown
 * 
 * Description:	This is the super or parent class for all the warehouse classes.
 * 				in this class all of the reused methods are defined as well as
 * 				all the global variables that each location will share. Each location 
 * 				will exend this class to limit reprogramming the same methods and class
 * 				veriables. As well as help with updating the program in the future. 
 *
 */

public abstract class Inventory {
	
	//Defines the set parts numbers for each warehouse
	public int item102, item215, item410, item525, item711;
	
	/**
	 * 
	 * Consturctor method that is called when each of the 
	 * warehouses are created. When this is done each shared inventory 
	 * item is set to the number that is passed. 
	 * 
	 * @param i102 - An integer that represents the inventory level of this item.
	 * 
	 * @param i215 - An integer that represents the inventory level of this item.
	 * 
	 * @param i410 - An integer that represents the inventory level of this item.
	 * 
	 * @param i525 - An integer that represents the inventory level of this item.
	 * 
	 * @param i711 - An integer that represents the inventory level of this item.
	 * 
	 */
	public Inventory(int i102, int i215, int i410, int i525, int i711) {
		item102 = i102;
		item215 = i215;
		item410 = i410;
		item525 = i525;
		item711 = i711;
	}
	
	/**
	 * 
	 * This method takes two integers one for the item number and the one
	 * for the amount to take out of the current inventory. 
	 * 
	 * @param inventory - An integer that represents the item number 
	 * 					  that needs to be adjusted.
	 * 
	 * @param amount - An integer that represents the change in the 
	 * 				   inventory amount. 
	 * 
	 */
	public void sellItem(int inventory, int amount){
		
		switch(inventory){
		case 102:
			item102 -= amount;
			break;
		case 215:
			item215 -= amount;
			break;
		case 410:
			item410 -= amount;
			break;
		case 525:
			item525 -= amount;
			break;
		case 711:
			item711 -= amount;
			break;
		default:
			break;
		}
		
	}
	
	/**
	 * 
	 * This method takes two integers one for the item number and the one
	 * for the amount to add to the current inventory. 
	 * 
	 * @param inventory - An integer that represents the item number 
	 * 					  that needs to be adjusted.
	 * 
	 * @param amount - An integer that represents the change in the 
	 * 				   inventory amount. 
	 * 
	 */ 
	public void purchaseItem(int inventory, int amount){
		
		switch(inventory){
		case 102:
			item102 += amount;
			break;
		case 215:
			item215 += amount;
			break;
		case 410:
			item410 += amount;
			break;
		case 525:
			item525 += amount;
			break;
		case 711:
			item711 += amount;
			break;
		default:
			break;
		}
		
	}
	
	/**
	 * 
	 * This method take in item number and returns the number of that 
	 * item on hand at that location. 
	 * 
	 * @param inventory - An integer that represents an item number.
	 * 
	 * @return - An integer that represents the amount of that item on hand
	 * 
	 */
	public int getItem(int inventory){
		
		switch(inventory){
		case 102:
			return item102;
		case 215:
			return item215;
		case 410:
			return item410;
		case 525:
			return item525;
		case 711:
			return item711;
		default:
			return 0;
		}
		
	}
	
	/**
	 * 
	 * This method formats the inventory level of each item 
	 * in the warehouse then prints the item number and the 
	 * inventory level of that item. 
	 * 
	 */
	public void printInventory(){
		
		System.out.println("   Items: 102: " + item102);
		System.out.println("   Items: 215: " + item215);
		System.out.println("   Items: 410: " + item410);
		System.out.println("   Items: 525: " + item525);
		System.out.println("   Items: 711: " + item711);
	}
}
