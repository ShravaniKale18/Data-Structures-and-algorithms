import java.util.*;

public class SlidingWindowMaximum {

    /** 
     * Time Complexity: O(n - k) * O(K) = O(nk)
     * Space Complexity: O(k)
     */

    static int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        for(int i = 0; i < n - k + 1; i++) {
            int max = nums[i];

            for(int j = i; j < k + i; j++) {
                max = Math.max(max, nums[j]);
            }

            result[i] = max;
        }

        return result;
    }

    /** 
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    
    static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {

            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                result[idx++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
