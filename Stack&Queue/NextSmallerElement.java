import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    static int[] nextSmallerElement(int[] arr, int n){

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(result, -1);

        for(int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                result[i] = arr[stack.peek()];
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 4};

        System.out.println(Arrays.toString(nextSmallerElement(arr, arr.length)));
    }
}
