public class MaximumSubArraySumEqualsK {

    static int maxSubarraySum(int[] arr, int k) {
        int maxSum = 0;

        for (int i = 0; i <= arr.length - k; i++) {
            int currSum = 0;

            for (int j = 0; j < k; j++) {
                currSum += arr[i + j];
            }

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }


    public static void main(String[] args) {
        int[] arr = {100, 200, 300, 400};
        int k = 2;

        System.out.println(maxSubarraySum(arr, k));
    }
}
