import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

    public static List<Integer> countSmaller(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            int count = 0;

            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[i]) {
                    count++;
                }
            }

            ans.add(count);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 1, 6};

        System.out.println(countSmaller(nums));
    }
}
