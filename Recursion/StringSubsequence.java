package Recursion;

import java.util.*;

/** 
 * Approach:
 * 1. We can use recursion to generate all possible subsequences of a given string.
 * 2. We can use a StringBuilder to build the current subsequence and an ArrayList to store all the subsequences.
 * 3. At each step, we have two choices: either include the current character in the subsequence or exclude it.
 * 4. We can use a base case to stop the recursion when we reach the end of the string.
 * 5. Finally, we can print the list of subsequences.
 * 
 * time complexity: O(2^n) where n is the length of the string. This is because for each character, we have two choices: include it or exclude it.
 * space complexity: O(n) for the recursion stack and O(2^n) for storing all the subsequences in the ArrayList.
 */

public class StringSubsequence {

    static void printSubsequences(String str, StringBuilder output, int index, ArrayList<String> subsequences) {
        if(index == str.length()) {
            String ans = output.toString();
            subsequences.add(ans);
            return;
        }

        char ch = str.charAt(index);
        //include character
        output.append(ch);
        printSubsequences(str, output, index + 1, subsequences);
        //exclude character
        output.deleteCharAt(output.length() - 1);
        printSubsequences(str, output, index + 1, subsequences);
    }
    public static void main(String[] args) {
        String str = "abc";
        int index = 0;
        StringBuilder output = new StringBuilder();
        ArrayList<String> subsequences = new ArrayList<>();

        printSubsequences(str, output, index, subsequences);
        System.out.println(subsequences);
    }
}
