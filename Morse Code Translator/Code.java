/**
 * 
 * @author - William Chad Brown
 * 
 * Description:	This class holds the information that is needed to translate a string
 * 				to morse code. The main driver class reads a file that contains the information
 * 				that then adds that information to the class in a key value HashMap. A HashMap 
 * 				was used to help with searching for the needed information. 
 * 
 */


// Imports used for the data structure of the class.
import java.util.HashMap;
import java.util.Map;

public class Code {

	// HashMap that stores the translation information. 
	Map<String, String> codeMap = new HashMap<String, String>();
	
	/**
	 * 
	 * Function that takes in a string and returns a string. The string that 
	 * is returned is a translated string in morse code. 
	 * 
	 * @param str - A string that was entered by the user to translate to morse code.
	 * @return - A translated string that is shown back to the user.
	 * 
	 */
	public String translate(String str){
		
		// The string that is passed is capitalized to match the keys of the codeMap
		str = str.toUpperCase();
		
		// temp array that is used to check each letter to the codeMap.
		char temp[] = str.toCharArray();
		
		// translated string that is returned to the user. 
		String translated = "";
		
		// This loop will check each character in the array and add the value to the
		// translated string. If the string is a space then the space is kept, and 
		// other characters are also kept. 
		for(int i = 0; i < temp.length; i++){
			
			if(temp[i] == ' ')
				translated += "   ";
			else if(codeMap.containsKey(String.valueOf(temp[i])))
				translated += codeMap.get(String.valueOf(temp[i]));
			else
				translated += temp[i];
			
		}
		
		return translated;
	}

	/**
	 * 
	 * The add function is used to add new information to the 
	 * codeMap.
	 * 
	 * @param key - a String that represents a single letter or number 
	 * @param value - the morse code representation of the key.
	 * 
	 */
	public void add(String key, String value){
		
		codeMap.put(key, value);
		
	}
	
	/**
	 * 
	 * Get function that returns the morse code translated key. 
	 * 
	 * @param key - a String that represents a single letter or number
	 * @return - returns the value of the key value pair, which is a morse code
	 * 			 translated string of the key.
	 * 
	 */
	public String get(String key){
		
		return codeMap.get(key);
	}

}
