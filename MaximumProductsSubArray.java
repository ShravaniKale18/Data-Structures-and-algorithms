public class MaximumProductsSubArray {

    static int maxProduct(int[] nums) {

        int maxProduct = nums[0];

        // for (int i = 0; i < nums.length; i++) {
        //     int current = 1;

        //     for (int j = i; j < nums.length; j++) {
        //         current *= nums[j];
        //         maxProduct = Math.max(maxProduct, current);
        //     }
        // }
        // return maxProduct;

        int suffix = 1;
        int prefix = 1;

        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) {
                prefix = 1;
            }

            if (suffix == 0) {
                suffix = 1;
            }

            suffix *= nums[i];
            prefix *= nums[nums.length - i - 1];

            maxProduct = Math.max(maxProduct, Math.max(suffix, prefix));
        }

        return maxProduct;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};

        System.out.println(maxProduct(nums));
    }
}
