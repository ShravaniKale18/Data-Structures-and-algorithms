class Node{
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackImplementationUsingLinkedList {
    
    Node top;
    int size = 0;

    void push(int x) {
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
        size++;
    }


    int pop() {

        if (top == null) {
            return -1;
        }

        int element = top.data;
        top = top.next;
        size--;

        return element;
    }

    int top() {
        if (top == null) {
            return -1;
        }
        return top.data;
    }

    public static void main(String[] args) {

        StackImplementationUsingLinkedList stack = new StackImplementationUsingLinkedList();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Top element
        System.out.println("Top: " + stack.top());

        // Pop elements
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        // Top after popping
        System.out.println("Top: " + stack.top());

        // Push another element
        stack.push(40);

        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        // Empty stack
        System.out.println("Pop from empty stack: " + stack.pop());

    }
}
