import java.util.*;

/**
 * Problem: Remove Covered Intervals
 *
 * Approach:
 * 1. Sort the intervals:
 *    - Sort by start in ascending order.
 *    - If two intervals have the same start, sort by end in descending order.
 *      This ensures that the larger interval appears before the smaller one,
 *      making it easy to identify covered intervals.
 *
 * 2. Initialize:
 *    - count = 1 because the first interval is never covered.
 *    - maxEnd = end of the first interval.
 *
 * 3. Traverse the remaining intervals:
 *    - If the current interval's end is greater than maxEnd,
 *      it is not covered by any previous interval.
 *      Increment count and update maxEnd.
 *    - Otherwise, the current interval is covered, so ignore it.
 *
 * TC - O(N log N)
 *      Sorting takes O(N log N) and traversing takes O(N).
 *
 * SC - O(1)
 *      No extra space is used apart from a few variables.
 *      (Ignoring the space used internally by the sorting algorithm.)
 */
public class RemoveCoveredIntervals {

    public static int removeCoveredIntervals(int[][] intervals) {
        int count = 1;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int maxEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = intervals[i][1];

            if (currentEnd > maxEnd) {
                count++;
                maxEnd = currentEnd;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {3, 6}, {2, 8}};

        int count = removeCoveredIntervals(arr);
        System.out.println(count);
    }
}