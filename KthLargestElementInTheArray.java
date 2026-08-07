import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInTheArray {

    /** 
     * Approach
     * 
     * Sort the Array
     * and then return the element at length - k positon
     * 
     * Tc - O(N log N)
     * sc = O(N)
     */
    static int findKthLargest1(int[] nums, int k) {

        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    /**
     * Approach:
     *
     * - Create a Min Heap (PriorityQueue).
     * - Traverse the array and insert every element into the heap.
     * - If the heap size becomes greater than k,
     *   remove the smallest element.
     * - After processing all elements, the heap contains
     *   the k largest elements.
     * - The root of the Min Heap is the k-th largest element.
     *
     * TC: O(N log K)
     * SC: O(K)
     */

    static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.element();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4}; //1, 2, 3, 4, 5, 6
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }
}
