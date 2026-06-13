package Array2;

import java.util.Arrays;

public class SquareOfSortedArray {
    static int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            }
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] ans = sortedSquares(nums);
        System.out.println(Arrays.toString(ans));
    }
}
