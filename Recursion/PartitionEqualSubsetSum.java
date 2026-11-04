package Recursion;

/** 
 * Approach: Recursion
 * 
 * Calculate total target sum
 * Check if target sum is odd, if yes return false
 * Then check if targetSum / 2 can be formed using the elements of the array
 * Recursively call to include the current element and exclude the current element
 * If targetSum becomes 0, return true
 * If index becomes greater than or equal to the length of the array, return false
 * 
 * Time Complexity: O(2^n) where n is the length of the array
 * Space Complexity: O(n) where n is the length of the array
 */

public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int index = 0;
        int targetSum = 0;

        for (int i = 0; i < nums.length; i++) {
            targetSum += nums[i]; 
        }

        if(targetSum % 2 != 0) {
            return false;
        }

        boolean ans = solve(nums, index, targetSum / 2);
        return ans;
    }

    public static boolean solve(int[] nums, int index, int targetSum) {
        
        if(index >= nums.length) {
            return false;
        }

        if(targetSum == 0) {
            return true;
        }

        return solve(nums, index + 1, targetSum - nums[index]) || solve(nums, index + 1, targetSum);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}
