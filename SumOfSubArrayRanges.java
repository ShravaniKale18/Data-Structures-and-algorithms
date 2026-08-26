public class SumOfSubArrayRanges {

    /**
     * Approach:
     *
     * 1. Generate all possible subarrays using two loops.
     *
     * 2. For each subarray, keep track of:
     *    - minimum element
     *    - maximum element
     *
     * 3. Calculate the range of the current subarray:
     *    range = max - min
     *
     * 4. Add the range to sum.
     *
     * 5. Return the total sum.
     *
     * TC => O(N^2)
     * SC => O(1)
     */

    static long subArrayRanges(int[] nums) {
        
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = i; j < nums.length; j++) {

                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                sum += max - min;

            }  
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {4,-2,-3,4,1};

        System.out.println(subArrayRanges(nums));
    }
}
