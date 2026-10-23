public class RotateImage {

    /**
     * Approach:
     * 1. Transpose the matrix in-place.
     * 2. Reverse every row to rotate the matrix 90 degrees clockwise.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */

    static int[][] rotate(int[][] matrix) {
        
        int n = matrix.length;

        int[][] rotatedMatrix = transpose(matrix);

        for (int k = 0; k < n; k++) {
            reverseRow(rotatedMatrix[k]);
        }

        return rotatedMatrix;
    }

    static int[][] transpose(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                swap(matrix, i, j);
            }
        }

        return matrix;
    }

    static void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    static void reverseRow(int[] matRow) {
        int left = 0;
        int right = matRow.length - 1;

        while (left < right) {
            int temp = matRow[left];
            matRow[left] = matRow[right];
            matRow[right] = temp;

            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] result = rotate(matrix);

        for (int[] row : result) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}
