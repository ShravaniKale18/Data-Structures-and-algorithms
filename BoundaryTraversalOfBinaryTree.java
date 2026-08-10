import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}


public class BoundaryTraversalOfBinaryTree {
    public static List<Integer> traverseBoundary(Node root){

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        if (root.left == null && root.right == null) {
            list.add(root.data);
            return list;
        }

        list.add(root.data);

        Node curr = root.left;

        while (curr != null) {
            if (curr.left != null || curr.right != null) {
                list.add(curr.data);
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        addLeaves(root, list);
        List<Integer> rightBoundary = new ArrayList<>();

        curr = root.right;

        while (curr != null) {
            if (curr.left != null || curr.right != null) {
                rightBoundary.add(curr.data);
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        for (int i = rightBoundary.size() - 1; i >= 0; i--) {
            list.add(rightBoundary.get(i));
        }

        return list;
    }

    static void addLeaves(Node curr, List<Integer> list) {

        if (curr == null) {
            return;
        }

        if (curr.left == null && curr.right == null) {
            list.add(curr.data);
            return;
        }

        addLeaves(curr.left, list);
        addLeaves(curr.right, list);
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        System.out.println(traverseBoundary(root));
    }
}
