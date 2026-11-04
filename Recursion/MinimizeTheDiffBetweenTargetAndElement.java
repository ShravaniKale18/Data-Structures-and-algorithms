package Recursion;

/** 
 * Approach:
 * Base check:
 * check wheather the current index is greater than or equal to the length of the matrix,
 *  if yes then return the absolute value of the target.
 * 
 * Recursive check:
 * 1. Initialize a variable mini to Integer.MAX_VALUE.
 * 2. Iterate through the elements of the current row of the matrix.
 * 3. For each element, recursively call the solve function with the updated target 
 *     (target - current element) and the next index (index + 1).
 * 4. Update mini with the minimum value between mini and the result of the recursive call.
 * 5. Return mini
 * 
 * Time Complexity = O(N ^M)
 * Space Complexity = O(M)
 */

public class MinimizeTheDiffBetweenTargetAndElement {

    public static int minimizeTheDifference(int[][] mat, int target) {

        int index = 0;
        int minDiff = solve(mat, target, index);

        return minDiff;
    }

    public static int solve(int[][] mat, int target, int index) {
        if(index >= mat.length) {
            return Math.abs(target);
        }

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < mat[0].length; i++) {
            int currentMinDiff = solve(mat, target - mat[index][i], index + 1);

            if(currentMinDiff < mini) {
                mini = currentMinDiff;
            }
        }

        return mini;
    }
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int target = 13;

        int minDiff = minimizeTheDifference(mat, target);

        System.out.println("Minimum Difference: "+minDiff);
    }
}
