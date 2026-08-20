import java.util.Stack;

public class MinStack {

    // static void MinStack() {
        
    // }
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();
    
    static void push(int value) {
        stack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }
    
    static int pop() {
        int element = stack.pop();

        if (element == minStack.peek()) {
            return minStack.pop();
        }

        return element;
    }
    
    static int top() {
        return stack.peek();
    }
    
    static int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        push(5);
        push(3);
        push(7);
        push(2);

        System.out.println("Minimum: " + getMin());

        pop();

        System.out.println("Minimum: " + getMin()); 
        System.out.println("Top: " + top());
    }
}
