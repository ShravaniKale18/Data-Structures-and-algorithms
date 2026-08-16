import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    /**
     * Approach:
     * Use a monotonic decreasing stack to store indices of days
     * whose next warmer temperature has not been found yet.
     *
     * For each temperature, while the current temperature is warmer
     * than the temperature at the stack's top index, pop that index
     * and calculate the number of days waited.
     *
     * TC: O(n) - Each index is pushed and popped at most once.
     * SC: O(n) - Stack can contain up to n indices.
     */

    static int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] days = new int[temperatures.length];

        stack.push(0);

        for (int i = 1; i < days.length; i++) {
            // if (temperatures[i] > temperatures[i - 1]) {
            //     stack.push(i);
            // }else{
            //     int previousIndex = stack.pop();

            //     int numberOfDays = i - previousIndex;
            // }

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int previousIndex = stack.pop();

                days[previousIndex] = i - previousIndex;
            }

            stack.push(i);
        }

        return days;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
