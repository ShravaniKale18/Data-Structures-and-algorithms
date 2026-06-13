package Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMAtrix {

    static void spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;

        while (top <= bottom && left <= right) {

            // top row
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            // right column
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            // bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        System.out.println(list);
    }
    

    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        spiralOrder(matrix);
    }
}