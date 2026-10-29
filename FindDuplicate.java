import java.util.HashMap;

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};

        int duplicate = findDuplicate(nums);
        
        if(duplicate != -1) {
            System.out.println("The duplicate number is: " + duplicate);
        } else {
            System.out.println("No duplicate number found.");
        }
    }
}
