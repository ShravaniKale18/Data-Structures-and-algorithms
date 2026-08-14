public class MinimumSizeSubarraySum {

    static int minSubArrayLen1(int target, int[] nums) {
        
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;
            for (int j = i; j < nums.length; j++) {

                sum += nums[j];

                if (sum >= target) {
                    int length = j - i + 1;
                    minLength = Math.min(minLength, length);
                    break;
                }
            }
        }

        return minLength;
    }

    static int minSubArrayLen(int target, int[] nums) {

        int sum = 0;
        int i = 0;
        int minLength = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {

            sum += nums[j];

            while (sum >= target) {

                int length = j - i + 1;
                minLength = Math.min(minLength, length);

                sum -= nums[i];
                i++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};

        System.out.println(minSubArrayLen(target, nums));
    }
}
