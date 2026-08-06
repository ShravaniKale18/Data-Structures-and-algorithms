import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Approach:
 * 1. Sort the array.
 * 2. Since the array is sorted, the minimum absolute difference
 *    can only occur between adjacent elements.
 * 3. Traverse the array and compare every adjacent pair.
 * 4. If a smaller difference is found:
 *      - Clear the previous answer.
 *      - Update the minimum difference.
 *      - Add the current pair.
 * 5. If the difference equals the minimum difference,
 *    add the current pair.
 *
 * Time Complexity: O(N log N)
 * Space Complexity: O(K)
 * where K is the number of pairs stored in the answer.
 */
public class MinimumAbsoluteDiffreneces {
    static List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> ans = new ArrayList<>();

        int minDiff = Integer.MAX_VALUE;
        int diff = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {

            List<Integer> temp = new ArrayList<>();
            int a = arr[i];
            int b = arr[i + 1];

            diff = Math.abs(b - a);

            if (diff < minDiff) {

                ans.clear();
                minDiff = diff;
                temp.add(a);
                temp.add(b);
            }else if (diff == minDiff) {

                temp.add(a);
                temp.add(b);
            }else{
                continue;
            }

            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,10,15};

        System.out.println(minimumAbsDifference(arr));
    }
}
