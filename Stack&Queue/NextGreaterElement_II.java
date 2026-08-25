import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_II {

    static int[] nextGreaterElement(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        int n = nums.length;

        Arrays.fill(result, -1);
        for(int i = 0; i < 2 * nums.length; i++) {

            int current = i % nums.length;

            while (!stack.isEmpty() && nums[current] > nums[stack.peek()]) {

                int index = stack.pop();
                result[index] = nums[current]; 
            }

            if(i < n) {
                stack.push(current);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};

        System.out.println(Arrays.toString(nextGreaterElement(nums1)));
    }
}
