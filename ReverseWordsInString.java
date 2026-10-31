public class ReverseWordsInString {

    /**
     * Approach:
     * 1. Remove leading and trailing spaces using trim().
     * 2. Split the string into words using "\\s+" regex,
     *    which handles multiple spaces between words.
     * 3. Traverse the words array from the last index to the first.
     * 4. Append each word to the result string.
     * 5. Return the reversed string after removing the trailing space.
     *
     * Time Complexity: O(N^2)
     *
     * Space Complexity: O(N)
     * - To store the words array and the resulting string.
     */

    public static String reverseWords(String s) {

        s = s.trim();

        if(s.isEmpty()) {
            return "";
        }

        String[] arr = s.split("\\s+");
        String ansString = "";

        for (int i = arr.length - 1; i >= 0; i--) {
            ansString += arr[i] + " ";
        }

        return ansString.trim();
    }

    public static void main(String[] args) {

        String s = "   the sky is blue";

        String ans = reverseWords(s);

        System.out.println("Reversed String = " + ans);
    }
}
