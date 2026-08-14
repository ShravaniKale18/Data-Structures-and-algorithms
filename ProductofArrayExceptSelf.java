import java.util.Arrays;

/**
 * Approach:
 * Use the Prefix Product + Suffix Product technique.
 *
 * 1. First pass:
 *    Store the product of all elements to the left of each index
 *    in the answer array.
 *
 * 2. Second pass:
 *    Traverse from right to left and maintain a suffix product.
 *    Multiply the prefix product with the suffix product to get
 *    the product of all elements except nums[i].
 *
 * TC: O(n)
 * SC: O(1) auxiliary space
 */

public class ProductofArrayExceptSelf {

    static int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        answer[0] = 1;

        for(int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int suffix = 1;

        for(int i = nums.length - 1; i >= 0; i--) {

            answer[i] *= suffix;
            suffix *= nums[i];

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
