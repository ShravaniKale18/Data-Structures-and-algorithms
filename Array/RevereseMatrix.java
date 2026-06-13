package Array;

public class RevereseMatrix {
    static void rotateMatrix(int[][] matrix) {

        //Transpose of a Matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                swap(matrix, i, j);
            }
        }

        int start = 0;
        int end = matrix.length - 1;

        //Reverse each Row
        for (int i = 0; i < matrix.length; i++) {
            while (start < end) {
                swapEle(matrix[i], start, end);
                start++;
                end--;
            }
        }
    }

    static void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    static void swapEle(int[] matrix, int i, int j) {
        int temp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = temp;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    }
}
