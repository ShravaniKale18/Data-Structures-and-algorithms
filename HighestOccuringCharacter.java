import java.util.HashMap;
import java.util.Map;

public class HighestOccuringCharacter {

    /** 
     * Approach:
     * 1. Create a HashMap to store the frequency of each character in the string
     * 2. Iterate through the string and update the frequency of each character in the HashMap
     * 3. Iterate through the HashMap to find the character with the highest frequency
     * 4. Return the character with the highest frequency
     
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) where n is the number of unique characters in the string
     */
    public static char highestOccuringChar(String str) {
		
		HashMap<Character, Integer> map = new HashMap<>();

		for(int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}

		char anschar = '\0';
		int currentValue = 0;

		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			if(entry.getValue() > currentValue) {
				anschar = entry.getKey();
				currentValue = entry.getValue();
			}
		}

		return anschar;
	}

    public static void main(String[] args) {

        String str = "ababceugaduaabbaa";
        char result = highestOccuringChar(str);
        System.out.println("The highest occurring character is: " + result);
    }
}
