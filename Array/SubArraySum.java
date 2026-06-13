package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class SubArraySum {

    static int subarraySum(int[] nums, int k) {
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 3;
        // int ans = subarraySum(arr, k);
        // System.out.println(ans);
        int maxLength = 0;

        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        System.out.println(maxLength);
    }
}
