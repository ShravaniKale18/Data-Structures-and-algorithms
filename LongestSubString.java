// https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
// T.C: O(n) S.C: O(k)

import java.util.HashMap;

public class LongestSubString {
    static int longestKSubstr(String s, int k) {
        // Implementation for finding the longest substring with exactly k distinct characters
        HashMap<Character, Integer> charCount = new HashMap<>();
        int maxLength = -1;
        int low = 0;

        for(int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

            if(charCount.size() == k) {
                maxLength = Math.max(maxLength, high - low + 1);
            }else if((charCount.size()) > k) {
                while(charCount.size() > k) {
                    char leftChar = s.charAt(low);
                    charCount.put(leftChar, charCount.get(leftChar) - 1);

                    if(charCount.get(leftChar) == 0) {
                        charCount.remove(leftChar);
                    }
                    low++;
                }
            }else{
                continue;
            }

        }
        return maxLength; 
    }
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestKSubstr(s, k));
    }
}
