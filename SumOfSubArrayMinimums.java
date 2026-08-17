import java.util.ArrayList;

public class SumOfSubArrayMinimums {

    static int sumSubarrayMins1(int[] nums) {

        ArrayList<ArrayList<Integer>> subArrayList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                ArrayList<Integer> list = new ArrayList<>();

                for (int k = i; k <= j; k++) {
                    list.add(nums[k]);
                }
                subArrayList.add(list);
            }
        }

        int sum = 0;
        int MOD = 1_000_000_007;
       
        for (int i = 0; i < subArrayList.size(); i++) {

            int min = Integer.MAX_VALUE;

            for(int num : subArrayList.get(i)) {
                min = Math.min(min, num);
            }
            sum = (sum + min) % MOD;
        }

        return sum;
    }

    static int sumSubarrayMins(int[] nums) {
        int sum = 0;
        int MOD = 1_000_000_007;

        for (int i = 0; i < nums.length; i++) {

            int min = Integer.MAX_VALUE;

            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                sum = (sum + min) % MOD;
            }
        }
        return sum;
    }

    
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};

        // System.out.println(sumSubarrayMins(arr));
        System.out.println(sumSubarrayMins(arr));
    }
}
