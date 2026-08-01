import java.util.Arrays;

public class MedianInRowWiseSortedMatrix {
    /** 
     * Finds the median of a row-wise sorted matrix.
     * create a merged array of all the elements in the matrix and sort it.
     * If the length of the merged array is even, return the average of the two middle elements.
     * If the length of the merged array is odd, return the middle element. 
     * 
     * TC: O(m*n log(m*n)) where m is the number of rows and n is the number of columns in the matrix.
     * SC: O(m*n) for the merged array.
     */
    static int findMedian1(int matrix[][], int m, int n) {

        int[] mergedArray = new int[m * n];
        int index = 0;
        
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                mergedArray[index++] = matrix[i][j];
            }
        }

        Arrays.sort(mergedArray);
        
        if(mergedArray.length % 2 == 0) {
            return (mergedArray[mergedArray.length / 2 - 1] + mergedArray[mergedArray.length / 2]) / 2;
        } else {
            return mergedArray[mergedArray.length / 2];
        }
    }
    
    /**
     * Approach:
     * - Apply binary search on the possible value range of the matrix.
     * - Initialize low with the minimum possible value and high with the
     *   maximum possible value.
     * - For every mid value, count how many elements in the matrix are
     *   less than or equal to mid.
     * - Since every row is sorted, binary search can be used in each row
     *   to find the number of elements <= mid.
     * - If the count is less than or equal to half of the total elements,
     *   the median lies on the right side, so move low to mid + 1.
     * - Otherwise, the median may lie on the left side, so move high
     *   to mid - 1.
     * - Finally, low will represent the median.
     *
     * TC: O(32 * m * log(n))
     *     32 iterations for the integer value range, and for each
     *     iteration we perform binary search on every row.
     *
     * SC: O(1)
     *     Only constant extra space is used.
     */
    static int findMedian(int[][] matrix, int m, int n) {

        int low = matrix[0][0];
        int high = matrix[m - 1][n - 1];

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int smallerCount = findSmallerCount(matrix, mid);

            if(smallerCount <= (m * n) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return low; 
    }

    static int findSmallerCount(int[][] matrix, int mid) {
        int count = 0;

        for(int i = 0; i < matrix.length; i++) {
            int j = matrix[i].length - 1;

            while(j >= 0 && matrix[i][j] > mid) {
                j--;
            }

            count += j + 1;
        }
        return count;
    }
    

    public static void main(String[] args) {
        int matrix[][] = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};

        int m = matrix.length;
        int n = matrix[0].length;

        System.out.println(findMedian(matrix, m, n));
    }
}
