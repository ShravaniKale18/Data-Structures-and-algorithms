public class LongestIncreasingSubsequence {

    static int lengthOfLIS(int[] nums) {

        int maxLength = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                maxLength++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLIS(nums));
    }
}
