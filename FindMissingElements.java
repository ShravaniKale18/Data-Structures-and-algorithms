import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/**
 * Approach:
 * 1. Find the minimum and maximum elements in the array.
 * 2. Store all array elements in a HashSet for O(1) average lookup.
 * 3. Traverse from min to max.
 * 4. If a number is not present in the HashSet, add it to the answer list.
 * 5. Return the list of all missing elements.
 *
 * Time Complexity:
 * O(N + R)
 * where,
 * N = number of elements in the array
 * R = (max - min + 1), i.e., the range of numbers between min and max.
 *
 * - Finding min and max: O(N)
 * - Inserting into HashSet: O(N)
 * - Traversing the range: O(R)
 *
 * Overall: O(N + R)
 *
 * Space Complexity:
 * O(N)
 * - HashSet stores all N elements.
 * - The answer list stores only the missing elements (excluded from auxiliary space).
 */

public class FindMissingElements {

    static List<Integer> findMissingElements(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // System.out.println(set);
        

        for(int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,2,5};

        System.out.println(findMissingElements(nums));
    }
}
