public class SmallestStableIndex_I{
    static int firstStableIndex(int[] nums, int k) {
        int answer = -1;
        int n = nums.length;

        for(int i = 0; i < nums.length; i++) {

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int j = 0; j <= i; j++) {
                max = Math.max(max, nums[j]);
            }

            for(int j = i; j <= n - 1; j++) {
                min = Math.min(min, nums[j]);
            }

            answer = max - min;

            if(answer <= k) {
                return i; 
            }
        }

        return -1;   
    }


    public static void main(String[] args) {
        int[] nums = {5, 0, 1, 4};

        System.out.println(firstStableIndex(nums, 3));
    }
}