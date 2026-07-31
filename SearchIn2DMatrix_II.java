public class SearchIn2DMatrix_II {
    /**
     * Approach:
     * Perform linear search on every element of the matrix.
     *
     * TC - O(N * M)
     * SC - O(1)
     */

    static boolean searchMatrix1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Approach:
     * Since every row is sorted, perform binary search
     * on each row.
     *
     * TC - O(N * log M)
     * SC - O(1)
     */
    
    static boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            boolean index = binarySearch(matrix[i], target);

            if (index == true) {
                return true;
            }
        }

        return false;
    }

    static boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return true;
            }else if (target > arr[mid]) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30}
        };

        int target = 35;

        System.out.println(searchMatrix(matrix, target));
    }
}
