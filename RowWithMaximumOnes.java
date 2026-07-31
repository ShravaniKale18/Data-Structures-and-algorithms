import java.util.Arrays;

public class RowWithMaximumOnes {

    /**
     * Approach:
     * - Traverse every row of the matrix.
     * - For each row, count the number of 1s.
     * - If the current row has more 1s than the maximum found so far,
     *   update maxOneCount and maxRow.
     * - Finally, return the row index and maximum number of 1s.
     *
     * TC -> O(m * n)
     * SC -> O(1)
     */
    static int[] rowAndMaximumOnes1(int[][] mat) {

        int currentOneCount = 0, maxRow=0, maxOneCount = 0;


        for (int i = 0; i < mat.length; i++) {

            currentOneCount = 0;

            for (int j = 0; j < mat[i].length; j++) {

                if (mat[i][j] == 1) {
                    currentOneCount++;
                }

                if (currentOneCount > maxOneCount) {
                    maxOneCount = currentOneCount;
                    maxRow = i;
                }
            }
        }

        return new int[]{maxRow, maxOneCount};
    }

    /**
     * Approach:
     * - Each row must be sorted in non-decreasing order:
     *   [0, 0, 0, 1, 1, 1]
     * - For every row, use Binary Search (Lower Bound)
     *   to find the first occurrence of 1.
     * - Number of 1s = number of columns - index of first 1.
     * - Keep track of the row having the maximum number of 1s.
     * - If no 1 is found, lowerBound returns arr.length,
     *   so the number of 1s becomes 0.
     *
     * TC -> O(m * log n)
     * SC -> O(1)
     */

    static int[] rowAndMaximumOnes(int[][] mat) {
        int max_cnt = - 1;
        int index = -1;
        int n = mat[0].length;

        for (int i = 0; i < mat.length; i++) {
            int cnt_ones = n - lowerBound(mat[i], 1);

            if (cnt_ones > max_cnt) {
                max_cnt = cnt_ones;
                index = i;
            }
        }

        return new int[] {index, max_cnt};
    }

    static int lowerBound(int[] arr, int x) {

        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
       int  mat[][] = {
        {0, 0, 0},
        {1, 1, 1},
        {0, 0, 1}
       };

       System.out.println(Arrays.toString(rowAndMaximumOnes(mat)));
    }
}
