/**
 * 
 * @author - William Chad Brown
 * 
 * Description:	This program is used to generate a user entered number of 
 * 				random numbers, that are then placed in a text file that 
 * 				can be used in the sorting programs also listed in this 
 * 				directory. 
 * 
 */


 //Import used to generate the random numbers
import java.util.Random;

// Import used to write to the file. 
import java.util.Scanner;
import java.io.*;

public class RandomGenerator {
	
	// Global variable the stores the generated numbers.
	private static int[] arr;
	private String fileName;

	/**
	 * 
	 * Main function in this program grabs the input from the 
	 * user and then calls two other functions to create the random 
	 * numbers and then one to create the text file to be used in other
	 * programs. 
	 * 
	 */
	public RandomGenerator(){
		
		try{
			// Creates a new scanner to grab the user input from STDIN.
			Scanner in = new Scanner(System.in);

			// Asks the user for the number of random numbers to generate and stores that number 
			// in the number variable. 
			System.out.println("Please enter the number of random Integers you would like.");
			int number = in.nextInt();
			
			// Calls the random number function to create a array of random number the size of the file.
			arr = randomGenerator(number);
			makeTextFile(arr);
			System.out.println("The file RandomNumber" + arr.length + ".txt was created\n");

			// Closes the file to help with memory management.
			in.close();
		} catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	/**
	 * 
	 * This function is used to write the sorted array to a text 
	 * file so the user can see the sorted array.
	 * 
	 * @param arr2 - takes an array of integers that needs to be 
	 * 				 written to a file.
	 * 
	 */
	private void makeTextFile(int[] arr2) {
		
		try{
			// Creates a buffer to write the imformation to a file.
			BufferedWriter output = null;
			fileName = "RandomNumber"+ arr2.length + ".txt";
			output = new BufferedWriter(new FileWriter(fileName));

			// Writes the the file line by line.
			for(int i = 0; i < arr2.length; i ++){
				output.write(Integer.toString(arr2[i]));
				output.newLine();
			}
			
			// Clears the buffer and closes the file. 
			output.flush();
			output.close();
		} catch(Exception e){
			System.out.println(e.toString());
			System.exit(0);
		}
		
		
	}

	/**
	 * 
	 * This function takes in an integer that represens the number of 
	 * random numbers that need to be created. This then fills and array
	 * of the same size then returns this array. 
	 * 
	 * @param numb - a integer that represents the number of random
	 * 				 numbers that need to be created. 
	 * 
	 * @return - returns an array of size numb with a randomly created 
	 * 			 list of numbers. 
	 * 
	 */
	public static int[] randomGenerator(int numb){
	
		Random rand = new Random();
		arr = new int[numb];
		for(int i = 0; i < numb; i++){
			
			arr[i] = rand.nextInt(numb);
		}
		
		return arr;
	}

	/**
	 * 
	 * Get method for the file name global variable.
	 * 
	 * @return - Returns a String that contains the name of the
	 * 			 file to be sorted. 
	 * 
	 */
	public String getFileName(){

		return fileName;

	}

	public int[] getArray(){

		return arr;

	}
}
