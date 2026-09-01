import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/** 
 * Approach:
 * 1. Convert each row of the binary matrix into a histogram representation, where the height of each bar corresponds to the number of consecutive '1's in that column up to the current row.
 * 2. For each row's histogram representation, calculate the largest rectangle area using the Largest Rectangle in Histogram algorithm.
 * 3. Keep track of the maximum area found across all rows. 
 * 4. Return the maximum area as the result.
 
 * The time complexity of this approach is O(n * m), where n is the number of rows and m is the number of columns in the matrix. The space complexity is O(m) for storing the histogram representation of each row.
 * SC: O(m) for storing the histogram representation of each row.
 */

public class MaximalRectangle {

    static int maximalRectangle(char[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxArea = 0;
        int n = matrix.length; // number of rows
        int m = matrix[0].length; // number of columns
        int[][] prefixSum = new int[n][m];

        for(int j = 0; j < m; j++) {
            int sum = 0;

            for(int i = 0; i < n; i++) {
                
                if(matrix[i][j] == '0') { // Reset the sum if we encounter a '0'
                   sum = 0;
                } else {
                    sum++; // Increment the sum for consecutive '1's
                }

                prefixSum[i][j] = sum; // Store the count of consecutive '1's in the current column up to the current row
            }   
        }

        for(int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, largestHistogramArea(prefixSum[i])); // Calculate the largest rectangle area for each row's histogram representation
        }


        return maxArea;
    }

    
    static int largestHistogramArea(int[] heights) {
        int maxArea = 0;

        int[] prevSmaller = previoussmallerElement(heights); // Get the indices of the previous smaller elements for each bar in the histogram
        int[] nextSmaller = nextSmallerElement(heights); // Get the indices of the next smaller elements for each bar in the histogram

        for(int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nextSmaller[i] - prevSmaller[i] - 1)); // Calculate the area of the rectangle with height heights[i] and width determined by the distance between the next and previous smaller elements
        }

        return maxArea;
    }

    static int[] nextSmallerElement(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> nextSmallerMap = new HashMap<>();


        for(int i = 0; i < heights.length; i++) {

            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                nextSmallerMap.put(stack.pop(), i);
            }

            stack.push(i);
        }

        int[] nextSmaller = new int[heights.length];

        for(int i = 0; i < heights.length; i++) {
            nextSmaller[i] = nextSmallerMap.getOrDefault(i, heights.length);
        }
        return nextSmaller;
    }

    static int[] previoussmallerElement(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> prevSmallerMap = new HashMap<>();


        for(int i = 0; i < heights.length; i++) {

            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                prevSmallerMap.put(i, stack.peek());
            }

            stack.push(i);
        }

        int[] prevSmaller = new int[heights.length];

        for(int i = 0; i < heights.length; i++) {
            prevSmaller[i] = prevSmallerMap.getOrDefault(i, -1);
        }
        return prevSmaller;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        int maxArea = maximalRectangle(matrix);
        System.out.println("Maximal Rectangle Area: " + maxArea);
    }
}
