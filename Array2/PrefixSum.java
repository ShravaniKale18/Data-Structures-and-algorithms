package Array2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

public class PrefixSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        sum(nums, 2);
    }

    static void sum(int[] nums, int k) {
        int prefixsum[] = new int[nums.length];

        prefixsum[0] = nums[0];
        for (int i = 1; i < prefixsum.length; i++) {
            prefixsum[i] = prefixsum[i - 1] + nums[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            
        }

        for (int i = 0; i < prefixsum.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                
            }
        }
        
    }
}
