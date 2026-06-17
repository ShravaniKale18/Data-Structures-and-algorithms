import java.util.HashMap;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Store frequency of characters in t
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int count = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)) { // If the character is in t, decrease the count and update the map
                if (map.get(ch) > 0) { 
                    count--; 
                }
                map.put(ch, map.get(ch) - 1); 
            }

            while (count == 0) { // When we have a valid window, try to shrink it from the left

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left); // Character at the left pointer

                if (map.containsKey(leftChar)) { // If the character is in t, increase the count and update the map
                    map.put(leftChar, map.get(leftChar) + 1); // Increase the count in the map

                    if (map.get(leftChar) > 0) {
                        count++;
                    }
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}