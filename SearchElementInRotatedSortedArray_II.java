public class SearchElementInRotatedSortedArray_II {

    /**
     * Approach
     * 1. Apply Binary Search on the rotated sorted array.
     * 2. If the middle element equals the target, return true.
     * 3. If nums[low] == nums[mid] == nums[high], we cannot determine the sorted half,
     *    so shrink the search space by incrementing low and decrementing high.
     * 4. Otherwise, determine which half is sorted:
     *    - If the left half is sorted, check whether the target lies within it.
     *      If yes, search the left half; otherwise, search the right half.
     *    - If the right half is sorted, check whether the target lies within it.
     *      If yes, search the right half; otherwise, search the left half.
     * 5. Repeat until the target is found or the search space becomes empty.
     *
     * Time Complexity:
     * - Average Case: O(log n)
     * - Worst Case: O(n) (when many duplicates exist, e.g., [1,1,1,1,1])
     *
     * Space Complexity:
     * - O(1)
     */
    static boolean search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {

                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }
            // Right half is sorted
            else {

                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;

        search(nums, target);
    }
}
