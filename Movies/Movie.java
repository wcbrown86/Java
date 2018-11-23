/**
 * 
 * @author William Chad Brown
 * 
 * Movie Class, this object holds the information from the file.
 * the information is stored in variables relating to the information needed
 * 
 * overrides:
 * 		compareTo()
 * 		toString() 
 */

import java.text.NumberFormat;

public class Movie implements Comparable<Movie>{
	
	// Global variables that stores the movie Title, release year,
	// and gross sales. 
	private String title;
	private int year, grossingSales;
	
	
	/**
	 * 
	 * Constructor that is used to make a new Movie object. 
	 * 
	 * @param movieYear - Release year of the movie, stored and an int
	 * @param movieTitle - String representing the movie title.
	 * @param movieSales - a int representing the gross sales of the movie. 
	 * 
	 */
	public Movie(int movieYear, String movieTitle, int movieSales) {
		
		year = movieYear;
		title = movieTitle;
		grossingSales = movieSales; 
		
	}
	
	/**
	 * Setting method for the Year variable.
	 * 
	 * @param movieYear - int representing the movies release year.
	 */
	public void addYear(int movieYear){
		year = movieYear;
	}
	
	/**
	 * 
	 * Getter method for the year variable.
	 *  
	 * @return - returns a int representing the movies release year. 
	 * 
	 */
	public int getYear(){
		
		return year;
	}
	
	/**
	 * 
	 * Setter method for the movie title.
	 * 
	 * @param movieTitle - a String the represents the title of the movie. 
	 * 
	 */
	public void addTitle(String movieTitle){
		
		title = movieTitle;
		
	}
	
	/**
	 * 
	 * Getter method for the title variable.
	 * 
	 * @return - returns a string the represents the movies title.
	 * 
	 */
	public String getTitle(){
		
		return title;
		
	}
	
	/**
	 * 
	 * Setter method for the gross sales variable.
	 * 
	 * @param movieSales - an int that represents the rounded gross sales
	 * 					   of the movie.
	 * 
	 */
	public void addSales(int movieSales){
		
		grossingSales = movieSales;
	}
	
	/**
	 * 
	 * Getter method for the gross sales variable.
	 * 
	 * @return - returns the value of the gross sales variable 
	 * 			 and int that represents the value of the sales. 
	 * 
	 */
	public int getSales(){
		
		return grossingSales;
		
	}
	

	/**
	 * This is the overridden method for the Comparable interface. 
	 * This compareTo method takes a Movie objects and sorts the movie
	 * based off the release year is descending order.
	 * 
	 */
	@Override 
	public int compareTo(Movie compareMovie) {
		
		//grabs the year information to be compared 
		int compareYear = compareMovie.getYear();
		
		//compares the information in descending order.
		return compareYear-this.year;
		
	}
	
	/**
	 * 
	 * Overridden toString method that formats the information to show 
	 * Year: year, Title: title, Sales: sales
	 * 
	 * NumberFormat is used to format the number in dollars to make the 
	 * number easer to read. 
	 * 
	 */
	@Override 
	public String toString(){
		
		// Used to format the gross sales int to a dollar decimal format. 
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String formattedTitle = String.format(" Title: %-46s", title); 
		
		return String.format("Year: %s,", year) + formattedTitle + String.format(" Sales: %20s" , formatter.format((double)grossingSales)) ;
	}

}
