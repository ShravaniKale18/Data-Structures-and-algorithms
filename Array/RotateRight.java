package Array;

import java.util.Arrays;

public class RotateRight {

    static void rotate(int[] nums, int k) {
        int[] temp = new int[k];
        int index = 0;

        for (int i = nums.length - k; i < nums.length; i++) {
            temp[index++] = nums[i];
        }

        for(int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i-k];
        }
        for(int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }

        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 2;

        rotate(nums, k);
    }
}
