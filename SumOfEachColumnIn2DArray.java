import java.util.ArrayList;

/**
 * Approach:
 * 1. Initialize an empty ArrayList to store column sums.
 * 2. Traverse each column of the matrix.
 * 3. Initialize colSum to 0 for each column.
 * 4. Traverse all rows and add the elements of the current column.
 * 5. Add the calculated column sum to the result list.
 * 6. Return the result list.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(n) for storing column sums.
 * where m = number of rows and n = number of columns.
 */

public class SumOfEachColumnIn2DArray {

    static ArrayList<Integer> calculateSum(int[][] mat) {

        ArrayList<Integer> ansList = new ArrayList<>();

        for (int i = 0; i < mat[0].length; i++) {
            int colSum = 0;

            for (int j = 0; j < mat.length; j++) {
                colSum += mat[j][i];
            }

            ansList.add(colSum);
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

        System.out.println("Column Sum = "+ans);
    }
}
