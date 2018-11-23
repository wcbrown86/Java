/**
 * 
 * @author - William Chad Brown	
 * 
 * Description:	This class is the main driver forthe program. In this class
 * 				the progrma will read from two files. One file will contain the 
 * 				starting inventory for all the warehouses. All the starting information
 * 				is then placed into a new ojbecto for each of the locations useing the class
 * 				that is made for each of these locations. After another file is read from that
 * 				contains the transactions to be preformed. When a purchase is to be made the 
 * 				program looks for the location with the lowest inventory for this product, and 
 * 				placeing the product in this location. When a sale is made the warehouse with 
 * 				the larges inventory is where the product is pulled from. 
 * 
 */

// Imports used to Open the file and read from the information on the file. 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Data structure used to store the warehouses. 
import java.util.ArrayList;



public class InventoryManagment {
	
	//Global array list that stores the warehouses for easy access. 
	static ArrayList<Inventory> warehouses = new ArrayList<Inventory>();

	/**
	 * 
	 * The Main function for the program. This function takes the hardcoded file names 
	 * and then calls the functions to read the inventory from its file, then calls
	 * the read transactions function to read the list of transactions from its file.
	 * 
	 */
	public static void main(String[] args) {
		
		//Variables that store the file names in case they need to be changed easy to find. 
		String fileNameInv = "Inventory.txt";
		readInventory(fileNameInv);

		String fileNameTrans = "Transactions.txt";
		readTransactons(fileNameTrans);

	}
	
	/**
	 * 
	 * This function takes the filename for the file that will contain all
	 * the starting inventories for all the warehouses. Then it takes that 
	 * information and stores a new object of each location and places those
	 * objects into an arraylist to easy access. 
	 * 
	 * @param fileNameInv - Is a string the lists the file name that holds
	 * 					  	the starting inventory for all of the warehouses. 
	 * 
	 */
	private static void readInventory(String fileNameInv){

		try{
			//Opens the beginning inventory file then takes each line a splits the information at the 
			//comma and white space
			Scanner fileReader = new Scanner(new File(fileNameInv));
			String[] aStart = fileReader.nextLine().split(",\\s");
			String[] bStart = fileReader.nextLine().split(",\\s");
			String[] cStart = fileReader.nextLine().split(",\\s");
			String[] dStart = fileReader.nextLine().split(",\\s");
			String[] eStart = fileReader.nextLine().split(",\\s");
			String[] fStart = fileReader.nextLine().split(",\\s");
			
			//Adds each warehouse to the array list with the information pulled from the file
			warehouses.add(new Atlanta(
				Integer.parseInt(aStart[0]),
				Integer.parseInt(aStart[1]),
				Integer.parseInt(aStart[2]),
				Integer.parseInt(aStart[3]),
				Integer.parseInt(aStart[4])));
			
			warehouses.add(new Baltimore(
				Integer.parseInt(bStart[0]),
				Integer.parseInt(bStart[1]),
				Integer.parseInt(bStart[2]),
				Integer.parseInt(bStart[3]),
				Integer.parseInt(bStart[4])));
			
			warehouses.add(new Chicago(
				Integer.parseInt(cStart[0]),
				Integer.parseInt(cStart[1]),
				Integer.parseInt(cStart[2]),
				Integer.parseInt(cStart[3]),
				Integer.parseInt(cStart[4])));
			
			warehouses.add(new Denver(
				Integer.parseInt(dStart[0]),
				Integer.parseInt(dStart[1]),
				Integer.parseInt(dStart[2]),
				Integer.parseInt(dStart[3]),
				Integer.parseInt(dStart[4])));
			
			warehouses.add(new Ely(
				Integer.parseInt(eStart[0]),
				Integer.parseInt(eStart[1]),
				Integer.parseInt(eStart[2]),
				Integer.parseInt(eStart[3]),
				Integer.parseInt(eStart[4])));
			
			warehouses.add(new Fargo(
				Integer.parseInt(fStart[0]),
				Integer.parseInt(fStart[1]),
				Integer.parseInt(fStart[2]),
				Integer.parseInt(fStart[3]),
				Integer.parseInt(fStart[4])));

			System.out.println("Starting Warehouse Inventory.");

			//Prints the beginning inventory
			for(Inventory inv: warehouses){
				inv.printInventory();
			}
			
			//adds white space for formating 
			System.out.println("\n\n");

			//closes first file. 
			fileReader.close();

		// Exception handling.
		} catch(FileNotFoundException e){
			System.out.println(e.toString() + " Please check that your files are in the correct directory.");
		} catch(NumberFormatException e){
			System.out.println(e.toString() + " Please check that your files are properly formatted.");
		}
	}

