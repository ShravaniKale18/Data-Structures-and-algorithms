import java.util.HashMap;

public class LongestLengthSubArrayWithSumK {

    /** 
     * TC => O(N^2)
     * SC => O(1)
     */

    static int longestSubarray1(int[] nums, int k) {
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int subArraySum = 0, length = 0;

            for (int j = i; j < nums.length; j++) {
                subArraySum += nums[j];

                if (subArraySum == k) {
                    length = j - i + 1;
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }

    /** 
     * TC => O(N)
     * SC => O(N)
     */

    static int longestSubarray(int[] nums, int k) {

        int maxLength = 0;
        int[] prefixsum = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        prefixsum[0] = nums[0];

        for (int i = 1; i < prefixsum.length; i++) {
            prefixsum[i] = prefixsum[i - 1] + nums[i];
        }

        for (int i = 0; i < prefixsum.length; i++) {
            if (map.containsKey(prefixsum[i] - k)) {

                int length = i - map.get(prefixsum[i] - k);
                maxLength = Math.max(maxLength, length);
            }
            if (!map.containsKey(prefixsum[i])) {
                map.put(prefixsum[i], i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, -10};
        int k = 15;

        System.out.println(longestSubarray(nums, k));
        
    }
}
