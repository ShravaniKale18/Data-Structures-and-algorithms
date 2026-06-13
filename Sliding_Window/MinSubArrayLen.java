//https://leetcode.com/problems/minimum-size-subarray-sum/

package Sliding_Window;

public class MinSubArrayLen {
    static int minSubArrayLen1(int target, int[] nums) {
        int length = 0, minLength = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if(sum == target) {
                    length = j - i + 1;
                    minLength = Math.min(minLength, length);
                }
            }

        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int low = 0;
        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while(sum >= target) {
                minLength = Math.min(minLength, right - low + 1);
                sum -= nums[low]; // shrink the window
                low++; // move the left pointer to the right
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    public static void main(String[] args) {
        int[] nums = {1,4,4};
        int target = 4;
        System.out.println(minSubArrayLen(target, nums));
    }
}
