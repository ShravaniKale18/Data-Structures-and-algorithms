public class SearchIn2DMatrix {
    static boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = n * m - 1; //calculates the total size of the array;


        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m; // finds the row 
            int col = mid % m; //finds the column

            if (matrix[row][col] == target) {
                return true;
            }else if (matrix[row][col] > target) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }
}
