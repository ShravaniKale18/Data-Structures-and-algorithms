import java.util.ArrayList;


/**
 * Approach:
 * 1. Initialize a boolean variable topToBottom as true
 *    to track the traversal direction.
 * 2. Create an ArrayList to store the wave traversal.
 * 3. Traverse the matrix column by column.
 * 4. If topToBottom is true, traverse the current column
 *    from the first row to the last row.
 * 5. Otherwise, traverse the current column from the last
 *    row to the first row.
 * 6. Toggle the direction after processing each column.
 * 7. Return the result list.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1) auxiliary space,
 *                   excluding the result list.
 * Result Space: O(m * n)
 *
 * where m = number of rows and n = number of columns.
 */

public class WavePrintMatrix {

    public static ArrayList<Integer> wavePrint(int arr[][]) {

		boolean topToBottom = true;

        ArrayList<Integer> ans = new ArrayList<>();

        for (int col = 0; col < arr[0].length; col++) {
            if (topToBottom) {
                for (int i = 0; i < arr.length; i++) {
                    ans.add(arr[i][col]);
                }
            }else{
                for (int i = arr.length - 1; i >= 0; i--) {
                    ans.add(arr[i][col]);
                }
            }
            topToBottom = !topToBottom;
        }

        return ans;
	}


    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println(wavePrint(mat));
    }
}
