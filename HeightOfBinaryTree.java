class Node{
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


public class HeightOfBinaryTree{

    /**
     * Approach:
     * 1. If the current node is null, return 0 because an empty tree has height 0.
     * 2. Recursively find the height of the left subtree.
     * 3. Recursively find the height of the right subtree.
     * 4. The height of the current node is:
     *        1 + max(leftHeight, rightHeight)
     *    where 1 represents the current node.
     * 5. Return the calculated height to the parent call.
     *
     * Time Complexity: O(N)
     * - Every node is visited exactly once.
     *
     * Space Complexity: O(H)
     * - H is the height of the tree due to the recursive call stack.
     * - Worst Case (Skewed Tree): O(N)
     * - Best/Average Case (Balanced Tree): O(log N)
     */

    static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(10);

        System.out.println(maxDepth(root));

    }
}