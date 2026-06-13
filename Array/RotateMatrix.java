package Array;

import java.util.Collection;
import java.util.Collections;

public class RotateMatrix {

    static void rotate(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        int n = matrix.length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans[j][n-1-i] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }

        // System.out.println(Arrays.toString(ans));
    }


    static void rotate1(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                // if (i == j) {
                //     matrix[i][j] = matrix[i][j];
                // }else{
                    
                // }
                if (i > j) {
                    swap(matrix, i, j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix[i].length - 1;

            while (start < end) {
                swap1(matrix[i], start, end);
                start++;
                end--;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    static void swap1(int[] matrix, int i, int j) {
        int temp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = temp;
    }
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate1(mat);
    }
}
