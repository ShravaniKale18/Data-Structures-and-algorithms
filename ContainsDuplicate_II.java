import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate_II {

    static boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int previousIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                previousIndex = map.get(nums[i]);

                if (i - previousIndex <= k) {
                    return true;
                }
            }

            map.put(nums[i],i);
        }

        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        int k = 3;

        System.out.println(containsNearbyDuplicate(arr, k));
    }
}
