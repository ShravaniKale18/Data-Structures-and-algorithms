package Array;
import java.util.ArrayList;
import java.util.List;

public class FourSum {
    static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j =  i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if ((nums[i] + nums[j] + nums[k] + nums[l]) == target) {
                            List<Integer> list = new ArrayList<>();

                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);

                            ans.add(list);
                        }
                    }
                }
                
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        List<List<Integer>> ans = fourSum(nums, 0);
        System.out.println(ans);
    }
}
