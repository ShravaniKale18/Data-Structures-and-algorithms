package Array;

import java.util.Arrays;

public class RearrangePosNeg {
    static int[] rearrangeArray(int[] nums) {
        int pos = 0;
        int neg = 1;
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[pos] = nums[i];
                pos+=2;
            }else{
                ans[neg] = nums[i];
                neg += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        int[] ans = rearrangeArray(nums);
        System.out.print(Arrays.toString(ans));
    }
}
