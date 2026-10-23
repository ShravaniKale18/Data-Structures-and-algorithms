import java.util.ArrayList;
import java.util.List;

/**
 * Approach:
 * 1. Initialize four boundaries: startRow, startCol, endRow, and endCol.
 * 2. Traverse the first row from left to right and increment startRow.
 * 3. Traverse the last column from top to bottom and decrement endCol.
 * 4. If rows remain, traverse the last row from right to left and decrement endRow.
 * 5. If columns remain, traverse the first column from bottom to top and increment startCol.
 * 6. Repeat until the row or column boundaries cross.
 * 7. Store each visited element in the answer list.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1) auxiliary space, excluding the output list.
 */

public class SpiralPrintOfMatrix {

    static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {

            // Left to Right
            for (int j = startCol; j <= endCol; j++) {
                ans.add(matrix[startRow][j]);
            }
            startRow++;

            // Top to Bottom
            for (int i = startRow; i <= endRow; i++) {
                ans.add(matrix[i][endCol]);
            }
            endCol--;

            // Right to Left
            if (startRow <= endRow) {
                for (int j = endCol; j >= startCol; j--) {
                    ans.add(matrix[endRow][j]);
                }
                endRow--;
            }

            // Bottom to Top
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    ans.add(matrix[i][startCol]);
                }
                startCol++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        List<Integer> ans = spiralOrder(matrix);
        System.out.println(ans);
    }
}