/**
 * Approach:
 * 1. Calculate the number of rows and columns.
 * 2. Create a new matrix with dimensions col x row.
 * 3. Traverse the original matrix using nested loops.
 * 4. Swap the row and column indices while copying elements.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

public class TransposeOfMatrix {

    static int[][] transpose(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] transpose = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] transpose = transpose(matrix);

        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[0].length; j++) {
                System.out.print(transpose[i][j]+" ");
            }

            System.out.println();
        }
    }
}
