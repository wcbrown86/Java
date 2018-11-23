/**
 * 
 * @author - William Chad Brown
 * 
 * Description:	This class repesents a single warehouse location. This class 
 * 				extends the Inventory class. This class also overrides the printInventory 
 * 				method. Any specialzed inventory item that would be isolated to this warehouse. 
 * 				would be added to this class. 
 * 
 */
public class Ely extends Inventory{
	
	/**
	 * 
	 * This constructor take all the starting inventory levels and 
	 * sends that information to the super class constructory. Any 
	 * items that are localized to this warehouse will be set up in this
	 * constructor.
	 * 
	 * @param i102 - An integer that represents the starting inventory level 
	 * 				 of this item. 
	 * @param i215 - An integer that represents the starting inventory level 
	 * 				 of this item.
	 * @param 1410 - An integer that represents the starting inventory level 
	 * 				 of this item.
	 * @param i525 - An integer that represents the starting inventory level 
	 * 				 of this item.
	 * @param i711 - An integer that represents the starting inventory level 
	 * 				 of this item.
	 * 
	 */
	public Ely(int i102, int i215, int i410, int i525, int i711){
		
		super(i102, i215, i410, i525, i711);
	}

	/**
	 * 
	 * The printInventory method uses the super class version to print the 
	 * item inventory. But overrides that method to add the location information. 
	 * 
	 */
	public void printInventory() {
		
		System.out.println("Warehouse: Ely");
		super.printInventory();
		
	}
}