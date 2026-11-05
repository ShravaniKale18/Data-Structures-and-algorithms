package Recursion;
/** 
 * Approach: Recursion
 * 
 * Check if we can reach the last index of the array starting from the first index
 * Recursively call to jump from the current index to all possible indices within the jump value
 * If we reach the last index, return true
 * If we go out of bounds, return false
 * If we encounter a 0, return false as we cannot jump further
 * 
 * Time Complexity: O(2^n) where n is the length of the array
 * Space Complexity: O(n) where n is the length of the array
 */

public class JumpGameProblem {

    public static boolean canJump(int[] nums) {
        int index = 0;
        boolean ans = solve(nums, index);

        return ans;
    }

    public static boolean solve(int[] nums, int index) {

        if(index == nums.length - 1) {
            return true;
        }

        if(index >= nums.length) {
            return false;
        }

        if(nums[index] == 0) {
            return false;
        }

        int jumpValue = nums[index];
        boolean overallAns = false;

        for(int jump = 1; jump <= jumpValue; jump++) {
            boolean recAns = solve(nums, index + jump);
            overallAns = overallAns || recAns;
        }

        return overallAns;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

}
