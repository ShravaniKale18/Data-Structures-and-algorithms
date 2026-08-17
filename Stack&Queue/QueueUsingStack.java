import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    void push(int x) {

        // Move elements from stack1 to stack2
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }

        // Insert new element
        stack1.push(x);

        // Move elements back to stack1
        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
    }

    int pop() {
        if (stack1.size() == 0) {
            return -1;
        }

        return stack1.pop();
    }

    int top() {
        if (stack1.size() == 0) {
            return -1;
        }

        return stack1.peek();
    }

    public static void main(String[] args) {

        QueueUsingStack q = new QueueUsingStack();

        q.push(10);
        q.push(20);
        q.push(30);

        System.out.println(q.top()); 
        System.out.println(q.pop()); 
        System.out.println(q.pop()); 
        System.out.println(q.top()); 
    }
}