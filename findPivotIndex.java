public class findPivotIndex {
    /*
     * Approach:
     * 1. Initialize leftSum to 0.
     * 2. Calculate the total sum of the array.
     * 3. For each index, calculate rightSum:
     *    rightSum = totalSum - leftSum - nums[i]
     * 4. If leftSum == rightSum, return the current index.
     * 5. Otherwise, add nums[i] to leftSum and continue.
     * 6. If no pivot index is found, return -1.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }else{
                leftSum += nums[i];
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};

        System.out.println("Peak Index = "+pivotIndex(arr));
    }
}
