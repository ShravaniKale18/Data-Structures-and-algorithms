
/**
 * Approach (Binary Search)
 *
 * 1. Initialize two pointers:
 *    - low = 0
 *    - high = n - 1
 *
 * 2. While low < high:
 *    - Find the middle index.
 *    - Compare nums[mid] with nums[mid + 1].
 *
 *      a) If nums[mid] > nums[mid + 1]:
 *         - We are on the descending slope.
 *         - A peak lies on the left side (including mid).
 *         - Set high = mid.
 *
 *      b) Otherwise:
 *         - We are on the ascending slope.
 *         - A peak lies on the right side.
 *         - Set low = mid + 1.
 *
 * 3. When low == high, the search space contains only one element,
 *    which is the peak element. Return its index.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class FindPeakElement {

    static int findPeakElement(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid+1]) {
                high =  mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElement(nums));
    }
}
