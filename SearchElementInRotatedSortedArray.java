public class SearchElementInRotatedSortedArray {

    /**
     * Approach:
     * Traverse the array from left to right.
     * Compare each element with the target.
     * If the target is found, return its index.
     * If the traversal completes without finding the target,
     * return -1.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    static int search1(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach:
     * Use Binary Search since the array is sorted and rotated.
     *
     * In every iteration:
     * 1. Find the middle element.
     * 2. If the middle element is the target, return its index.
     * 3. Check which half is sorted.
     *    - If nums[low] <= nums[mid], the left half is sorted.
     *    - Otherwise, the right half is sorted.
     * 4. Check whether the target lies in the sorted half.
     *    - If yes, search that half.
     *    - Otherwise, search the other half.
     * 5. Repeat until the target is found or the search space becomes empty.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */

    static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }else if(nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                }else{
                    low= mid + 1;
                }
            }else{
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println(search(nums, target));;
    }
}
