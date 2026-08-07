import java.util.HashSet;

public class SubArraySumEqualsZero {

    /**
     * Approach:
     * Prefix Sum + HashSet
     *
     * TC: O(N)
     * SC: O(N)
     */

    static boolean subArraysSumEqualsZero1(int[] nums) {

        int[] prefixsum = new int[nums.length];
        HashSet<Integer> set = new HashSet<>();

        if(nums.length == 0) return false;

        prefixsum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixsum[i] = prefixsum[i - 1] + nums[i];
        }


        for (int i = 0; i < prefixsum.length; i++) {
            if (prefixsum[i] == 0) {
                return true;
            }

            if (set.contains(prefixsum[i])) {
                return true;
            }

            set.add(prefixsum[i]);
        }
        return false;
    }

    /** 
     * TC - O(N^2)
     * SC - O(1)
     */

    static boolean subArraysSumEqualsZero(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                

                if (sum == 0) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, -3, 1, 6};

        System.out.println(subArraysSumEqualsZero(nums));
    }
}
