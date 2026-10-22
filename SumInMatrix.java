import java.util.Arrays;


/**
 * Approach:
 * 1. Initialize sum to 0.
 * 2. Sort every row in ascending order so the largest
 *    element is at the end of each row.
 * 3. Traverse each column and find its maximum element.
 * 4. Add each column maximum to sum.
 *
 * Time Complexity: O(m * n * log n)
 * Space Complexity: O(1) auxiliary space, excluding sorting implementation details.
 */


public class SumInMatrix {

    static int matrixSum(int[][] nums) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }

        for (int i = 0; i < nums[0].length; i++) {

            int maxElement = 0;
            for (int j = 0; j < nums.length; j++) {
                maxElement = Math.max(maxElement, nums[j][i]);
            }

            sum += maxElement;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] nums = {{7,2,1},{6,4,2},{6,5,3},{3,2,1}};

        System.out.println(matrixSum(nums));
    }
}
