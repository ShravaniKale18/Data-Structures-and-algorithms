public class ContainerWithMostWater {

    static int maxArea(int[] heights) {
        int n = heights.length;

        int left = 0;
        int right = n - 1;
        int maxWater = 0;

        while (left < right) {

            int width = right - left;
            int currentHeight = Math.min(heights[left], heights[right]);

            int currentArea = width * currentHeight;

            if (currentArea > maxWater) {
                maxWater = currentArea;
            }


            if (heights[left] < heights[right]) {
                left++;
            }else{
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(heights));
    }
}
