
/**
 * 
 * @author - William Chad Brown
 * 
 * Description:	This simple program is used to show how rnadom numbers work within the 
 * 				Java Random class. The program will generate 50 random numbers. Each time
 * 				a random number is created a * is added to the ten number range that the 
 * 				number falls into. Then this information is printed to the screen with formatting.
 * 				The program is set up to support a number of size 1000 before formatting becomes an
 * 				issue, and will slow down pass 10,000. 
 */

import java.util.Random; 


public class RandomNumbers {

	

	public static void main(String[] args){
		
		// Local variables, numRandom is used to set the number of 
		// random numbers generated and accounted for. 
		Random r = new Random();
		int numRandom = 50;

		// Count holds the number of numbers generated in the range shown in 
		// the range array. 
		String[] count = {"","","","","","","","","","",};
		String[] range = {" 1 - 10", "11 - 20", "21 - 30", "31 - 40", "41 - 50", "51 - 60",
				"61 - 70", "71 - 80", "81 - 90", "91 - 100"};
		
		// Loops the number of times set by numRandom. each time creating a 
		// new random number and incrementing the count for the related range.
		for(int i = 0; i < numRandom; i++){
			
			int num = r.nextInt(100)+1;
			
			if(num > 0 && num < 11)
				count[0] += "*";
			else if(num > 10 && num < 21)
				count[1] += "*";
			else if(num > 20 && num < 31)
				count[2] += "*";
			else if(num > 30 && num < 41)
				count[3] += "*";
			else if(num > 40 && num < 51)
				count[4] += "*";
			else if(num > 50 && num < 61)
				count[5] += "*";
			else if(num > 60 && num < 71)
				count[6] += "*";
			else if(num > 70 && num < 81)
				count[7] += "*";
			else if(num > 80 && num < 91)
				count[8] += "*";
			else
				count[9] += "*";
			
		}
		
		// The loop through the arrays and prints the range value and the count string. 
		for(int i = 0; i < range.length; i++){
			
			System.out.printf(" %-10s |   %-10s \n", range[i], count[i] );
			
		}		
	}
}
