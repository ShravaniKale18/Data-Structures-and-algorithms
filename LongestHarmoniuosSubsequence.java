import java.util.HashMap;

class LongestHarmoniousSubsequnce {
    static int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);            
        }

        for(int key : map.keySet()) {
            if(map.containsKey(key + 1)) {
                count = map.get(key) + map.get(key + 1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(findLHS(nums));
    }
}