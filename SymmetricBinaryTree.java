class Node{
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

/**
 * Approach:
 *
 * - If root is null, return true.
 *
 * - Use a helper function isMirror() to compare
 *   the left and right subtrees.
 *
 * - In isMirror():
 *      1. If both nodes are null, return true.
 *      2. If one node is null, return false.
 *      3. Check if left.data == right.data.
 *      4. Recursively compare opposite children:
 *            left.left  with right.right
 *            left.right with right.left
 *
 * - If all the above conditions are satisfied,
 *   the tree is symmetric.
 *
 * TC = O(N)
 * SC = O(H), where H is the height of the tree.
 */

public class SymmetricBinaryTree {

    static boolean isSymmetric(Node root) {

        if (root == null) {
            return true;
        }

        return isMirrer(root.left, root.right);
    }


    static boolean isMirrer(Node left, Node right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.data == right.data && isMirrer(left.left, right.right) && isMirrer(left.right, right.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println(isSymmetric(root));
    }
}
