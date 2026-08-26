public class TrappingRainWater {

    /**
     * Approach:
     *
     * 1. Find the leftMax and rightMax arrays.
     *    - leftMax[i] stores the maximum height from index 0 to i.
     *    - rightMax[i] stores the maximum height from index i to n-1.
     * 2. Initialize leftMax with the element at index 0.
     * 3. Initialize rightMax at index n-1 with the element at index n-1.
     * 4. Build the leftMax array by traversing from left to right.
     * 5. Build the rightMax array by traversing from right to left.
     * 6. For each index, calculate trapped water:
     *    water = min(leftMax[i], rightMax[i]) - height[i]
     * 7. Add the water at every index to get the total trapped water.
     * TC: O(n)
     * SC: O(n)
     */

    static int trap1(int[] height) {
        
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // System.out.println(Arrays.toString(leftMax));

        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // System.out.println(Arrays.toString(rightMax));


        int water = 0;

        for (int i = 0; i < height.length; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }

   /**
     * Approach:
     *
     * 1. Use two pointers: left and right.
     * 2. Maintain leftMax and rightMax to store the maximum
     *    height seen from the left and right respectively.
     * 3. If height[left] <= height[right], process the left side
     *    because the left side is the limiting boundary.
     * 4. If height[left] > height[right], process the right side
     *    because the right side is the limiting boundary.
     * 5. If the current height is smaller than its corresponding
     *    maximum boundary, add the difference to water.
     * 6. Otherwise, update the corresponding maximum height.
     *
     * TC: O(n)
     * SC: O(1)
     */
    static int trap(int[] height) {

        int water = 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (leftMax > height[left]) {
                    water += leftMax - height[left];
                }else{
                    leftMax = height[left];
                }
                left++;
            }else{
                if (rightMax > height[right]) {
                    water += rightMax - height[right];
                }else{
                    rightMax = height[right];
                }

                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));
    }
}
