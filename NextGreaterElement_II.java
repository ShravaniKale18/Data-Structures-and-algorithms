import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_II {

    /** 
     * TC => O(N^2)
     * SC => O(N)
     */

    static int[] nextGreaterElements1(int[] nums) {
        
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                int index = (i + j) % nums.length;

                if (nums[index] > nums[i]) {
                    arr[i] = nums[index];
                    break;
                }
            }
        }

        return arr;
    }

    /**
     * Approach:
     * Use a monotonic decreasing stack to store indices of elements
     * whose next greater element has not been found yet.
     *
     * Traverse the array twice to handle its circular nature.
     * For each element, pop smaller elements from the stack and
     * assign the current element as their next greater element.
     *
     * TC: O(n) - Each index is pushed and popped at most once.
     * SC: O(n) - Stack and result array
     */
    static int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);

        stack.push(0);

        for (int i = 1; i < 2 * nums.length; i++) {

            int index =  i % nums.length;

            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {

                int previousIndex = stack.pop();
                arr[previousIndex] = nums[index]; 

            }

            if (i < nums.length) {
                stack.push(index);
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};

        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
