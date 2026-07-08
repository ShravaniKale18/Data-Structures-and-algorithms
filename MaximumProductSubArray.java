public class MaximumProductSubArray {

    /*

    Approach:
    1. Consider every index as the starting point of a subarray.
    2. Initialize currentProduct = 1.
    3. Extend the subarray one element at a time by multiplying the current element.
    4. Update the maximum product after every multiplication.
    5. Return the maximum product found.

    Time Complexity:
    O(N²)
    - Two nested loops generate all possible subarrays.

    Space Complexity:
    O(1)
    - Only a few variables are used.
    */

    static int maxProduct1(int[] nums) {

        int maximumProduct = nums[0];
        int currentProduct = nums[0];

        for (int i = 0; i < nums.length; i++) {
            currentProduct = 1;
            for (int j = i; j < nums.length; j++) {
                currentProduct *= nums[j];
                maximumProduct = Math.max(maximumProduct, currentProduct);
            }
        }

        return maximumProduct;
    }

    /*
    
    Optimal Approach (Prefix and Suffix Product)

    Approach:
    1. Maintain two running products:
    - Prefix Product (left to right)
    - Suffix Product (right to left)
    2. If either product becomes 0, reset it to 1 because a subarray cannot continue through zero.
    3. At every index:
    - Multiply the current element with the prefix product.
    - Multiply the current element from the end with the suffix product.
    4. Update the maximum product using the larger of:
    - Prefix Product
    - Suffix Product
    5. Return the maximum product.

    Why Prefix and Suffix?
    - A negative number can turn the largest product into the smallest.
    - An even number of negative numbers gives a positive product.
    - By traversing from both directions, we automatically consider cases where
    removing either the prefix or suffix negative element produces the maximum product.

    Time Complexity:
    O(N)
    - Single traversal of the array.

    Space Complexity:
    O(1)
    - Only prefix, suffix, and answer variables are used.
    */
    static int maxProduct(int[] nums) {

        int n = nums.length;

        int maximumProduct = nums[0];
        int suffix = 1, 
            prefix = 1;

        for (int i = 0; i < n; i++) {
            if (suffix == 0) {
                suffix = 1;
            }

            if (prefix == 0) {
                prefix = 1;
            }

            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i - 1];
            maximumProduct = Math.max(maximumProduct, Math.max(suffix, prefix));
        }

        return maximumProduct;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int ans = maxProduct(nums);
        System.out.println(ans);
    }
}
