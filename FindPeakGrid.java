import java.util.Arrays;
/**
 * Approach:
 *
 * - Initialize low and high pointers to the first and last column
 *   indices of the matrix.
 *
 * - While low <= high, calculate the middle column (midCol).
 *
 * - Find the row index of the maximum element in the middle column
 *   using the findPeakElement function.
 *
 * - Check whether this maximum element is greater than its left
 *   and right neighbors (if they exist). If it is, return its
 *   row and column indices.
 *
 * - If the maximum element is smaller than its left neighbor,
 *   move high to midCol - 1 and search in the left half.
 *
 * - Otherwise, if the maximum element is smaller than its right
 *   neighbor, move low to midCol + 1 and search in the right half.
 *
 * TC: O(n log m)
 *     Binary search on columns takes O(log m), and finding the
 *     maximum element in each column takes O(n).
 *
 * SC: O(1)
 *     Only a constant amount of extra space is used.
 */

public class FindPeakGrid {
    static int[] findPeakGrid(int[][] mat) {
        int low = 0;
        int high = mat[0].length - 1;

        while(low <= high) {
            int midCol = low + (high - low) / 2;

            int maxRow = findPeakRow(mat, midCol);

            if((midCol == 0 || mat[maxRow][midCol] > mat[maxRow][midCol - 1]) && (midCol == mat[0].length - 1 || mat[maxRow][midCol] > mat[maxRow][midCol + 1])) {
                return new int[] {maxRow, midCol};
            }else if(midCol == mat[0].length - 1 || mat[maxRow][midCol] < mat[maxRow][midCol - 1]) {
                high = midCol - 1;
            }else {
                low = midCol + 1;
            }
        }
        return new int[] {-1, -1}; // No peak found
    }


    static int findPeakRow(int[][] mat, int midCol) {
        int maxRow = 0;
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < mat.length; i++) {
            if(mat[i][midCol] > maxVal) {
                maxVal = mat[i][midCol];
                maxRow = i;
            }
        }
        return maxRow;
    }

    public static void main(String[] args) {
        int[][] mat = {{10,20,15},{21,30,14},{7,16,32}};

        System.out.println(Arrays.toString(findPeakGrid(mat)));
    }
}
