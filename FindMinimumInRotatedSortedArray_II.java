public class FindMinimumInRotatedSortedArray_II {

    public static int findMin1(int[] nums) {
        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minimum) {
                minimum = nums[i];
            }
        }

        return minimum;
    }

     /*
     * Approach:
     * 1. Use binary search to find the minimum element.
     * 2. Compare nums[mid] with nums[high].
     *
     * 3. If nums[mid] > nums[high]:
     *    - The minimum lies in the right half.
     *    - Move low = mid + 1.
     *
     * 4. If nums[mid] < nums[high]:
     *    - The right half is sorted.
     *    - nums[mid] can be the minimum, so search the left half.
     *    - Move high = mid - 1.
     *
     * 5. If nums[mid] == nums[high]:
     *    - Due to duplicates, we cannot determine which side
     *      contains the minimum.
     *    - Safely reduce the search space using high--.
     *
     * 6. Keep updating minValue with nums[mid].
     *
     * Time Complexity:
     * Average Case: O(log N)
     * Worst Case: O(N) because duplicates may cause high-- repeatedly.
     *
     * Space Complexity:
     * O(1)
     */

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int minValue = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Update minimum
            minValue = Math.min(minValue, nums[mid]);

            // Left half is unsorted, minimum is on the right
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
            // Right half is sorted, minimum can be mid or on the left
            else if (nums[mid] < nums[high]) {
                high = mid - 1;
            }
            // Duplicate values
            else {
                high--;
            }
        }

        return minValue;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 5, 1, 1, 2, 2};

        System.out.println(
            "The minimum value in the rotated sorted array is: "+ findMin(nums)
        );
    }
}