/*
 * Approach: Recursion
 *
 * If root == null, return null.
 * Swap the left and right children.
 * Recursively invert the left subtree.
 * Recursively invert the right subtree.
 * Return root.
 *
 * TC => O(N)
 * SC => O(H)
 */

class Node{
    int data;
    Node left;
    Node right;


    Node(int data) {
        this.data = data;
        left = right = null;
    }
}


public class InvertBinaryTree {

    static Node invertTree(Node root) {

        if (root == null) {
            return null;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);

        System.out.println(invertTree(root));
    }
}
