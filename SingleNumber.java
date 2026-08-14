public class SingleNumber {

    public static int occursOnce(int[] a, int n) {
        int ans  = 0;
        for (int i = 0; i < n; i++) {
            ans = ans ^ a[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {7, 3, 5, 4, 5, 3, 4};
        int n = nums.length;

        System.out.println(occursOnce(nums, n));
    }
}
