package Array;

import java.util.Arrays;

public class FindMissingandRepeated {
    public static int[] findRepeatingAndMissingNumbers(int[] nums) {
        int repeated = -1;
        int missing = -1;
        int[] freq = new int[nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0) {
                missing = i;
            }
            if (freq[i] == 2) {
                repeated = i;
            }
        }
    	return new int[]{repeated, missing};
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5};
        int[] ans = findRepeatingAndMissingNumbers(arr);
        System.out.println(Arrays.toString(ans));
    }
}
