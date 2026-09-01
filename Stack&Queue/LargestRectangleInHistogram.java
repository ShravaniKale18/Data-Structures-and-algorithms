import java.util.*;

public class LargestRectangleInHistogram {

    /**
     * TC: O(n)
     * SC: O(n)
     */

    static int largestRectangleArea1(int[] heights) {
        int maxArea = 0;

        int[] prevSmaller = previoussmallerElement(heights);
        int[] nextSmaller = nextSmallerElement(heights);

        for(int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nextSmaller[i] - prevSmaller[i] - 1));
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

    /** 
     * TC: O(n)
     * SC: O(n)
     */
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

    static int largestRectangleArea(int[] heights) {

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i <= heights.length; i++) {

            while(!stack.isEmpty() && (i == heights.length || heights[i] < heights[stack.peek()])) {

                int height = heights[stack.pop()];
                int nextSmaller = i;
                int prevSmaller = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, height * (nextSmaller - prevSmaller - 1));
            }

            if(i < heights.length) {
                stack.push(i);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] heights = {2, 1, 5, 6, 2, 3};
        int maxArea = largestRectangleArea(heights);
        System.out.println("The largest rectangle area is: " + maxArea);
    }
}
