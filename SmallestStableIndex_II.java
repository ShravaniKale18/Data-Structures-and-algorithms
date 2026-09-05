public class SmallestStableIndex_II{

    static int firstStableIndex1(int[] nums, int k) {
        
        for(int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int j = 0; j <= i; j++) {
                max = Math.max(max, nums[j]);
            }

            for(int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
            }

            if((max - min) <= k) {
                return i;
            }
        }

        return -1;
    }

    static int firstStableIndex(int[] nums, int k){
        int n = nums.length;

        int[] suffixMin = new int[n];

        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            max = Math.max(max, nums[i]);
            int min = suffixMin[i];

            if (max - min <= k) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,0,1,4};
        int k = 3;

        System.out.println(firstStableIndex1(nums, k));
    }
}