public class BringElementsLessOrEqualToK {
    /**
     * Approach:
     *
     * - Count the number of elements less than or equal to k.
     * - Use this count as the window size.
     * - Count valid elements in the first window.
     * - Slide the window and keep track of the maximum number
     *   of valid elements in any window.
     * - The elements greater than k inside the best window
     *   are the minimum swaps required.
     *
     * TC => O(N)
     * SC => O(1)
     */
    static int minSwap(int[] nums, int k) {

        int lessOREqualCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= k) {
                lessOREqualCount++;
            }
        }

        int windowSize = lessOREqualCount, currentCount = 0;

        for (int i = 0; i < windowSize; i++) {
            if (nums[i] <= k) {
                currentCount++;
            }
        }

        int maxCount = currentCount;

        for (int i = 0; i < nums.length - windowSize; i++) {
            if (nums[i] <= k) {
                currentCount--;
            }

            if (nums[i + windowSize] <= k) {
                currentCount++;
            }

            maxCount = Math.max(maxCount, currentCount);
        }

        return windowSize - maxCount;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 3};
        int k = 3;

        System.out.println(minSwap(arr, k));
    }
}
