public class JumpGameProblem {

    /** 
     * TC -> O(n) where n is the length of the array
     * SC -> O(1) where n is the length of the array
     */

    static boolean canJump(int[] nums) {
        //to track the maximum index we can reach
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            //check if the current index is greater than the maximum reachable index
            if(i > maxReach) {
                return false;
            }

            //update the maximum reachable index
            maxReach = Math.max(maxReach, i + nums[i]);

            //check if we can reach the last index
            if(maxReach >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 4};
        System.out.println(canJump(nums));
    }
}
