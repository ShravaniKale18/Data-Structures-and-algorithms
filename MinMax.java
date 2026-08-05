import java.util.Arrays;

/**
 * Approach:
 *
 * - Initialize min with the possible maximum value.
 * - Initialize max with the possible minimum value.
 * - Traverse through the array.
 * - For each element:
 *      - Update min using Math.min().
 *      - Update max using Math.max().
 * - Return both min and max in an array.
 *
 * TC => O(N)
 *       We traverse the array only once.
 *
 * SC => O(1)
 *       No extra space is used apart from the result array.
 */

public class MinMax {

    public static int[] maxMin(int[] arr) {
		
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        return new int[]{min, max};

	}

    public static void main(String[] args) {
        int[] arr = {1, 45, 6, 389, 4};

        System.out.println(Arrays.toString(maxMin(arr)));
    }
}
