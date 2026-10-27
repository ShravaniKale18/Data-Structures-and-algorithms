
public class EcoWoodCuttingProblem {

    /*
     * Approach: Binary Search on Answer
     *
     * 1. Find the maximum tree height and set it as high.
     * 2. Initialize low = 0 because the saw can cut at ground level.
     * 3. Calculate mid, the current cutting height.
     * 4. Use isValid() to check whether cutting at mid
     *    collects at least m units of wood.
     * 5. If valid:
     *      - Store mid as the answer.
     *      - Search for a higher cutting height.
     * 6. If invalid:
     *      - Search for a lower cutting height.
     * 7. Return the maximum valid cutting height.
     *
     * Time Complexity:
     * O(N * log H)
     * N = number of trees
     * H = maximum tree height
     *
     * Space Complexity:
     * O(1) auxiliary space
     */

    static int maxHeight(int[] arr, int m) {

        int low = 0;
        int high = 0;
        int ans = -1;

        // Find the maximum tree height
        for (int i = 0; i < arr.length; i++) {
            high = Math.max(high, arr[i]);
        }

        // Binary search on the cutting height
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isValid(arr, mid, m)) {

                // Enough wood is collected.
                // Try a higher cutting height.
                ans = mid;
                low = mid + 1;

            } else {

                // Not enough wood is collected.
                // Try a lower cutting height.
                high = mid - 1;
            }
        }

        return ans;
    }

    /*
     * Checks whether cutting all trees at the given
     * height collects at least m units of wood.
     *
     * If a tree is taller than the cutting height,
     * collected wood = tree height - cutting height.
     *
     * Return true if collected wood >= m.
     */

    static boolean isValid(int[] arr, int height, int m) {

        long woods = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > height) {
                woods += (long) arr[i] - height;
            }

            // Stop early once enough wood is collected
            if (woods >= m) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = {4, 7, 10, 15};
        int m = 7;

        System.out.println(maxHeight(arr, m)); // Output: 8
    }
}
