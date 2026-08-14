import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class Node{
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
public class BinaryTraversalOfBinaryTree {

    static List<Integer> traverseBoundary(Node root){

        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            // List<Integer> ans = new ArrayList<>();

            Node curr = stack.pop();

            if (curr.left != null) {
                list.add(curr.data);
            }

            if (curr.right != null) {
                list.add(curr.data);
            }

        }

        System.out.println(list);

        return list;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);


        System.out.println(traverseBoundary(root));

    }
}
