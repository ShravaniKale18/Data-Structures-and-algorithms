/**
 * Approach
 * 1. Initialize low = 1 and high = m.
 * 2. Perform binary search on the possible answer.
 * 3. Calculate mid.
 * 4. Compute mid^n using binary exponentiation.
 * 5. Compare mid^n with m:
 *    - If equal, return mid.
 *    - If mid^n < m, search in the right half.
 *    - Otherwise, search in the left half.
 * 6. If no integer nth root exists, return -1.
 *
 * Time Complexity: O(log m × log n)
 * Space Complexity: O(1)
 */
public class NthRootOfInteger {

    static int nthRoot(int n, int m) {
        int low = 1;
        int high = m;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (calculatePower(mid, n) == m) {
                return mid;
            }else if (calculatePower(mid, n) < m) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }

    static long calculatePower(int mid, int n) {
        long ans = 1;

        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * mid;
                n = n - 1;
            }else{
                mid = mid * mid;
                n = n / 2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 3, m = 8;
        System.out.println(nthRoot(n, m));
    }
}
