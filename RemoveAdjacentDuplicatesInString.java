public class RemoveAdjacentDuplicatesInString {

/**
 * Approach:
 * 1. Use a StringBuilder to store the final result and simulate a stack.
 * 2. Traverse the input string character by character.
 * 3. If the StringBuilder is empty, append the current character.
 * 4. Otherwise, compare the current character with the last character
 *    present in the StringBuilder.
 *      - If both characters are equal, remove the last character.
 *      - Otherwise, append the current character.
 * 5. Return the StringBuilder as a string.
 *
 * Time Complexity: O(N)
 * - Each character is processed once.
 * - Append and delete-at-last operations take amortized O(1).
 *
 * Space Complexity: O(N)
 * - StringBuilder stores the resulting characters.
 */
    public static String removeDuplicates(String s) {
        
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (ans.isEmpty()) {
                ans.append(s.charAt(i));
            }else if(s.charAt(i) == ans.charAt(ans.length() - 1)) {
                ans.deleteCharAt(ans.length() - 1);
            }else{
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";

        System.out.println(removeDuplicates(s));
    }
}
