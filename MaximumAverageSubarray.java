//TC: O(n)
//SC: O(1)

public class MaximumAverageSubarray {
    static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double maxAvg = Double.MIN_VALUE;
        int low = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(i >= k - 1) {
                double avg = (double) sum / k;
                maxAvg = Math.max(maxAvg, avg);
                sum = sum - nums[low];
                low++;
            }
        }
        return maxAvg;
    }
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
}
