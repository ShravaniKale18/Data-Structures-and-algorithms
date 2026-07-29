import java.util.Arrays;

/*
 * Approach:
 * 1. Sort the stall positions.
 * 2. The answer (minimum distance) lies between 1 and
 *    (last stall position - first stall position).
 * 3. Apply Binary Search on the minimum distance.
 * 4. For each mid distance, check if all k cows can be placed
 *    such that the distance between any two cows is at least mid.
 * 5. If possible, store the answer and search for a larger distance.
 * 6. Otherwise, search for a smaller distance.
 *
 * Time Complexity:
 * O(N log N + N log(maxDistance))
 * - Sorting: O(N log N)
 * - Binary Search: O(log(maxDistance))
 * - Feasibility Check: O(N) per binary search iteration
 *
 * Space Complexity:
 * O(1) (Ignoring the space used internally by Java's sorting algorithm)
 */

public class AggresiveCows {

    static int aggressiveCows(int[] arr, int k) {

        Arrays.sort(arr);

        int low = 0;
        int high = arr[arr.length - 1] - arr[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(arr, mid, k) == true) {
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans; 
    }

    static boolean canPlaceCows(int[] arr, int distance, int cows) {
        int last = arr[0];
        int cntCows = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= distance) {
                cntCows++;
                last = arr[i];
            }
            if (cntCows >= cows) return true;
        }
        return false;
    }
    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 8, 9};
        int k = 3;

        System.out.println(aggressiveCows(arr, k));
    }
}