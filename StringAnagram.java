import java.util.HashMap;

/** 
 * Approach:
 * 1. Concatenate the first two strings (s1 and s2) to form a new string (newString).
 * 2. Create a HashMap to store the frequency of each character in newString.
 * 3. Iterate through newString and populate the HashMap with the character counts.
 * 4. Check if the length of newString is equal to the length of the third string (s3). 
 *    If not, print "NO" and return.  
 * 5. Iterate through each character in s3 and check if it exists in the HashMap and has a non-zero count.
 *    If a character is not found or its count is zero, print "NO" and return.
 *    If the character is found, decrement its count in the HashMap.
 * 6. If all characters in s3 are found in the HashMap with non-zero counts, print "YES".
 
 * Time Complexity: O(n + m), where n is the length of newString and m is the length of s3.
 * Space Complexity: O(n), where n is the number of unique characters in newString.
 */

public class StringAnagram {
    public static void answer(String s1,String s2,String s3){

		String newString = s1 + s2;

		HashMap<Character, Integer> map = new HashMap<>();

		for(int i = 0; i < newString.length(); i++) {
			map.put(newString.charAt(i), map.getOrDefault(newString.charAt(i), 0) + 1);
		}
		
		if(newString.length() != s3.length()) {
			System.out.println("NO");
			return;
		}

		for(int i = 0; i < s3.length(); i++) {
			char ch = s3.charAt(i);

			if(!map.containsKey(ch) || map.get(ch) == 0) {
				System.out.println("NO");
				return;
			}else{
				map.put(ch, map.get(ch) - 1);
			}
		}

		System.out.println("YES");
	}

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        String s3 = "dabecf";

        answer(s1, s2, s3);
    }
}
