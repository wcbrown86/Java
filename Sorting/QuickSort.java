/**
 * 
 * @author - William Chad Brown
 * 
 * Description:	This Class takes as an input a string that is a text file of numbers with each number on
 * 				a separate file. This file is read in and put into an array, then sorted 
 * 				using the merge sort method. A runtime is shown in minutes, second, miliseconds. 
 * 				Then the sorted array is placed back into a text file with the same format. This class
 *              uses the Quick Sort algorithm to sort the file. 
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

public class QuickSort {

    int[] array;

    public QuickSort(String fileName){

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
            System.out.println("Runing Quick Sort");
            
			//Runs the sort
            quickSort(array, 0, array.length - 1);
            
			//Saves the end time 
            long end = System.currentTimeMillis();
            
			//Takes the start time and end time prints out in the minutes, seconds, miliseconds format
			System.out.println(TimeUnit.MILLISECONDS.toMinutes(end - start) + " Minutes");
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(end - start) + " Seconds");
			System.out.println(TimeUnit.MILLISECONDS.toMillis(end - start) + " Milliseconds\n");
			
			//Writes the array back to a file.
			BufferedWriter output = null;
			output = new BufferedWriter(new FileWriter("QuickSort"+ array.length + ".txt"));

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
     * This quickSort funciton takes the array and uses a 
     * recursive algorithm to divided the array into smaller
     * parts. Each time the array is passed to the partition function
     * that sorts the subarray inforation and passes back a new pivot 
     * index.
     * 
     * @param arr - an integer array that needs to be sorted.
     * @param low - the starting index of the array to be sorted
     * @param high - the last index of the array to be sorted. 
     * 
     */
    private void quickSort(int[] arr, int low, int high){

        // If the start index is lower than the last index then 
        // there is still a section of the array that needs to be sorted.
        // if not then the function breaks out. 
        if(low < high){

            // Uses the partition fuction to get the next pivote point. 
            int partitionIndex = partition(arr, low, high);

            // Recursively calls the quickSort algorithm to make the problem 
            // smaller. 
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    /**
     * 
     * The partition function take an array of integers that need to be sorted
     * an index of the start and end of the array. A partition number of the last 
     * index in the array is set. Then all the other elements in the array are tested to
     * see if it is smaller if so the values are swapped. This is repeated until all the 
     * values lower than the pivot is on the left and all the larger values are on the right.
     * 
     * @param arr - An array of integers that needs to be sorted.
     * @param low - An integer that is the start value of the array
     * @param high - An integer that is the last value of the array
     * 
     * @return - A integer that is going to the be next pivot point. 
     * 
     */
    private int partition(int[] arr, int low, int high){

        // pivot stores the value of the last index for comparison
        int pivot = arr[high];

        // swap index. 
        int i = low - 1;

        // Loops through the array checking each value to see if it is less than
        // the pivot value, if so then the value is swap with the value in the swap 
        // index location. 
        for(int j = low; j < high; j++){

            if(arr[j] <= pivot){
                i++;

                // Swaps values.
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swaps the pivot value with the last next index that was swapped. 
        // this puts the pivot value in the spot of the array where the values on the 
        // left are lower than the pivot and the values on the right are larger than the
        // pivot value. 
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // returns the next pivot index. 
        return i + 1;
    }

    /**
     * 
     * A get function that returns the array that is sorted/ 
     * needs to be sorted. 
     * 
     */
    public int[] getArray(){

        return array;

    }

}
