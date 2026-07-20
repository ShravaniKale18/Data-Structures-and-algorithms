/**
 * Approach
 * - Initialize 'low' as 1, since the smallest possible divisor is 1.
 * - Initialize 'high' as the maximum element in the array, since the divisor
 *   cannot be greater than the largest element.
 * - Perform Binary Search on the range [low, high].
 * - For each mid (candidate divisor), calculate the sum of
 *   ceil(nums[i] / mid) for all elements.
 * - If the calculated sum is less than or equal to the threshold,
 *   store 'mid' as a possible answer and search for a smaller valid divisor
 *   in the left half.
 * - Otherwise, search in the right half for a larger divisor.
 *
 * Time Complexity:
 * O(n * log(max(nums)))
 * - Finding the maximum element takes O(n).
 * - Binary Search performs O(log(max(nums))) iterations.
 * - In each iteration, calculating the sum takes O(n).
 *
 * Space Complexity:
 * O(1)
 */

public class FindTheSmallestDivisorGivenThreshold {

    static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        int ans = 0;

        for(int num : nums) {
            high = Math.max(high, num);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int divisor = calculateDivisor(nums, mid);

            if (divisor <= threshold) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    static int calculateDivisor(int[] nums, int divisor) {
        int sum = 0;

        for(int num : nums) {
            // division = (num + divisor - 1) / divisor;
            sum += Math.ceil((double)num / (double)divisor);
        }

        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {44,22,33,11,1};
        int threshold = 5;

        System.out.println(smallestDivisor(nums, threshold));
    }
}
