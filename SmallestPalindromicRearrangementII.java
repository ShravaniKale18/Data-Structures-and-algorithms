import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SmallestPalindromicRearrangementII {

    static String smallestPalindrome(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int oddCount = 0;

        for(int freq : map.values()) {
            if (freq % 2 != 0) {
                oddCount++;
            }
        }

        if (oddCount > 1) {
            return "";
        }

        String leftChar="", newString="";

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue() / 2;

            for (int i = 0; i < count; i++) {
                    leftChar += entry.getKey();
            }
        }

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < leftChar.length(); i++) {

            ArrayList<String> temp = new ArrayList<>();

            temp.add(String.valueOf(leftChar.charAt(i)));

            for (int j = 0; j < leftChar.length(); j++) {
                if (i == j) {
                    continue;
                }
                temp.add(String.valueOf(leftChar.charAt(j)));
            }

            String reverse = new StringBuilder(leftChar).reverse().toString();

            // list.addAll(temp+reverse);
        }
        
        //newString = leftChar+reverse;

        return "";
    }
    public static void main(String[] args) {
        String s = "abba";
        int k = 2;

        // System.out.println(smallestPalindrome(s, k));
        smallestPalindrome(s, k);
    }
}
