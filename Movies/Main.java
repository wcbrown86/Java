/**
 * 
 * @author William Chad Brown
 * 
 * Date: June, 2017
 * 
 * Description:	Driver class that is used to parse the information in the file, movies.csp
 * 				and place the information into the desired data structures. In this case the 
 * 				program will use a HashMap with a key of a char and the values will be an ArrayList
 * 				of type String. The Key is used to store movies titles in alphabetical order. and the
 * 				values is a list of all the movies who's title starts with that letter. This program does
 * 				not take into account "The" in a title. So all movies starting with "The" will be stored 
 * 				under the key value of 'T'. Once the information is read and stored, the information is 
 * 				printed in two ways, one by descending order of the year the movie was released. The other 
 * 				by alphabetical order. 
 *
 */

// Imports used to read the file provided. 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Data structure imports. 
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Main {
	
	// Global variables. 
	// movieList is used to hold a list of movie objects. this is used to print the movies 
	// in descending order by the year.
	public static ArrayList<Movie> movieList = new ArrayList<Movie>();
	
	// movieMap is used to print the movies in order by Title. 
	public static Map<Character, ArrayList<String>> movieMap = new HashMap<Character, ArrayList<String>>();
	
	// Holds the file name, of the file the movies will be read from. 
	public static String filename = "topmovies.csv";

	/**
	 * 
	 * Main function calls the parseMovie function to grab the information from the provided file.
	 * Then calls the to printing functions to display the information to the user as described above. 
	 * 
	 * @param args - args is needed for the definition for the program to work
	 * 				 but is not used in the case.
	 *  
	 */
	public static void main(String[] args) {
		
		//pulls the information for the provided file and places the information in the data structures
		parseMovie();
		
		//Prints out the list information by year descending order
		System.out.println("Movies Listed by Year in Descending Order");
		printYearDescendingOrder();
		
		// Newlines to help separate the information making it easier to read. 
		System.out.print("\n\n\n");
		
		//Prints out the list where movies are listed in alphabetical order.
		System.out.println("Movies listed by the first letter of there title");
		printMoviesAlphbeticly();

	}
	
	/**
	 * 
	 * Opens the file provided and grabs the information in the file, after information is passed to 
	 * two different data structures. One is stored in an ArrayList, the other is a HashMap with an
	 * ArrayList as the value and a key of a Character.
	 * 
	 */
	public static void parseMovie(){
	      // Lets make sure the file path is not empty or null
        if (filename == null || filename.isEmpty()) {
               System.out.println("Invalid File Path");
               return; }
        String filePath = System.getProperty("user.dir") + "/" + filename;
        BufferedReader inputStream = null;
        // We need a try catch block so we can handle any potential IO errors
        try {
               try {
                      inputStream = new BufferedReader(new FileReader(filePath));
                      String lineContent = null;
                      // Loop will iterate over each line within the file.
                      // It will stop when no new lines are found.
                      while ((lineContent = inputStream.readLine()) != null) {
                    	  //Calls the method that puts the information in the data structures
                    	  addMovies(lineContent);
                          //System.out.println("Found the line: " + lineContent);
                      } 
                    }
               // Make sure we close the buffered reader.
               finally {
                      if (inputStream != null)
                            inputStream.close();
               }
        	} 
        	catch (IOException e) {
               e.printStackTrace();
        	}// end 
		
	}

	/**
	 * 
	 * The addMovies function takes the information read from each line in the file,
	 * then separates the different values in the string to fill out the Movies object.
	 * 
	 * @param lineContent - is a string containing the line of information read from the file.
	 * 						the string will contain comma separated values. 
	 * 
	 */
	private static void addMovies(String lineContent) {
		
		//Stores passed information in a String array. information is split a the token ','
		String[] resultingInformation = lineContent.split(",");
		
		//if statement to skip the first line of information
		if(!resultingInformation[0].equals("Year")){
			
			//takes the string array and trims the extra white space and stores the 
			//information in separate variables bases off the information value.
			int year = Integer.parseInt(resultingInformation[0].trim());
			String title = resultingInformation[1].trim();
			int sales = Integer.parseInt(resultingInformation[2].trim());
			
			//Creates the key needed for the HashMap
			Character key = Character.valueOf(title.charAt(0));
			
			//Adds the information to the ArraryList
			movieList.add(new Movie(year, title, sales));
			
			//Adds the information to the HashMap 
			if(movieMap.get(key) == null){
				
				//Creates the key value pair if not already created
				movieMap.put(key, new ArrayList<String>());
				
			}
			
			//Adds another value to the key if already created. 
			movieMap.get(key).add(title);
			
		}
		
	}
	
	/**
	 * 
	 * The print year function takes the movieList and sorts it with the comparator 
	 * function that is overridden in the Movies class. This will sort the objects in
	 * Descending order by year. 
	 * 
	 */
	private static void printYearDescendingOrder(){
		
		//uses the Collections.sort, calls the compareTo method in the Movie Class
		Collections.sort(movieList);
		
		//for loop that prints the information
		for(Movie str: movieList){
			
			System.out.println(str);
			
		}
	}
	
	/**
	 * 
	 * This function will take the movie Map and sort the keys into
	 * Alphabetical order, then sort each keys ArrayList. after both
	 * sets are sorted the function will print each value in the ArrayList.
	 * 
	 */
	private static void printMoviesAlphbeticly() {
		
		// Sort the map by keys using a TreeMap. 
		TreeMap<Character, ArrayList<String>> sorted = new TreeMap<Character, ArrayList<String>>();
		sorted.putAll(movieMap);
		
		
		//for loop that prints the key then the information in the ArraryList, after the ArrayList
		// is sorted. 
		for(Map.Entry<Character, ArrayList<String>> movie : sorted.entrySet()){
			
			Collections.sort(movie.getValue());
			String key = movie.getKey().toString().toUpperCase();
			System.out.print(key + ": ");
			ArrayList<String> movieTitle = movie.getValue();
			
			//if there is more than one item in the ArrayList then this for loop prints all items.
			if(movieTitle.size() > 0){
				
				for(String str: movieTitle){
				System.out.print(str + ", ");
				
				}
			
			//If only one item this will print just the one item
			}else{
				System.out.print(movieTitle.get(0));
			}
			
			//Formatting, adds lines to make it easier to read. 
			System.out.print("\n");
		}
		
	}

}
