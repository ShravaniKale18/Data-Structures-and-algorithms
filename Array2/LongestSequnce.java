package Array2;

import java.util.Arrays;

public class LongestSequnce {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1}; //Ans -> 4
        int ans = longestConsecutive(nums);
        System.out.println(ans);
    }

    static int longestConsecutive(int[] nums) {
        int maxCount = 1;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            count = 1;
            int ele = nums[i];
            while(search(nums, ele + 1) == true) {
                count++;
                ele += 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    static boolean search(int[] nums, int ele) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] ==  ele) {
                return true;
            }
        }
        return false;
    }
}
