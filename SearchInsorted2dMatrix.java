import java.util.Arrays;

/** 
 * Approach:
 * Start from the top-right corner of the matrix.
 * If the current element is equal to the target, return its position.
 * If the current element is greater than the target, move left.
 * If the current element is less than the target, move down.
 * 
 * Time Complexity: O(m + n) where m is the number of rows and n is the number of columns.
 * Space Complexity: O(1)
 */
public class SearchInsorted2dMatrix {

    static int[][] searchElement(int [][]MATRIX, int target) {
        
        for(int i = 0; i < MATRIX.length; i++) {
            if(search(MATRIX[i], target)) {
                return new int[][] { MATRIX[i], new int[] {i} };
            }
        }

        return null;
    }


    static boolean search(int[] mat, int target) {

        int low = 0;
        int high = mat.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(mat[mid] == target) {
                return true;
            }else if(mat[mid] > target) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        
        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };

        int target = 5;
        int[][] result = SearchInsorted2dMatrix.searchElement(matrix, target);

        if (result != null) {
            System.out.println("Element found!" + Arrays.toString(result[0]) + " at row " + result[1][0]);
        } else {
            System.out.println("Element not found!");
        }
    }
}
