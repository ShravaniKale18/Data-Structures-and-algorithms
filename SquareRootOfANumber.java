/**
 * Approach
 * 1. Initialize low = 1 and high = n.
 * 2. Perform binary search to find the square root.
 * 3. Calculate mid.
 * 4. If (long) mid * mid <= n:
 *      - Store mid as the current answer.
 *      - Search in the right half (low = mid + 1) to find a larger valid value.
 * 5. Otherwise:
 *      - Search in the left half (high = mid - 1).
 * 6. Return the stored answer, which is the floor value of √n.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class SquareRootOfANumber {

    static int mySqrt(int n) {

        if (n == 0) {
            return 0;
        }

        int low = 1;
        int high = n;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((long) mid * mid <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 36;
        System.out.println(mySqrt(n)); // 6
    }
}