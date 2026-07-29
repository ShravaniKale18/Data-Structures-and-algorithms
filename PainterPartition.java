import java.util.ArrayList;
import java.util.Arrays;

/**
 * Approach
 * - Initialize low with the maximum board length because
 *   one painter must paint at least the largest board.
 * - Initialize high with the sum of all board lengths because
 *   one painter could paint all the boards.
 *
 * - Apply Binary Search on Answer.
 * - mid represents the maximum workload allowed for one painter.
 * - Use calculatePainters() to check if all boards can be
 *   painted using at most k painters within this limit.
 *
 * - If possible, minimize the maximum workload:
 *      high = mid - 1
 * - If not possible, increase the workload:
 *      low = mid + 1
 *
 * TC -> O(N * log(S))
 *      N = number of boards
 *      S = sum of all board lengths
 *
 * SC -> O(1)
 */

public class PainterPartition {
    static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int low = 0;
        int high = 0;
        int ans = 0;

        for (int board : boards) {
            low = Math.max(low, board);
            high += board;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (calculatePainters(boards, mid, k) == true) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    static boolean calculatePainters(ArrayList<Integer> boards, int distance, int painters) {
        int painterCount = 1, distanceSum = 0;

        for (int board : boards) {
            if (distanceSum + board <= distance) {
                distanceSum += board;

            }else{
                painterCount++;
                distanceSum = board;

                if (painterCount > painters) {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3));
        int k = 2;

        System.out.println(findLargestMinDistance(arr, k));
    }
}
