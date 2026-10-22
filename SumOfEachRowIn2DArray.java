import java.util.ArrayList;

/**
 * Approach:
 * 1. Initialize an empty ArrayList to store row sums.
 * 2. Traverse each row of the 2D array.
 * 3. Initialize rowSum to 0 for each row.
 * 4. Traverse every element in the current row and add it to rowSum.
 * 5. Add the rowSum to the result list.
 * 6. Return the result list.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m) for storing row sums.
 * where m = number of rows and n = number of columns.
 */

public class SumOfEachRowIn2DArray {

    static ArrayList<Integer> calculateSum(int[][] mat) {

        ArrayList<Integer> ansList = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            int rowSum = 0;

            for (int j = 0; j < mat[i].length; j++) {
                rowSum += mat[i][j];
            }

            ansList.add(rowSum);
        }

        return ansList;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 7, 8}
        };
        
        ArrayList<Integer> ans = calculateSum(mat);

        System.out.println("Row Sum = "+ans);
    }
}
