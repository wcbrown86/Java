/**
 * 
 * @author - William Chad Brown
 * 
 * Description:	This Class takes as an input a string that is a text file of numbers with each number on
 * 				a separate file. This file is read in and put into an array, then sorted 
 * 				using the merge sort method. A runtime is shown in minutes, second, miliseconds. 
 * 				Then the sorted array is placed back into a text file with the same format. This class
 *              uses the Bubble Sort algorithm to sort the file. 
 * 
 */

// Imports used for reading the file and creating a file.
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Import used to track the time it takes for the program to run. 
import java.util.concurrent.TimeUnit;


public class BubbleSort {

	int[] array;

	/**
	 * 
	 * Constructor method that tells the program what file text
	 * file to sort, and then place the sorted information into a new
	 * file.
	 * 
	 */
	public BubbleSort(String fileName){
		
		try{
			//The file to be read
			Scanner file = new Scanner(new File(fileName));
			Scanner fileSize = new Scanner(new File(fileName));
	
			//Reads the number of lines in the file
			int lines = 0;
			while (fileSize.hasNextLine()){ 
				lines++;
				fileSize.nextLine();
			}
			//Makes the Array that is used to store the random numbers.
			array = new int[lines];
			
			//Places the numbers in the text file in an array
			for(int i = 0; i < array.length; i++){

				array[i] = file.nextInt();
			}

			// Closes the file scanner object to maintain a lower memory useage.
			file.close();
			fileSize.close();


			//Saves the start time before running the sort
			long start = System.currentTimeMillis();
			System.out.println("Runing Bubble Sort");
			
			//Runs the sort
			bubbleSort();

			//Saves the end time 
			long end = System.currentTimeMillis();

			//Takes the start time and end time prints out in the minutes, seconds, miliseconds format
			System.out.println(TimeUnit.MILLISECONDS.toMinutes(end - start) + " Minutes");
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(end - start) + " Seconds");
			System.out.println(TimeUnit.MILLISECONDS.toMillis(end - start) + " Milliseconds\n");
			
			//Writes the array back to a file.
			BufferedWriter output = null;
			output = new BufferedWriter(new FileWriter("BubbleSort"+ array.length + ".txt"));

			// Writes the array to the file line by line.
			for(int i = 0; i < array.length; i ++){
				output.write(Integer.toString(array[i]));
				output.newLine();
			}
			

			// Clears the output stream and closes the file. 
			output.flush();
			output.close();
		} catch (Exception e){
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	/**
	 * 
	 * Sorts the array using the bubble algorithm 
	 * 
	 */
	public void bubbleSort(){
		int temp;

		for(int i = 0; i <array.length - 1; i++){
			for(int j = 1; j < array.length - i; j++){
				if(array[j-1] > array[j]){
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public int[] getArray(){

		return array;

	}
}
