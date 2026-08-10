

public class MaximumAverageSubarray1{

    /**
     * Approach
     *
     * - Loop through the array till i <= nums.length - k
     * - Another loop through j = i to j <= i + k - 1
     * - Calculate the sum of k elements
     * - Calculate the average and update maxAverage
     * - Return maxAverage
     *
     * TC = O(N * K)
     * SC = O(1)
     */

    static double findMaxAverage1(int[] nums, int k) {
        double sum = 0;
        double maxAverage = Double.NEGATIVE_INFINITY;

        for (int i = 0; i <= nums.length - k; i++) {
            sum = 0;
            for (int j = i; j <= i + k - 1; j++) {
                sum += nums[j];
            }
            maxAverage = Math.max(maxAverage, sum / k);
        }

        return maxAverage;
    }

    /**
     * Approach:
     *
     * - Use the Sliding Window technique.
     * - First, calculate the sum of the first k elements.
     * - Store the average of the first window as maxAverage.
     * - Then slide the window one position at a time:
     *      - Remove the element going out of the window.
     *      - Add the new element coming into the window.
     * - Calculate the average of the current window.
     * - Update maxAverage if the current average is greater.
     *
     * Example:
     * nums = [1, 12, -5, -6, 50, 3], k = 4
     *
     * First window:
     * [1, 12, -5, -6] -> sum = 2
     
     * Next window:
     * [12, -5, -6, 50]
     * sum = 2 - 1 + 50 = 51
     
     * This avoids recalculating the sum of k elements for every window.
     *
     * TC = O(N)
     * SC = O(1)
     */

    static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double maxAverage = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        maxAverage = sum / k;

        for (int i = 0; i < nums.length - k; i++) {

            sum = sum - nums[i] + nums[i + k];
            maxAverage = Math.max(maxAverage, sum / k);
        }

        return maxAverage;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        System.out.println(findMaxAverage(nums, k));
    }
}