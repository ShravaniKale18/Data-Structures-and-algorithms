package Trees;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

/**
 * Approach:
 * - Use recursion to find the maximum path sum starting from each node.
 * - For every node, calculate the maximum contribution from its left and right subtrees.
 * - Ignore negative subtree contributions using Math.max(0, pathSum).
 * - A path passing through the current node can include both left and right paths:
 *      leftPath + root.data + rightPath
 * - Update the global maximum with this value.
 * - Return only one side (left or right) to the parent because a path
 *   going upward cannot split into both children.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */

public class MaximumPathSum {

    static int findMaxSum(Node root) {

        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;

        maxPath(root, maxValue);

        return maxValue[0];

    }

    static int maxPath(Node root, int[] maxValue) {
        if (root == null) {
            return 0;
        }

        int leftPath = Math.max(0, maxPath(root.left, maxValue));
        int rightPath = Math.max(0, maxPath(root.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], leftPath + rightPath + root.data);

        return root.data + Math.max(leftPath, rightPath);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(50);
        root.left.right = new Node(100);

        System.out.println(findMaxSum(root));
    }
}
