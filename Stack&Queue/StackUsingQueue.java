import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> queue = new LinkedList<>();

    void push(int x) {

        queue.offer(x);

        int size = queue.size();

        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    int pop() {

        if (queue.isEmpty()) {
            return -1;
        }

        return queue.poll();
    }

    int top() {

        if (queue.isEmpty()) {
            return -1;
        }

        return queue.peek();
    }

    public static void main(String[] args) {

        StackUsingQueue stack = new StackUsingQueue();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.top()); // 30

        System.out.println(stack.pop()); // 30
        System.out.println(stack.pop()); // 20
        System.out.println(stack.pop()); // 10
        System.out.println(stack.pop()); // -1
    }
}