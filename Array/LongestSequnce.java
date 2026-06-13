package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LongestSequnce {
    public static void main(String[] args) {
        int[] nums = {100,102,100,101,101,4,3,2,3,2,1,1,1,2};
        longestConsecutive(nums);
    }

    static void longestConsecutive(int[] nums) {
        Set<Integer> ans = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            ans.add(nums[i]);
        }

        List<Integer> list= new ArrayList<>(ans);
        int prev = list.get(0);
        int count = 1;
        int maxCount = 1;

        for (Integer num : list) {
            
            int current = num;
            if (current == prev+1) {
                count++;
            }else{
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
            prev = current;
        }
        System.out.println(maxCount);
    }
}
