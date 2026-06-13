package Array;

import java.util.Arrays;

public class TwoDArray {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{1,8,9,95}};

        for (int[] ele : arr) {
            System.out.println(Arrays.toString(ele));
        }
    }
}
