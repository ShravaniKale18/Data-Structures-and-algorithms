package Recursion;

/** 
 * Approach:
 * 1. We can use recursion to solve the house robber problem.
 * 2. At each house, we have two choices: either rob the current house and skip the next one, or skip the current house and move to the next one.
 * 3. We can use a base case to stop the recursion when we reach the end of the array.  
 * 4. Finally, we can return the maximum of the two choices.
 * 
 * Time complexity: O(2^n) where n is the length of the array. This is because for each house, we have two choices: rob it or skip it.
 * Space complexity: O(n) for the recursion stack.
 */
public class HouseRobberProblem {
    public static int rob(int[] nums) {
        int ans = solve(nums, 0);

        return ans;
    }

    public static int solve(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        //include
        int includeAns = solve(nums, index + 2);
        //exclude
        int excludeAns = solve(nums, index + 1);

        return Math.max(includeAns, excludeAns);
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int ans = rob(nums);
        System.out.println(ans);
    }
}
