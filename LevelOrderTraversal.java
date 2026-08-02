import java.util.*;


class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class LevelOrderTraversal {

    static void levelOrderTraversal(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if(tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if(tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is:");
        levelOrderTraversal(root);
    }
}
