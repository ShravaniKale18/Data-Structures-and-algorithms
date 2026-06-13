package Array;
import java.util.ArrayList;
import java.util.List;

public class MajorityElement_2 {

    static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int element1 = 0, element2 = 0;
        int count1 = 0, count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0) {
                count1 = 1;
                element1 = nums[i];
            }else if (count2 == 0) {
                count2 = 1;
                element2 = nums[i];
            }else if(element1 == nums[i]) {
                count1++;
            }else if(element2 == nums[i]){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (element1 == nums[i]) {
                cnt1++;
            }else{
                cnt2++;
            }
            if (cnt1 > (nums.length / 3)) {
                ans.add(element1);
            }
            if(cnt2 > (nums.length / 3)){
                ans.add(element2);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        List<Integer> ans = majorityElement(nums);
        System.out.println(ans);
    }
}
