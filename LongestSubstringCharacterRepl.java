// https://leetcode.com/problems/longest-repeating-character-replacement/description/
//TC: O(n)
//SC: O(1) since we are only storing 26 characters in the map

import java.util.HashMap;

public class LongestSubstringCharacterRepl {
    public static int characterReplacement(String s, int k) {
        int maxLength = 0, maxFreq = 0;
        int low = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            while((high - low + 1) - maxFreq > k) {
                char leftChar = s.charAt(low);
                map.put(leftChar, map.get(leftChar) - 1);
                low++;
            }
            
            maxLength = Math.max(maxLength, high - low + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
}
