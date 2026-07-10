/**
 * Approach:
 * - Use Binary Search to find the first position where the target can be placed.
 * - Initialize low = 0, high = n - 1, and ans = n.
 * - If nums[mid] >= target, store mid as a possible answer and continue
 *   searching in the left half for an earlier valid position.
 * - Otherwise, search in the right half.
 * - After the search ends:
 *   - If the target exists, ans is its index.
 *   - Otherwise, ans is the index where the target should be inserted
 *     to maintain the sorted order.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class SearchInsertPosition {

    static int searchInsert(int[] nums, int target) {

        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = n;


        while(low <= high) {

            int mid = low + (high - low) / 2;
            
            if(nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int target = 4;

        int ans = searchInsert(arr, target);
        System.out.println(ans);
    }
}