	/**
	 * 
	 * This function takes a file that contains all the transactions that need 
	 * to be preformed and will continue to run until all the transactions are complete. 
	 * The logic that is used is when buying more product the location with the smallest 
	 * inventory will be the location that gets the product, and when selling the location
	 * that has the largest inventory will be the location the product is pulled from. 
	 * 
	 * @param fileNameTrans - Is a string that contains the file name for the 
	 * 						  transactions that need to be preformed. This function
	 * 						  continues to run until no more transactions need to be 
	 * 						  preformed. 
	 * 
	 */
	private static void readTransactons(String fileNameTrans){

		try{
			//Opens the transaction file 
			Scanner fileReader = new Scanner(new File(fileNameTrans));


			
			//loops threw the transaction calls while the file has more transactions to be made. 
			while(fileReader.hasNextLine()){
				
				//String array to store the information of the transaction
				String[] transaction;
				int warehouse = 0;

				//splits the string pulled from the file at the commas and white space. 
				transaction = fileReader.nextLine().split(",\\s");
				
				//if it is a purchase the smallest inventory is found and passed to the sell method 
				if(transaction[0].equals("P")){
					warehouse = findSmallestInventory(Integer.parseInt(transaction[1]));
					warehouses.get(warehouse).purchaseItem(Integer.parseInt(transaction[1]), Integer.parseInt(transaction[2]));
				}
				//If a sell is made the largest inventory is found and the sell method is called. 
				else if(transaction[0].equals("S")){
					warehouse = findLargestInventory(Integer.parseInt(transaction[1]));
					warehouses.get(warehouse).sellItem(Integer.parseInt(transaction[1]),  Integer.parseInt(transaction[2]));
				}
			}

			System.out.println("Ending Warehouse Inventory.");
			
			//Prints the inventory at the end of the day
			for(Inventory inv: warehouses){
				inv.printInventory();
			}
			
			//Closes the file
			fileReader.close();
			

		//catches the exception and prints the error to the screen
		} catch(FileNotFoundException e){
			System.out.println(e.toString() + " Please check that your files are in the correct directory.");
		} catch(NumberFormatException e){
			System.out.println(e.toString() + " Please check that your files are properly formatted.");
		}
		
	}
	
	/**
	 * 
	 * In this function a part number is passed in the form of an integer, 
	 * then all the warehouse locations are searched for the location with 
	 * the smallest inventory. 
	 * 
	 * @param partNumber - Is an integer that repesents the part inventory
	 * 					   to search for. 
	 * 
	 * @return returns the index of the warehouse that contains the smallest
	 * 		   inventory for the part number that was passed to the function. 
	 * 
	 */
	private static int findSmallestInventory(int partNumber) {
		
		int min = warehouses.get(0).getItem(partNumber);
		int minElement = 0;
		
		for(int i = 0; i < warehouses.size(); i++){
			
			if(warehouses.get(i).getItem(partNumber) < min){
				min = warehouses.get(i).getItem(partNumber);
				minElement = i;
			}
				
		}
		return minElement;
	}

	/**
	 * 
	 * In this function a part number is passed in the form of an integer, 
	 * then all the warehouse locations are searched for the location with 
	 * the largest inventory. 
	 * 
	 * @param partNumber - Is an integer that repesents the part inventory
	 * 					   to search for. 
	 * 
	 * @return returns the index of the warehouse that contains the largest
	 * 		   inventory for the part number that was passed to the function.
	 * 
	 */
	private static int findLargestInventory(int partNumber) {
		
		int max = 0;
		int maxElement = 0;
		
		for(int i = 0; i < warehouses.size(); i++){
			
			if(warehouses.get(i).getItem(partNumber) > max){
				max = warehouses.get(i).getItem(partNumber);
				maxElement = i;
			}
				
		}
		return maxElement;
	}

}
