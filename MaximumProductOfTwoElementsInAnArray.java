public class MaximumProductOfTwoElementsInAnArray {

    static int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            }else if (num > max2) {
                max2 = num;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(maxProduct(nums));
    }
}
