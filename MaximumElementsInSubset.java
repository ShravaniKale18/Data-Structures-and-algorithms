/*
 * Approach:
 * 1. Store the frequency of each number in a HashMap.
 * 2. Handle the number 1 separately because 1² = 1, which would otherwise
 *    lead to an infinite loop.
 *    - If the count of 1's is odd, all of them can be used.
 *    - If the count is even, one must be excluded so that the length remains odd.
 * 3. For every unique number (except 1):
 *    - Treat it as the starting element of the chain.
 *    - While the current number has a frequency of at least 2:
 *         - Use two copies (one on each side of the palindrome).
 *         - Move to its square.
 *    - If exactly one copy of the current number exists,
 *      use it as the center of the palindrome.
 *    - Otherwise, remove one element from the length because
 *      the last pair cannot be completed.
 * 4. Keep track of the maximum valid subset length.
 *
 * Time Complexity: O(N)
 * - Building the frequency map takes O(N).
 * - Each unique number is processed, and the squaring chain is very short
 *   because values grow exponentially (x → x² → x⁴ → ...).
 * - Overall complexity is O(N).
 *
 * Space Complexity: O(N)
 * - HashMap stores the frequency of each unique number.
 */

import java.util.HashMap;
import java.util.Map;

public class MaximumElementsInSubset {
    static int maximumLength(int[] nums) {
        int maxLength = 1;
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put((long)nums[i], map.getOrDefault((long)nums[i], 0) + 1);
        }

        for (Map.Entry<Long, Integer> m : map.entrySet()) {

            if (m.getKey() == 1L)
                continue;

            long current = m.getKey();
            int len = 0;

            while (map.containsKey(current) && map.get(current) >= 2) {
                len += 2;
                current *= current;
            }

            if (map.get(current) == 1) {
                len += 1;
            }else{
                len -= 1;
            }

            maxLength = Math.max(maxLength, len);
        }

        return maxLength;
    }
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 2, 2};
        int ans = maximumLength(arr);
        System.out.println(ans);
    }
}
