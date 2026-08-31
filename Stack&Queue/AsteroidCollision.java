import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            }else{

                boolean isAlive = true;

                while (!stack.isEmpty() && stack.peek() > 0) {

                    int topElement = stack.peek();

                    if (topElement > Math.abs(asteroids[i])) {
                        isAlive = false;
                        break;
                    }else if (topElement == Math.abs(asteroids[i])) {
                        stack.pop();
                        isAlive = false;
                        break;
                    }else{
                        stack.pop();
                        continue;
                    }
                }

                if (isAlive) {
                    stack.push(asteroids[i]);
                }
            }
        }

        while (!stack.isEmpty()) {
            ans.add(0, stack.pop());
        }

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};

        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
}
