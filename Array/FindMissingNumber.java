package Array;

import java.util.Arrays;

import Recursion.reverseArray;

public class FindMissingNumber {
    static int findDuplicatedNumber(int[] nums) {

        int[] freq = new int[nums.length];
        int duplicated = 0;

        for (int i = 0; i < nums.length; i++) {
            if(freq[nums[i]] == 0) {
                freq[nums[i]] += 1; 
            }else {
                duplicated = nums[i];
            }
        }

        return duplicated;
    }

    static int findMissingNumber(int[] nums) {
        int n = nums.length;

        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int i = 0; i < nums.length; i++) {
            actualSum += nums[i];
        }

        return expectedSum - actualSum;
    }
     public static void main(String[] args) {
        int[] nums = {1, 3, 3, 4, 5};
        int missing = findMissingNumber(nums);
        int dup = findDuplicatedNumber(nums);
        
        System.out.println(missing+" "+dup);
    }
}
