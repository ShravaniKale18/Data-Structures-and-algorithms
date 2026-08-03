class Node{
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


public class BalancedBinaryTree {

    /**
     * Approach (Optimized):
     * 1. Traverse the tree using post-order traversal (Left -> Right -> Root).
     * 2. Recursively calculate the height of the left subtree.
     * 3. If the left subtree is unbalanced, return -1 immediately.
     * 4. Recursively calculate the height of the right subtree.
     * 5. If the right subtree is unbalanced, return -1 immediately.
     * 6. Check the height difference between the left and right subtrees.
     *    - If the difference is greater than 1, return -1 (tree is unbalanced).
     * 7. Otherwise, return the height of the current node:
     *        1 + max(leftHeight, rightHeight)
     * 8. In the main function, if maxDepth(root) returns -1, the tree is not balanced;
     *    otherwise, it is balanced.
     *
     * Time Complexity: O(N)
     * - Each node is visited exactly once.
     *
     * Space Complexity: O(H)
     * - H is the height of the tree due to the recursive call stack.
     * - Worst Case (Skewed Tree): O(N)
     * - Balanced Tree: O(log N)
     */

    static boolean isBalanced(Node root) {

        return maxDepth(root) != -1;
    }

    static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = maxDepth(root.left);

        if (lh == -1) {
            return -1;
        }

        int rh = maxDepth(root.right);

        if (rh == -1) {
            return -1;
        }

        if (Math.abs(lh - rh) > 1) {
            return -1;
        }

        return 1 + Math.max(lh, rh);
        
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(isBalanced(root));

    }
}
