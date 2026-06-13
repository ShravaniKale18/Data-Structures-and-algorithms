package Array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NextPermutations {
    static void nextPermutation(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getPerm(nums, 0, ans);
        // Collections.sort(ans);

    }

    static void getPerm(int[] nums, int idx, List<List<Integer>> ans) {
        if(idx == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for(int num : nums) {
                temp.add(num);
            }
            ans.add(temp);
            return;
        }

        for(int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            getPerm(nums, idx + 1, ans);
            swap(nums, i, idx);
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =  temp;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; 
        // List<List<Integer>> ans = nextPermutation(nums);
        // System.out.println(ans);
        nextPermutation(nums);
    }
}
