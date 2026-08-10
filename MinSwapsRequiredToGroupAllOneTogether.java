/**
 * Approach:
 *
 * - Count the total number of 1s.
 * - Use the total number of 1s as the window size.
 * - Find the maximum number of 1s present in any circular window.
 * - Use modulo (%) to handle the circular nature of the array.
 * - The number of zeros inside the best window represents
 *   the minimum number of swaps required.
 *
 * TC => O(N)
 * SC => O(1)
 */

public class MinSwapsRequiredToGroupAllOneTogether {

    static int minSwaps(int[] nums) {
        int ones = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones++;
            }
        }

        int windowSize = ones;
        int maxOnes = 0, currentOnes = 0;

        for (int i = 0; i < windowSize; i++) {
            if (nums[i] == 1) {
                currentOnes++;
            }
        }

        maxOnes = currentOnes;


        for (int i = 0; i < nums.length; i++) {
            currentOnes = currentOnes - nums[i] + nums[(i + windowSize) % nums.length];
            maxOnes = Math.max(maxOnes, currentOnes);
        }

        return windowSize - maxOnes;
    }


    public static void main(String[] args) {
        // int[] nums = {0,1,0,1,1,0,0};
        int[] nums = {0,1,1,1,0,0,1,1,0};

        System.out.println(minSwaps(nums));
    }
}
