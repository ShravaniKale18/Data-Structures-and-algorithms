/**
 * Approach:
 *
 * - Use the two-pointer approach.
 * - Initialize i with 0 and j with length - 1.
 * - Loop while i <= j.
 * - Swap the characters at index i and j.
 * - Increment i and decrement j after every swap.
 * - Continue until the two pointers meet or cross.
 *
 * TC => O(N)
 *       We perform approximately N/2 swaps, which is O(N).
 *
 * SC => O(1)
 *       No extra space is used because the array is modified in-place.
 */

public class ReverseString {

    static void reverseString(char[] s) {
        
        int i = 0;
        int j = s.length - 1;

        while (i <= j) {
            swap(s, i, j);
            i++;
            j--;
        }

        // System.out.println(Arrays.toString(s));
    }

    static void swap(char[] ch, int ch1, int ch2) {

        char temp = ch[ch1];
        ch[ch1] = ch[ch2];
        ch[ch2] = temp;
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        
        reverseString(s);
    }
}
