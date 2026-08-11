import java.util.Arrays;

/**
 * Approach:
 * - Sort the heights array.
 * - Initially consider the difference between the maximum and minimum height.
 * - Try every possible split point.
 * - Increase the heights on the left side by k.
 * - Decrease the heights on the right side by k.
 * - Calculate the new minimum and maximum height.
 * - Keep the minimum possible difference.
 *
 * TC => O(N log N)
 * SC => O(1)
 */

public class MinimizeMaximumDiffrenceBetweenHeights {    

    static int minimizeMax(int[] heights, int k) {

        int n = heights.length;
        int newMin = Integer.MAX_VALUE;
        int newMax = Integer.MIN_VALUE;

        Arrays.sort(heights);

        int ans = heights[n - 1] - heights[0];

        for (int i = 0; i < n - 1; i++) {

            newMin = Math.min(heights[0] + k, heights[i + 1] - k);
            newMax = Math.max(heights[i] + k, heights[n - 1] - k);

            ans = Math.min(ans, newMax - newMin);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] heights = {1, 5, 8, 10};
        int k = 2;

        System.out.println(minimizeMax(heights, k));
    }
}
