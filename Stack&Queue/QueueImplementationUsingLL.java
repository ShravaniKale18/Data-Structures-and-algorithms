class Node{
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


public class QueueImplementationUsingLL {

    Node front;
    Node rare;

    void push(int x) {
        Node temp = new Node(x);

        if (front == null) {
            front = temp;
            rare = temp;
            return;
        }

        rare.next = temp;
        rare = temp;
    }

    int pop() {

        if (front == null) {
            return -1;
        }

        int element = front.data;

        if (front == rare) {
            front = null;
            rare = null;
            return element;
        }
        front = front.next;

        return element;
    }

    int top() {
        if (front == null) {
            return -1;
        }

        return front.data;
    }

    public static void main(String[] args) {
        
        QueueImplementationUsingLL q = new QueueImplementationUsingLL();

        q.push(10);
        q.push(20);
        q.push(30);

        System.out.println("Top: " + q.top());

        System.out.println("Pop: " + q.pop()); 
        System.out.println("Pop: " + q.pop()); 
        System.out.println("Pop: " + q.pop()); 

        System.out.println("Pop: " + q.pop());
    }
}
