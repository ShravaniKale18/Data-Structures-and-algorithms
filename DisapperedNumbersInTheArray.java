import java.util.*;

public class DisapperedNumbersInTheArray{
    static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
       int[] nums = {4,3,2,7,8,2,3,1};

       System.out.println(findDisappearedNumbers(nums));
    }
}