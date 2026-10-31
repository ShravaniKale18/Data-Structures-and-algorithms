import java.util.HashMap;
import java.util.Map;

/**
 * Approach:
 * 1. Create a HashMap to store the frequency of each character.
 * 2. Traverse the string and update the frequency of each character.
 * 3. Initialize maxFreq = 0 and ch = '\0'.
 * 4. Traverse the HashMap entries:
 *      - If current frequency > maxFreq, update maxFreq and ch.
 *      - If current frequency == maxFreq and current character < ch,
 *        update ch to the lexicographically smaller character.
 * 5. Return the character with the maximum frequency.
 *
 * Time Complexity: O(N + K) = O(N)
 * Space Complexity: O(K) = O(N)
 *
 * N = Length of the string
 * K = Number of distinct characters
 */

public class MaxFrequencyCharacter {
    public static char getMaxOccuringChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int maxFreq = 0;
        char ch = '\0';
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() > maxFreq || (entry.getValue() == maxFreq && entry.getKey() < ch)) {
                maxFreq = entry.getValue();
                ch = entry.getKey();
            }
        }
        
        return ch;
    }

    public static void main(String[] args) {
        String s = "aabbccdegfvi";

        System.out.println(getMaxOccuringChar(s));
    }
}


