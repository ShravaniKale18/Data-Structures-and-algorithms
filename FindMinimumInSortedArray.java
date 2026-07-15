public class FindMinimumInSortedArray {

    /**
     * Approach 1: Brute Force (Linear Search)
     *
     * Traverse the entire array and keep track of the minimum element.
     * Since the array is rotated, the minimum element can appear anywhere,
     * so we check every element and update the minimum value.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    static int findMin1(int[] nums) {

        int minEle = nums[0];

        for (int i = 0; i < nums.length; i++) {
            minEle = Math.min(minEle, nums[i]);
        }
        return minEle;
    }

    /**
     * Approach 2: Binary Search (Optimal)
     *
     * A rotated sorted array contains two sorted parts.
     * We use binary search to find the part where the minimum element exists.
     *
     * If the left half is sorted (nums[low] <= nums[mid]):
     * - nums[low] is the smallest element in that sorted half.
     * - Store it as a possible minimum.
     * - Move to the right half because the rotation point may exist there.
     *
     * Otherwise:
     * - The minimum element lies in the left half.
     * - nums[mid] can be the minimum.
     * - Search in the left half.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */

    static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[low] <= nums[mid]) {
                min = Math.min(min, nums[low]);
                low = mid + 1;
            }else{
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};

        System.out.println(findMin(nums));;
    }
}
