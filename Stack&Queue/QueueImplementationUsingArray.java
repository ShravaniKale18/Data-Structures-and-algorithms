public class QueueImplementationUsingArray {

    int size = 10;
    int[] queue = new int[size];
    int front = -1, rare = -1;

    void push(int x) {
        if (front == -1 && rare == -1) {
            front = 0;
            rare = 0;
        }else if (rare == size - 1) {
            return;
        }else{
            rare++;
        }
        queue[rare] = x;
    }


    int pop() {
        if (front == -1) {
            return -1;
        }   

        int ele = queue[front];
        
        if (front == rare) {
            front = -1;
            rare = -1;
            return ele;
        }
        front = front + 1;

        return ele;
    }

    int peek(){

        if (front == -1) {
            return -1;
        }

        return queue[front];
    }

    public static void main(String[] args) {
        QueueImplementationUsingArray q = new QueueImplementationUsingArray();

        q.push(10);
        q.push(20);
        q.push(30);

        System.out.println(q.pop());
        System.out.println(q.peek());

    }
}
