package Array;

public class MaximunSubArraySum {
    static int maxSubArray(int[] nums) {
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    static long maxSubArray1(int[] nums) {
        long current_sum = nums[0];
        long maxSum = nums[0];

        if (nums.length == 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            current_sum = Math.max(nums[i], current_sum+nums[i]);
            maxSum = Math.max(maxSum, current_sum);
        }
        long ans = (maxSum > 0)?maxSum:0;
        return ans;
    }

    public static void main(String[] args) {
        // int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {10, 20, -30, 40, -50, 60};
        // int[] nums = {-7, -8, -16, -4, -8, -5, -7, -11, -10, -12, -4, -6, -4, -16, -10 };
        long ans = maxSubArray1(nums);
        System.out.println(ans);
        // for (int i = 0; i < nums.length; i++) {
        //     int sum = 0;
        //     for (int j = i; j < nums.length; j++) {
        //         sum += nums[j];
        //         System.out.print(sum+" ");
        //     }
        //     System.out.println();
        // }
        

    }

}
