//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//TC -> O(n)
//SC -> O(min(m, n)) where m is the size of the character set and n is the length of the input string. In the worst case, if all characters in the string are unique, the space complexity would be O(n). However, if the character set is limited (e.g., ASCII), then the space complexity would be O(1) since it would not grow with the input size.

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChar {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int low = 0;
        HashMap<Character, Integer> charCount = new HashMap<>();

        for(int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);

            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

            if(charCount.get(ch) == 1) {
                maxLength = Math.max(maxLength, high - low + 1);
            }else {
                while(charCount.get(ch) > 1) {
                    char leftChar = s.charAt(low);
                    charCount.put(leftChar, charCount.get(leftChar) - 1);

                    if(charCount.get(leftChar) == 0) {
                        charCount.remove(leftChar);
                    }
                    low++;
                }
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s = "abccd";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
