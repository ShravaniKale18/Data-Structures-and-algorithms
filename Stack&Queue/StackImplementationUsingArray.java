public class StackImplementationUsingArray {

    int top = -1;
    int[] stack = new int[10];

    void push(int x) {

        if (top == stack.length - 1) {
            return;
        }

        top = top + 1;
        stack[top] = x;
    }

    void pop() {
        if (top < 0) {
            return;
        }

        top = top - 1;
    }

    int size() {
        if (top < 0) {
            return -1;
        }

        return top + 1;
    }

    int top() {
        if (top < 0) {
            return -1;
        }

        return stack[top];
    }
    public static void main(String[] args) {
        
        StackImplementationUsingArray s = new StackImplementationUsingArray();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println(s.top()); 
        System.out.println(s.size()); 

        s.pop();

        System.out.println(s.top());  
        System.out.println(s.size());  
    }
}
